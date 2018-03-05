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

//	private GameSelectView GameSelectView;

	private ShowRanking ShowRanking;
	// private JFrame rankingJFrame;
	private boolean showRanking;
	private boolean gameSelect;

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

		JTextField[][] tf = new RoundJTextField[SIZE][SIZE];
		int setX = 88;
		int setY = 10;

		for (int i = 0; i < tf.length; i++) {
			for (int j = 0; j < tf[i].length; j++) {
				tf[i][j] = new RoundJTextField(15);
				tf[i][j].setColumns(10);
				tf[i][j].setBounds(setX, setY, 88, 88);
				tf[i][j].setEditable(false);
				tf[i][j].setText("0");
				tf[i][j].setForeground(Color.YELLOW);
				tf[i][j].setFont(new Font("바탕", Font.BOLD, 60));
				tf[i][j].setHorizontalAlignment(JTextField.CENTER);
				tf[i][j].setFocusable(false); // focus를 제거
				textFieldBig.add(tf[i][j]);

				setX = (setX + 100) % 400;
			}
			setY = (setY + 100) % 400;
		}

		getContentPane().add(textFieldBig, BorderLayout.SOUTH);

		/*
		 * textField = new RoundJTextField(15); textField.setColumns(10); //
		 * textField.setBorder(BorderFactory.createEmptyBorder()); // 경계선 제거 상태
		 * textField.setBounds(88, 10, 88, 88); textField.setEditable(false); //
		 * 수정 불가능하게 만듦 textFieldBig.add(textField);
		 * 
		 * textField_1 = new RoundJTextField(15); textField_1.setColumns(10); //
		 * textField_1.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		 * // 경계선 두께 5, 경계선 색상 = 빨강 textField_1.setBounds(188, 10, 88, 88);
		 * textField_1.setEditable(false); // 수정 불가능하게 만듦
		 * textFieldBig.add(textField_1);
		 * 
		 * textField_2 = new RoundJTextField(15); textField_2.setColumns(10); //
		 * textField_2.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		 * textField_2.setBounds(288, 10, 88, 88);
		 * textField_2.setEditable(false); // 수정 불가능하게 만듦
		 * textFieldBig.add(textField_2);
		 * 
		 * textField_3 = new RoundJTextField(15); textField_3.setColumns(10); //
		 * textField_3.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		 * textField_3.setBounds(388, 10, 88, 88);
		 * textField_3.setEditable(false); // 수정 불가능하게 만듦
		 * textFieldBig.add(textField_3);
		 * 
		 * textField_4 = new RoundJTextField(15); textField_4.setColumns(10); //
		 * textField_4.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		 * textField_4.setBounds(88, 110, 88, 88);
		 * textField_4.setEditable(false); // 수정 불가능하게 만듦
		 * textFieldBig.add(textField_4);
		 * 
		 * textField_5 = new RoundJTextField(15); textField_5.setColumns(10); //
		 * textField_5.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		 * textField_5.setBounds(188, 110, 88, 88);
		 * textField_5.setEditable(false); // 수정 불가능하게 만듦
		 * textFieldBig.add(textField_5);
		 * 
		 * textField_6 = new RoundJTextField(15); textField_6.setColumns(10); //
		 * textField_6.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		 * textField_6.setBounds(288, 110, 88, 88);
		 * textField_6.setEditable(false); // 수정 불가능하게 만듦
		 * textFieldBig.add(textField_6);
		 * 
		 * textField_7 = new RoundJTextField(15); textField_7.setColumns(10); //
		 * textField_7.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		 * textField_7.setBounds(388, 110, 88, 88);
		 * textField_7.setEditable(false); // 수정 불가능하게 만듦
		 * textFieldBig.add(textField_7);
		 * 
		 * textField_8 = new RoundJTextField(15); textField_8.setColumns(10); //
		 * textField_8.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		 * textField_8.setBounds(88, 210, 88, 88);
		 * textField_8.setEditable(false); // 수정 불가능하게 만듦
		 * textFieldBig.add(textField_8);
		 * 
		 * textField_9 = new RoundJTextField(15); textField_9.setColumns(10); //
		 * textField_9.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		 * textField_9.setBounds(188, 210, 88, 88);
		 * textField_9.setEditable(false); // 수정 불가능하게 만듦
		 * textFieldBig.add(textField_9);
		 * 
		 * textField_10 = new RoundJTextField(15); textField_10.setColumns(10);
		 * // textField_10.setBorder(BorderFactory.createLineBorder(Color.RED,
		 * 5)); textField_10.setBounds(288, 210, 88, 88);
		 * textField_10.setEditable(false); // 수정 불가능하게 만듦
		 * textFieldBig.add(textField_10);
		 * 
		 * textField_11 = new RoundJTextField(15); textField_11.setColumns(10);
		 * // textField_11.setBorder(BorderFactory.createLineBorder(Color.RED,
		 * 5)); textField_11.setBounds(388, 210, 88, 88);
		 * textField_11.setEditable(false); // 수정 불가능하게 만듦
		 * textFieldBig.add(textField_11);
		 * 
		 * textField_12 = new RoundJTextField(15); textField_12.setColumns(10);
		 * // textField_12.setBorder(BorderFactory.createLineBorder(Color.RED,
		 * 5)); textField_12.setBounds(88, 310, 88, 88);
		 * textField_12.setEditable(false); // 수정 불가능하게 만듦
		 * textFieldBig.add(textField_12);
		 * 
		 * textField_13 = new RoundJTextField(15); textField_13.setColumns(10);
		 * // textField_13.setBorder(BorderFactory.createLineBorder(Color.RED,
		 * 5)); textField_13.setBounds(188, 310, 88, 88);
		 * textField_13.setEditable(false); // 수정 불가능하게 만듦
		 * textFieldBig.add(textField_13);
		 * 
		 * textField_14 = new RoundJTextField(15); textField_14.setColumns(10);
		 * // textField_14.setBorder(BorderFactory.createLineBorder(Color.RED,
		 * 5)); textField_14.setBounds(288, 310, 88, 88);
		 * textField_14.setEditable(false); // 수정 불가능하게 만듦
		 * textFieldBig.add(textField_14);
		 * 
		 * textField_15 = new RoundJTextField(15); textField_15.setColumns(10);
		 * // textField_15.setBorder(BorderFactory.createLineBorder(Color.RED,
		 * 5)); textField_15.setBounds(388, 310, 88, 88);
		 * textField_15.setEditable(false); // 수정 불가능하게 만듦
		 * textFieldBig.add(textField_15);
		 * 
		 * getContentPane().add(textFieldBig, BorderLayout.SOUTH);
		 */
		/*
		 * //textField 이름으로 접근 for(int i =0 ;i<16;i++){ String str =
		 * Integer.valueOf(i).toString(); String tf = "textField_"+str; Object o
		 * = tf; ((JTextField)o).setText("0");
		 * 
		 * }
		 */
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
		System.out.println("snfflfa");
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			System.out.println("왼쪽 누름");
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			System.out.println("위쪽 누름");
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			System.out.println("오른쪽 누름");
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			System.out.println("아래쪽 누름");
		}
	}

}
