package game.pow211;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;
import javax.swing.MenuSelectionManager;


public class RunGUI {

	NullLayout2048 NullLayout2048;
	ShowRanking ShowRanking;
//	GameSelectView GameSelectView;

	public static void main(String[] args) {

//		GameSelectView gs = new GameSelectView();
		
		RunGUI run1 = new RunGUI();
		Game2048Manager gm = new Game2048Manager(); 
		gm.gameManager();
		
		//run1.NullLayout2048 = new NullLayout2048();
		
	}

	public void ShowRanking() {
		NullLayout2048.dispose();
		this.ShowRanking = new ShowRanking();
	}

	public void NullLayout2048() {
		ShowRanking.dispose();
		this.NullLayout2048 = new NullLayout2048();
	}

}
