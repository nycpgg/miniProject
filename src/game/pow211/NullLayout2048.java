package game.pow211;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mainMenuCreating.GameSelectView;

public class NullLayout2048 extends JFrame implements KeyListener {

	// private RunGUI NullLayout2048;
	private JPanel nullPanel1, nullPanel2, nullPanel3;
	//public JTextField textFieldBig;
	public JPanel textFieldBig;
	private JPanel panel;
	
	private static final int SIZE = 4;
	static int score = 0, highScore = 0; // 현재 점수, 최고 점수
//	private GameSelectView GameSelectView;

	private ShowRanking ShowRanking;
	// private JFrame rankingJFrame;
	private boolean showRanking;
	private boolean gameSelect;
	private static Tile[][] tile;
	private static JTextField[][] tf;
	
	// private boolean game2048;

	public NullLayout2048() {

		setTitle("2048");
		setBounds(10, 10, 1000, 700);

		nullPanel1 = new JPanel();
		nullPanel1.setBounds(0, 0, 984, 235);
		nullPanel1.setBackground(Color.WHITE); // 위치 구분용 색상

		nullPanel1.setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon Icon2048 = new ImageIcon("images/2048-1.png"); // 이미지 삽입
		Image smallSize2048 = Icon2048.getImage();
		Image changed2048Img = smallSize2048.getScaledInstance(633, 200, Image.SCALE_SMOOTH);
		ImageIcon new2048Img = new ImageIcon(changed2048Img);

		JButton btn2048 = new JButton(new2048Img);
		btn2048.setLocation(10, 10);
		btn2048.setSize(633, 200);
		btn2048.setFocusable(false); // focus를 제거
		btn2048.setBorderPainted(false); // 버튼의 외곽선을 삭제

		btn2048.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == btn2048) {
					JOptionPane.showMessageDialog(nullPanel3, "Game Select 화면으로 이동합니다.");
					gameSelect = true;

					if (gameSelect) {
						dispose();
						new GameSelectView();
					} else {
						JOptionPane.showMessageDialog(null, "Faild");
					}
				}
			}
		});

		nullPanel1.add(btn2048);

		// 이미지 사이즈 조절 및 새로운 이미지 생성
		ImageIcon restartImg = new ImageIcon("images/재시작6.PNG"); // 이미지 삽입
		Image smallSizeRestartImg = restartImg.getImage();
		Image changedImg = smallSizeRestartImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon newImg = new ImageIcon(changedImg);

		JButton btnRestart = new JButton(newImg);
		btnRestart.setLocation(890, 160);
		btnRestart.setSize(50, 50);
		btnRestart.setBorderPainted(false); // 버튼의 외곽선을 삭제
		btnRestart.setFocusable(false); // focus를 제거
		btnRestart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == btnRestart) {
					JOptionPane.showMessageDialog(nullPanel3, "  New 게임을 시작합니다.");
					dispose();
					new NullLayout2048();
				}
			}
		});
		nullPanel1.add(btnRestart);

		ImageIcon RankingImg = new ImageIcon("images/Ranking4-1.png"); // 이미지 삽입
		Image smallSizeRankingImg = RankingImg.getImage();
		Image changedRankingImg = smallSizeRankingImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon newRankingImg = new ImageIcon(changedRankingImg);
				
		JButton btnRanking = new JButton(newRankingImg);
		btnRanking.setLocation(890, 100);
		btnRanking.setSize(50, 50);
		btnRanking.setBorderPainted(false); // 버튼의 외곽선을 삭제
		btnRanking.setFocusable(false); // focus를 제거
		btnRanking.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == btnRanking) {
					JOptionPane.showMessageDialog(nullPanel3, "Ranking 화면으로 이동합니다.");
					showRanking = true;

					if (isShowRanking()) {
						new ShowRanking();
						// NullLayout2048.ShowRanking();
					} else {
						JOptionPane.showMessageDialog(null, "Faild");
					}
				}
			}
		});

		nullPanel1.add(btnRanking);

		JLabel score = new JLabel("Score");
		score.setLocation(759, 44);
		score.setSize(85, 86);
		score.setFont(score.getFont().deriveFont(25.0f));
		// Font Size 조절
		nullPanel1.add(score);

		JTextField scoreBoard = new JTextField("");
		scoreBoard.setLocation(719, 114);
		scoreBoard.setSize(150, 96);
		scoreBoard.setBorder(BorderFactory.createLineBorder(Color.black));
		scoreBoard.setEditable(false); // 수정 불가능하게 만듦
		scoreBoard.setFocusable(false); // focus를 제거
		scoreBoard.setFont(scoreBoard.getFont().deriveFont(20.0f));
		// Font Size 조절
		nullPanel1.add(scoreBoard);
		getContentPane().setLayout(null);

		// nullPanel2 = new JPanel();
		// nullPanel2.setLayout(null);
		// nullPanel2.setLayout(new GridLayout(4, 4, 10, 10));
		//
		// nullPanel2.setBounds(0, 252, 684, 409);
		//
		// nullPanel2.setBackground(Color.LIGHT_GRAY); // 위치 구분용 색상
		//
		// getContentPane().add(nullPanel2);
		getContentPane().add(nullPanel1);

		//textFieldBig = new RoundJTextField(15);
		//textFieldBig.setColumns(20);
		
		textFieldBig = new RoundJPanel(15);
		textFieldBig.setLayout(null);
		textFieldBig.setBackground(Color.pink);
		textFieldBig.setBorder(BorderFactory.createLineBorder(Color.orange, 55));
		textFieldBig.setFocusable(false); // focus를 제거
		textFieldBig.setBounds(208, 242, 568, 409);
		//textFieldBig.setEditable(false);

		
		//tf TextField 배열 초기화
		tf = new RoundJTextField[SIZE][SIZE];
		int setX = 88;
		int setY = 10;

		for (int i = 0; i < tf.length; i++) {
			for (int j = 0; j < tf[i].length; j++) {
				tf[i][j] = new RoundJTextField(15);
				tf[i][j].setColumns(10);
				tf[i][j].setBounds(setX, setY, 88, 88);
				tf[i][j].setEditable(false);
				//tf[i][j].setForeground(Color.YELLOW);
				//tf[i][j].setText("0");
				tf[i][j].setText(null);
				tf[i][j].setFont(new Font("바탕", Font.BOLD, 60));
				tf[i][j].setHorizontalAlignment(JTextField.CENTER);
				tf[i][j].setFocusable(false); // focus를 제거
				textFieldBig.add(tf[i][j]);

				setX = (setX + 100) % 400;
			}
			setY = (setY + 100) % 400;
		}

		getContentPane().add(textFieldBig, BorderLayout.SOUTH);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 235, 984, 426);
		getContentPane().add(panel);

		nullPanel3 = new JPanel(); // 창 위치 잡는 용도의 패널
		nullPanel3.setBounds(350, 250, 300, 200);
		nullPanel3.setBackground(Color.WHITE); // 위치 구분용 색상

		nullPanel3.setLayout(null);
		add(nullPanel3);

		addKeyListener(this);  // KeyListener를 상속받은 상태
		this.setFocusable(true);  // focus를 락온		
		setFocusTraversalKeysEnabled(false);  // 다중 키를 인식해라
		this.setVisible(true);
		
		gameStarter();
	}

	/*
	 * public void setMain(RunGUI run) { this.NullLayout2048 = run; }
	 */

	public boolean isShowRanking() {
		return showRanking;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			System.out.println("왼쪽 누름");
			moveTile(tile, 0, 0, -1);
			System.out.println("최고점수 : " + highScore);
			System.out.println("현재점수 : " + score);
			tile = putRandom(tile);
			printTile(tile);
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			System.out.println("위쪽 누름");
			printTile(moveTile(tile, 0, -1, 0));
			System.out.println("최고점수 : " + highScore);
			System.out.println("현재점수 : " + score);
			tile = putRandom(tile);
			printTile(tile);
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			System.out.println("오른쪽 누름");
			moveTile(tile, SIZE * SIZE - 1, 0, 1);
			System.out.println("최고점수 : " + highScore);
			System.out.println("현재점수 : " + score);
			tile = putRandom(tile);
			printTile(tile);
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			System.out.println("아래쪽 누름");
			moveTile(tile, SIZE * SIZE - 1, 1, 0);
			System.out.println("최고점수 : " + highScore);
			System.out.println("현재점수 : " + score);
			tile = putRandom(tile);
			printTile(tile);
		}
	}
	

	public static boolean isEmpty(Tile[][] tile) {
		boolean result = false;
		
		//x
		for (int i = 0; i < tile.length; i++) {
			for (int j = 0; j < tile[i].length; j++) {
				if (tile[i][j].getNum() == 0) {
					result = true;
				}
			}
		}
		
		for (int i = 0; i < tf.length; i++) {
			for (int j = 0; j < tf[i].length; j++) {
				if (tf[i][j].getText() == null) {
					result = true;
				}
			}
		}
		
		
		return result;
	}

	// 랜덤 추출
	public static int[] random() {
		int[] random = new int[3];
		random[0] = (int) (Math.random() * 4);
		random[1] = (int) (Math.random() * 4);
		random[2] = (int) (Math.random() * 2) + 1;

		return random;
	}

	// 비어있는곳에 랜덤으로 숫자놓기
	public static Tile[][] putRandom(Tile[][] tile) {

		while (isEmpty(tile)) {
			int[] ran = random(); // ran[0]:세로 ran[1]:가로

			if (tile[ran[0]][ran[1]].getNum() == 0) {
				tile[ran[0]][ran[1]].setNum(ran[2] * 2);	//x
				tf[ran[0]][ran[1]].setText(Integer.toString(ran[2] * 2));
				System.out.println("============");
				return tile;
			}
		}
		System.out.println("더 이상 놓을자리가 없습니다");
		System.out.println("게임 종료");
		System.exit(0);
		return tile;
	}

	public static Tile[][] setGame() {

		Tile[][] tile = new Tile[4][4];

		for (int i = 0; i < tile.length; i++) {
			for (int j = 0; j < tile[i].length; j++) {
				tile[i][j] = new Tile();
			}
		}
		
		return tile;
	}

	public static void gameStarter() {
		System.out.println("2048 새 게임 시작");

		tile = setGame();
		
		tile = putRandom(tile);
		printTile(tile);

	}

	public static Tile[][] moveTile(Tile[][] tile, int reveres, int row, int col) {

		for (int k = 0; k < SIZE * SIZE; k++) {

			int temp = Math.abs(reveres - k);

			int i = temp / SIZE;
			int j = temp % SIZE;

			if (tile[i][j].getNum() == 0) {
				continue;
			}

			int nextRow = i + row;
			int nextCol = j + col;

			while (nextRow >= 0 && nextRow < SIZE && nextCol >= 0 && nextCol < SIZE) {
				Tile next = tile[nextRow][nextCol];

				// tile[i][j]가 0이 아니고 next가 0일때
				if (next.getNum() == 0) {
					next.setNum(next.getNum() + tile[i][j].getNum());
					tile[i][j].setNum(0);

					i = nextRow;
					j = nextCol;
					nextRow += row;
					nextCol += col;

				} else if (tile[i][j].getNum() == next.getNum()) {

					next.setNum(next.getNum() + tile[i][j].getNum());
					score += next.getNum();
					tile[i][j].setNum(0);

					i = nextRow;
					j = nextCol;
					nextRow += row;
					nextCol += col;

					if (score > highScore) {
						highScore = score;
					}
					break;
				} else {
					break;
				}

			}
		}

		return tile;
	}

	public static void printTile(Tile[][] tile) {
		for (int i = 0; i < tile.length; i++) {
			for (int j = 0; j < tile[i].length; j++) {
				System.out.print(tile[i][j]);
			}
			System.out.println();
		}
	}

}
