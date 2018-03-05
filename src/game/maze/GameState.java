package game.maze;

public class GameState {
	/** GameState 클래스는 플레이어와 미로의 상태를 가지고 있다.*/
	
	private int[][] gameArray = new int[16][17];
	private int[] player = new int[2];
	private int count = 0;
	
	/** GameState의 constructor는 미로로 사용할 배열을 생성하고
	  * 플레이어 데이터를 초기화 한다.
	  * 배열의 0은 벽이고, 1은 길, 3은 시작, 4는 끝을 나타낸다. */
	
	public GameState(){
		
		
		int[][]
	           ga = {{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	        	     {0,3,0,1,1,1,1,1,1,1,0,1,1,1,0,1,0},
	        	     {0,1,0,1,0,0,0,0,0,1,0,1,0,1,0,1,0},
	        	     {0,1,0,1,1,1,1,1,0,1,0,1,0,1,1,1,0},
	        	     {0,1,0,0,0,0,0,1,0,1,1,1,0,1,0,1,0},
		          	 {0,1,0,1,1,1,0,1,0,0,0,0,0,1,0,1,0},
		          	 {0,1,0,1,0,1,1,1,1,1,1,1,0,1,0,1,0},
		          	 {0,1,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0},
		          	 {0,1,1,1,0,1,0,1,1,1,0,1,0,1,1,1,0},
		          	 {0,0,0,0,0,1,0,1,0,1,0,1,0,0,0,1,0},
		          	 {0,1,1,1,1,1,0,1,0,1,1,1,0,0,0,1,0},
		          	 {0,1,0,0,0,0,0,1,0,0,0,1,1,1,0,1,0},
		          	 {0,1,0,1,1,1,1,1,0,1,0,1,0,0,0,4,0},
		          	 {0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0},
		          	 {0,1,0,1,1,1,1,1,1,1,0,1,0,0,0,0,0},
		          	 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
		player[0] = 1; //플레이어 상태 초기화
		player[1] = 1; //플레이어 상태 초기화
		gameArray = ga;
		for(int i = 0;  i < 16; i++){
			for(int j = 0; j < 17; j++){
				System.out.print(gameArray[i][j]);
			}System.out.println();
		}
	}//컨스트럭터 메소드 끝
	
	/** getArray 메소드는 미로 배열을 넘겨준다.*/
	public int[][] getArray(){
		return gameArray;
	}

	/** getPlayerState는 플레이어 상태 배열을 넘겨준다.*/
	public int[] getPlayerState(){
		return player;
	}

	/** setPlayerState는 넘겨받은 플레이어 상태 배열을 바꾸어준다.*/
	public void setPlayerState(int[] player){
		this.player = player;
	}
	public int getCount(){
		return count;
	}
	public void setCount(int count){
		this.count = count;
	}
	
}
