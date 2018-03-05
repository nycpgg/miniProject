package game.maze;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

/** showMaze 는 게임판과 미로를 그려주는 클레스입니다.*/
public class ShowMaze extends JPanel {

	private int WIDTH = 1000;  	//전체 프레임의 가로크기
	private int HEIGHT = 700;	//전체 프레임의 세로크기
	private GameState gamestate;
	private int[] player;  //플레이어의 위치 저장 배열
	private int count;
	
	private JLabel scoreNumLbl = new JLabel();	//점수표시
	private JLabel infoStr = new JLabel();
	private JLabel infoTxtLbl = new JLabel();	//키안내1
	private JLabel infoTxtLbl2 = new JLabel();	//키안내2
	private JLabel infoResetLbl = new JLabel();	//리셋키안내
	
	private JButton mainMenuBtn = new JButton();
	
	
	
	//이미지 로딩및 적재
	Image bone = new ImageIcon("images/bone.png").getImage();			//뼈다귀 이미지
	Image dog = new ImageIcon("images/dog.png").getImage();			//강아지 이미지
	Image DogHouse = new ImageIcon("images/DogHouse.png").getImage();	//개집 이미지
	
	
	/** ShowMaze의 Constructor는 프레임을 만들어 준다.
	 * @param gs - 게임상태를 저장*/
	GameControl gc = new GameControl();
	
	public ShowMaze(GameState gamestate){
		this.gamestate = gamestate;
		
		player = gamestate.getPlayerState();
		count = gamestate.getCount();
		
		JFrame gameFrame = new JFrame();
		gameFrame.setBackground(Color.WHITE);
		gameFrame.setBounds(500,500,WIDTH, HEIGHT);
	    gameFrame.setLayout(null);
		
	    this.setBounds(0, 0, 430, 700);
		
		gameFrame.getContentPane().add(this);
//-----------------------Score----------------------------------
		JPanel scoreTxt = new JPanel();
		JLabel scoreTxtLbl = new JLabel("Score");	
		scoreTxt.setBackground(Color.ORANGE);	//score표시창의 색
		scoreTxt.setBounds(450,50,50,50);	//score표시창의 크기
//-----------------------Score----------------------------------
//-----------------------실제점수(Start)---------------------------------		
		
		//키보드 입력횟수를 score에 넣어야 한다!
		
		JPanel scoreNum = new JPanel();
			
		scoreNumLbl.setText(String.valueOf(gamestate.getCount()));
			
		scoreTxt.add(scoreTxtLbl);
		scoreTxt.add(scoreNumLbl);
		
//-----------------------실제점수(End)---------------------------------		
//-----------------------안내문구(start)-------------------------------
		JPanel info = new JPanel();
		infoStr.setText("조 작 키 안 내");
		
		JPanel infoTxt = new JPanel();
		infoTxtLbl.setText("위 : 8   아래 : 5");
		
		JPanel infoTxt2 = new JPanel();
		infoTxtLbl2.setText("좌 : 4    우 : 6");
		
		JPanel infoReset = new JPanel();
		infoResetLbl.setText("리셋 : 0");
		
		info.setBounds(430,130,100,30);			//"조작키안내" 문구의 위치와 크기
		infoTxt.setBounds(430, 160, 100, 30);	// "위:8, 아래:5" 위치와 크기
		infoTxt2.setBounds(430, 190, 100, 30);	// "좌:4, 우:6" 위치와 크키
		infoReset.setBounds(430,220,100,30);	// "리셋 : 0"    	위치와 크기
		
		info.setBackground(Color.YELLOW);
		infoTxt.setBackground(Color.LIGHT_GRAY);
		infoTxt2.setBackground(Color.LIGHT_GRAY);
		infoReset.setBackground(Color.LIGHT_GRAY);
		
		info.add(infoStr);
		infoTxt.add(infoTxtLbl);		// "위:8, 아래:5" 
		infoTxt2.add(infoTxtLbl2);		// "좌:4, 우:6" 	
		infoReset.add(infoResetLbl);	// "리셋 : 0"    	
			
		
//-----------------------안내문구(end)---------------------------------
//-----------------------메인메뉴 버튼(start)----------------------------
		mainMenuBtn.setText("메인메뉴로");
		mainMenuBtn.setBounds(430, 330, 100, 30);
		
//-----------------------메인메뉴 버튼(end)-----------------------------
		gameFrame.add(scoreTxt);	//score라는 text를 넣었다
		gameFrame.add(scoreNum);	//실제 점수를 넣었다
		
		gameFrame.add(info);
		gameFrame.add(infoTxt);		/*키설명 문구 추가했다*/
		gameFrame.add(infoTxt2);	
		gameFrame.add(infoReset);	//리셋키 설명 추가했다
		//gameFrame.add(mainMenuBtn);	//리셋버튼이다 KeyListener와 버튼이 충돌하나..?
		gameFrame.setTitle("MazeBone");
		
	    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    gameFrame.setVisible(true);
		gameFrame.addKeyListener(new GameControl(gamestate, this));	
		//KeyListener 와  충돌을 피할 방법은??
		
	}
	
	/** paintConponent는 프레임의 미로와 케릭터를 그려준다.*/
	public void paintComponent(Graphics g){
		Font NormalFont = new Font("굴림", Font.BOLD, 20);//글씨체와 크기
		
		g.setFont(NormalFont);
		g.setColor(Color.white);									//배경색
		g.fillRect(0, 0, WIDTH, WIDTH);								//크기조정하기
		g.drawImage(DogHouse, 55, 0, 40, 40, this);						//개집의 이미지 크기 조정
		g.drawImage(bone, 310, 310, 75, 55, this);					//뼈의 이미지 크기 조정
		
		g.setColor(Color.black);									//글씨의 색 ....근데 위에 같은 g.setColor가 있는데 중복되지 않지?
		//g.drawString("키는 위:8, 아래:5, 좌:4, 우:6 입니다.",50, 400);		//(String, x좌표, y좌표)
		//미로 공간확보를 위해 설명키 옆으로 옮기기
				
		drawMaze(g); 	//미로를 그린다.
		drawDog(g);  	//게임 캐릭터를 그린다.
		
	}
	
	/** drawMaze는 미로를 그려준다.*/
	public void drawMaze(Graphics g){	//벽그리기
		g.setColor(Color.BLUE);
		g.fillRect(40, 40, 20, 20*16); //좌
		g.fillRect(40 + 20*16 , 40, 20, 20*13); //우
        g.fillRect(40 + 20*2, 40, 20*15, 20); //상
		g.fillRect(40, 40 + 20*15, 20*13, 20); //하

		g.fillRect(40 + 20*2, 40, 20, 20*8); //세로1
		g.fillRect(40 + 20*4, 40 + 20*6, 20, 20*4); //세로2
		g.fillRect(40 + 20*6, 40 + 20*4, 20, 20*2); //세로3
		g.fillRect(40 + 20*8, 40 + 20*2, 20, 20*4); //세로4
		g.fillRect(40 + 20*10, 40 + 20*1, 20, 20*3); //세로5
		g.fillRect(40 + 20*12, 40 + 20*2, 20, 20*9); //세로6
		g.fillRect(40 + 20*14, 40 , 20, 20*3); //세로7
		g.fillRect(40 + 20*14, 40 + 20*4, 20, 20*4); //세로8
		g.fillRect(40 + 20*10, 40 + 20*7, 20, 20*3); //세로9
		g.fillRect(40 + 20*10, 40 + 20*11, 20, 20*5); //세로10
		g.fillRect(40 + 20*12, 40 + 20*12, 20, 20*4); //세로11
		g.fillRect(40 + 20*8, 40 + 20*9, 20, 20*5); //세로12
		g.fillRect(40 + 20*6, 40 + 20*7, 20, 20*5); //세로13
		g.fillRect(40 + 20*2, 40 + 20*11, 20, 20*5); //세로14
		g.fillRect(40 + 20*14, 40 + 20*9, 20, 20*4); //세로15
		g.fillRect(40, 40 + 20*9, 20*5, 20); //가로1
		g.fillRect(40 + 20*2, 40 + 20*4, 20*5, 20); //가로2
		g.fillRect(40 + 20*4, 40 + 20*2, 20*5, 20); //가로3
		g.fillRect(40 + 20*6, 40 + 20*7, 20*5, 20); //가로4
		g.fillRect(40 + 20*8, 40 + 20*5, 20*5, 20); //가로5
		g.fillRect(40 + 20*14, 40 + 20*7, 20*3, 20); //가로6
		g.fillRect(40 + 20*12, 40 + 20*9, 20*3, 20*2); //가로7
		g.fillRect(40 + 20*12, 40 + 20*12, 20*3, 20); //가로8
		g.fillRect(40 + 20*8, 40 + 20*11, 20*3, 20); //가로9
		g.fillRect(40 + 20*4, 40 + 20*13, 20*5, 20); //가로10
		g.fillRect(40 + 20*2, 40 + 20*11, 20*5, 20); //가로11
	}
	
	//움직이는 강아지 그려준다
	public void drawDog(Graphics g){
		//g.setColor(Color.black);  //이건뭐지?
		g.drawImage(dog, 40+20*player[1], 40+20*player[0], 20, 20, this);	//(이미지 , x좌표, y좌표, 크기, 크기 , oberserber????)
		//g.fillOval(40+20*player[1], 40+20*player[0], 20, 20);

	}
	
	
	public JLabel getScoreNumLbl() {
		return scoreNumLbl;
	}

	public void setScoreNumLbl(JLabel scoreNumLbl) {
		this.scoreNumLbl = scoreNumLbl;
	}
	
	
	
	
}
