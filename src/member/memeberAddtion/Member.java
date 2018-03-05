package member.memeberAddtion;

import java.io.Serializable;

public class Member implements Serializable{

	private String id;
	private String pw;
	private String nName;
	private int score2048;
	private int scoreMaze;
	private int scoreSimon;
	
	public Member(){
		
	}
	public Member(String id, String pw, String nName, 
			int score2048, int scoreMaze, int scoreSimon){
		
		this.id = id;
		this.pw = pw;
		this.nName = nName;
		this.score2048 = score2048;
		this.scoreMaze = scoreMaze;
		this.scoreSimon = scoreSimon;
	}
	
//-------------Getter & Setter---------------------------
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getnName() {
		return nName;
	}
	public void setnName(String nName) {
		this.nName = nName;
	}
	public int getScore2048() {
		return score2048;
	}
	public void setScore2048(int score2048) {
		this.score2048 = score2048;
	}
	public int getScoreMaze() {
		return scoreMaze;
	}
	public void setScoreMaze(int scoreMaze) {
		this.scoreMaze = scoreMaze;
	}
	public int getScoreSimon() {
		return scoreSimon;
	}
	public void setScoreSimon(int scoreSimon) {
		this.scoreSimon = scoreSimon;
	}
//-------------Getter & Setter---------------------------	
	
	
	public String toString(){
		return "ID : "+id+"\tPW : "+pw+"\t닉네임 : "+nName+"\n"+
				"2048 : "+score2048+"\tBoneMaze : "+scoreMaze+"\tSimonGame : "+scoreSimon+"\n";
	}
	
	
	
	
}
