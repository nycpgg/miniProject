package member.joinMenuCreating;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

import member.memeberAddtion.MemberManager;

public class JoinMenu_GUI extends JFrame {

	private JPanel title = new JPanel();
	private JPanel idPane = new JPanel();
	private JPanel pwPane = new JPanel();
	private JPanel nNamePane = new JPanel();
	private JButton joinBtn = new JButton("회원가입");
	private JButton returnBtn = new JButton("메인메뉴로");
	private JButton IdExist = new JButton("중복체크");
	private JButton nNameExist = new JButton("중복체크");
	private MemberManager mManager = new MemberManager();

	private boolean isIdOk = false;
	private boolean isnNameOk = false;

	public JoinMenu_GUI() {
		this.setLayout(null);
		this.setBounds(100, 100, 500, 500);

		JLabel titleLbl = new JLabel("회 원 가 입");
		Font font = new Font("굴림", Font.BOLD, 30);
		titleLbl.setFont(font);
		title.setBounds(100, 30, 300, 50);
		title.add(titleLbl);
		// ----------------------id, pw, nName 패널(start)----------------
		JTextField idTxt = new JTextField(15);
		JPasswordField pwTxt = new JPasswordField(15);
		JTextField nNameTxt = new JTextField(15);

//		JLabel idLabel = new JLabel();
//		idLabel.setText("ID");
//		idLabel.setFont(idLabel.getFont().deriveFont(20.0f));
//		
//		
//		idPane.add(idLabel);
		idPane.add(new JLabel("ID"));
		idPane.add(idTxt);
		pwPane.add(new JLabel("PW"));
		pwPane.add(pwTxt);
		nNamePane.add(new JLabel("닉네임"));
		nNamePane.add(nNameTxt);

		idPane.setBounds(114, 130, 236, 50);
		pwPane.setBounds(114, 180, 236, 50);
		nNamePane.setBounds(100, 232, 250, 50);
		// ----------------------id, pw, nName 패널(end)----------------

		// ----------------------메뉴버튼(start)--------------------

		joinBtn.setBounds(130, 300, 100, 30);
		returnBtn.setBounds(250, 300, 100, 30);

		IdExist.setBounds(357, 132, 100, 25);
		nNameExist.setBounds(357, 232, 100, 25);

		joinBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isIdOk == true && isnNameOk == true) {
					String id = idTxt.getText();
					String pw = String.valueOf(pwTxt.getPassword());
					String nName = nNameTxt.getText();

					mManager.addMember(id, pw, nName);
					JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다");
					

					// 멤버추가 확인용 메소드
					System.out.println(mManager.getMemberList());
				} else {
					JOptionPane.showMessageDialog(null, "아이디와 닉네임 중복체크를 해주세요");
				}

			}

		});

		returnBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "메인메뉴로 돌아갑니다");

				// 여기에 메인메뉴로 돌아갈수 있게 해야한다!! 혹은 이 창만 닫히게하면된다
				if(e.getSource() == returnBtn){
					dispose();
				}
			}

		});

		// ----------------------메뉴버튼(end)--------------------

		// ----------------------id중복체크(start)--------------------

		IdExist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String inputId = idTxt.getText();

				for (int i = 0; i < mManager.getMemberList().size(); i++) {
					String existId = mManager.getMemberList().get(i).getId();
					if (inputId.equals(existId)) {
						JOptionPane.showMessageDialog(null, "아이디가 중복되었습니다");
						isIdOk = false;
					} else {
						JOptionPane.showMessageDialog(null, "사용할수 있는 아이디 입니다");
						isIdOk = true;
					}

				}
			}

		});

		// ----------------------id중복체크(end)--------------------

		// ----------------------nName중복체크(start)--------------------

		nNameExist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String inputnName = nNameTxt.getText();

				for (int i = 0; i < mManager.getMemberList().size(); i++) {
					String existnName = mManager.getMemberList().get(i).getnName();
					if (inputnName.equals(existnName)) {
						JOptionPane.showMessageDialog(null, "닉네임이 중복되었습니다");
						isnNameOk = false;
					} else {
						JOptionPane.showMessageDialog(null, "사용할수 있는 닉네임 입니다");
						isnNameOk = true;
					}

				}
			}

		});
		// ----------------------nName중복체크(end)--------------------

		getContentPane().add(title);
		getContentPane().add(idPane);
		getContentPane().add(pwPane);
		getContentPane().add(nNamePane);
		getContentPane().add(joinBtn);
		getContentPane().add(returnBtn);
		getContentPane().add(IdExist);
		getContentPane().add(nNameExist);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}

}
