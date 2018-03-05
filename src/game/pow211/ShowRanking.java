package game.pow211;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ShowRanking extends JFrame {

	// private NullLayout2048 main;
	private boolean game2048;

	public ShowRanking() {

		// this.main = main;

		this.setTitle("Rank");
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel wholePanel = new JPanel();

		wholePanel.setLayout(null);
		wholePanel.setBounds(0, 0, 1000, 700);
		wholePanel.setBackground(Color.white);

		getContentPane().add(wholePanel);

		JPanel rankingTextPanel = new JPanel();

		rankingTextPanel.setBounds(385, 50, 230, 70);
		rankingTextPanel.setBackground(Color.white);

		JLabel rankTitle = new JLabel("Ranking");
		rankTitle.setBackground(Color.white);
		rankTitle.setFont(rankTitle.getFont().deriveFont(50.0f)); // 글자 크기
		rankTitle.setBorder(BorderFactory.createEmptyBorder());

		rankingTextPanel.add(rankTitle);

		wholePanel.add(rankingTextPanel);

		JButton gameSelect = new JButton("Game 2048");
		gameSelect.setBounds(840, 10, 120, 50);
		gameSelect.setBackground(Color.white);
		gameSelect.setFont(rankTitle.getFont().deriveFont(12.0f)); // 글자 크기
		gameSelect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == gameSelect) {
					JOptionPane.showMessageDialog(wholePanel, "2048 화면으로 이동합니다.");
					game2048 = true;

					if (isGame2048()) {
						// ShowRanking.NullLayout2048();
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Faild");
					}
				}
			}
		});

		wholePanel.add(gameSelect);

		JPanel rankPanel = new JPanel(); // 랭킹 순위 표시를 위한 패널
		rankPanel.setLayout(null);
		rankPanel.setBackground(Color.white);
		rankPanel.setBounds(50, 150, 888, 450);

		wholePanel.add(rankPanel);

		JTextField ranker1 = new JTextField("asdfasdfasdf"); // 1등 위치
		ranker1.setBounds(0, 60, 888, 50);
		ranker1.setFont(rankTitle.getFont().deriveFont(25.0f)); // 글자 크기
		ranker1.setBackground(Color.white);
		ranker1.setEditable(false);

		rankPanel.add(ranker1);

		JTextField ranker2 = new JTextField("asdfasdfasdf"); // 2등 위치
		ranker2.setFont(ranker2.getFont().deriveFont(25.0f));
		ranker2.setBackground(Color.white);
		ranker2.setBounds(0, 130, 888, 50);
		ranker2.setEditable(false);

		rankPanel.add(ranker2);

		JTextField ranker3 = new JTextField("asdfasdfasdf"); // 3등 위치
		ranker3.setFont(ranker3.getFont().deriveFont(25.0f));
		ranker3.setBackground(Color.white);
		ranker3.setBounds(0, 200, 888, 50);
		ranker3.setEditable(false);

		rankPanel.add(ranker3);

		JTextField ranker4 = new JTextField("asdfasdfasdf"); // 4등 위치
		ranker4.setFont(ranker4.getFont().deriveFont(25.0f));
		ranker4.setBackground(Color.white);
		ranker4.setBounds(0, 270, 888, 50);
		ranker4.setEditable(false);

		rankPanel.add(ranker4);

		JTextField ranker5 = new JTextField("asdfasdfasdf");// 5등 위치
		ranker5.setFont(ranker5.getFont().deriveFont(25.0f));
		ranker5.setBackground(Color.white);
		ranker5.setBounds(0, 340, 888, 50);
		ranker5.setEditable(false);

		rankPanel.add(ranker5);

		this.setVisible(true);

	}
	/*
	 * public void setMain(RunGUI run) { this.ShowRanking = run; }
	 */

	public boolean isGame2048() {
		return game2048;
	}

}
