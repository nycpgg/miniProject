package game.maze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;


public class GameControl implements KeyListener, ActionListener{

	private GameState gamestate; //미로상태
	private ShowMaze showmaze;   //output-view of the game
	private int[][] gameArray;   //게임상태를 저장하는 배열
	private int[] player;        //플레이어 위치를 저장하는 배열
	private String playerInputKey = ""; //키보드 입력상태를 저장하는 변수
	private int count = 0;
	
	
	
	public int getCount() {
		return count;
	}
			
	public GameControl(){
		
	}
	
	public GameControl(GameState gamestate, ShowMaze showmaze)
	{
		this.gamestate = gamestate;
		this.showmaze = showmaze;
		gameArray = gamestate.getArray();
		player = gamestate.getPlayerState();
		count = gamestate.getCount();
		
	}
	
	/** run 메소드는 사용자로 부터 방향을 입력받아 게임상의 플레이어를 옮겨준다.*/
	public void run(KeyEvent event)
	{
		int playerInput; //입력받은 String값을 int형으로 바꾸어 줄값

		//플레이어의 현재 위치 저장
		int xP = player[1];
		int yP = player[0];

		 //입력받은 문자를 저장
		playerInputKey = event.getKeyChar() +"";
		System.out.println(playerInputKey+"");
		//입력받은 위치 String값을 int로 바꾸어 준다.
		playerInput = Integer.parseInt(playerInputKey);	//들어온 키값을 int형으로 바꿔준다
		
		xP = changePositionX(xP, playerInput);
		yP = changePositionY(yP, playerInput);
		System.out.println( xP+"  "+yP+""); //현재 위치 테스트용
		
		//바뀔 위치가 갈수 있는 자리면 위치를 바꾸어 주고 repaint해준다.
		
		
		
		if(isOkChange(xP, yP) == true)
		{	
			if(playerInput == 4 || playerInput == 6 || 			// 다른키눌러도 점수올라가던
					playerInput == 5 || playerInput == 8){		// 버그수정방안
			player[1] = xP;
			player[0] = yP;
			gamestate.setPlayerState(player);			
			count++;
			System.out.println("count :"+count);
			
			gamestate.setCount(count);
			
			showmaze.getScoreNumLbl().setText(count+"");
			showmaze.repaint();
			}
			
			if(playerInput == 0){	//리셋할경우 점수와 강아지의 위치를 초기화 시킨다
				count = 0;
				showmaze.getScoreNumLbl().setText(count+"");
				
				//player의 위치를 초기화
				player[0] = 1;
				player[1] = 1;
								
				gamestate.setPlayerState(player);
								
				showmaze.repaint();				
			}
			
		}
		//종료조건 : 바뀔 위치가 종료조건에 부합하면 종료한다.
		//if(checkEndCondition(player[1], player[0]) == true)
		if(player[1] ==15 && player[0] ==12)	//종료지점 4가 있는 곳
		{
			JOptionPane.showMessageDialog(null,"멍멍!");
			gamestate.setCount(count);
				/*종료시키는 것*/
			//System.exit(0);
			//다음거로 넘어가는걸!
			
			//여기서 끝내지말고 내부의 메뉴를 선택할수 있어야 한다!
					
		}
	}
	
	/** 아무 키나 눌린 경우를 처리한다.
	  * -KeyListener 인터페이스 메소드의 구현*/
	public void keyPressed(KeyEvent event)
	{
		
		
	}
	
	/** 아무키나 놓여진 경우를 처리한다.
	  * -KeyListener 인터페이스 메소드의 구현*/
	public void keyReleased(KeyEvent event)
	{
	}
	
	/** action키가 아닌 키가 눌려진 경우를 처리한다.
	  * KeyListener 인터페이스 메소드의 구현*/
	public void keyTyped(KeyEvent event)
	{
		run(event);
	}
	
	/** changePositionX 메소드는 입력받은 방향으로 부터 x좌표 위치 변화                    를 감지하여 바꾸어 준다.
	  * @param xp - 현재 플레이어의 x좌표값
	  * @param pi - 사용자로 부터 입력받은  옮길 위치값 
	  * @return - int형의 바뀐 x좌표값 */
	
	public int changePositionX(int xp, int pi)
	{
		if(pi == 4) 
		{
			xp -= 1;
			return xp;
		}
		if(pi == 6)
		{
			xp += 1;
			return xp;
		}
		return xp;
	}
	
	/** changePositionY메소드는 입력받은 방향으로 부터 y좌표 위치 변화를                  감지하여 바꾸어 준다.
	  * @param yp - 현재 츨레이어싀 
	  * @param pi - 사용자로 부터 입력받은  옮길 위치값 
	  * @return - int형의 바뀐 y좌표값 */
	
	public int changePositionY(int yp, int pi)
	{
		if(pi == 8)
		{
			yp -= 1;
			return yp;
		}
		if(pi == 5)
		{
			yp += 1;
			return yp;
		}
		return yp;
	}
	
//	public void resetPosition(int pi){
//		if(pi == 0) gamestate.setCount(0);
//	}
	
	
	/** isOKChange 메소드는 옮겨간 좌표가 길인지 확인하여 준다.
	  * @param xp - 옮길 player의 x좌표
	  * @param yp - 옮길 player의 y좌표
	  * @return true - 길 일경우
	  * @return false - 벽 일경우*/
	
	public boolean isOkChange(int xp, int yp)
	{	
		if(gameArray[yp][xp] == 1 || gameArray[yp][xp] == 3 || gameArray[yp][xp] == 4)	//길이거나 출발점이거나 종료지점이거나
		{
			return true;
		}
		return false;
	}
	/** @param xp - player의 x좌표
	  * @param yp - player의 y좌표
	  * @return true - 종료조건에 맞을 경우
	  * @return false - 종료조건에 맞지 않을 경우*/

	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {//메인메뉴로 갈방법을 찾아보자
		
		
	}

	

	
		
	}

	

	
	
	
	
	

	
	
	
	
	
