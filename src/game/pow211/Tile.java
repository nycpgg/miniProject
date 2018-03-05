package game.pow211;

public class Tile {
	private int num;

	public Tile(){
		this.num=0;
	}
	public Tile(int num){
		this.num=num;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString(){
		String result=String.format("[ %3d   ]",num) ;
		return result;
	}
	
}
