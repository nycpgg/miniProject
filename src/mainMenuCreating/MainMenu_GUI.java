package mainMenuCreating;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import member.joinMenuCreating.RunJoinMenu;
import member.memeberAddtion.MemberManager;


public class MainMenu_GUI extends JFrame{

	private int frameWidth = 500;
	private int frameHeight = 500;
	private JPanel idPane = new JPanel();
	private JPanel pwPane = new JPanel();
	private JPanel imagePane = new JPanel();
	private JTextField idTxt = new JTextField(15);
	private JPasswordField pwTxt = new JPasswordField(15);
	private JButton logBtn = new JButton("Login");
	private JButton joinBtn = new JButton("Join");
	
	private MemberManager mManager = new MemberManager();
	
	
	Image finger = new ImageIcon("Finger.png").getImage();
	
	public MainMenu_GUI(){
		
		this.setLayout(null);
		JPanel title = new JPanel();
		JLabel titleLbl = new JLabel("The Finger Game");
		
		Font font = new Font("굴림", Font.BOLD,30);
		titleLbl.setFont(font);
			
		
		title.add(titleLbl);
		title.setBounds(100,30,300,50);
		
		
		
//-----------------------ID,PW창(start)-------------------------------		
		idPane.add(new JLabel("I  D"));
		idPane.add(idTxt);
		idPane.setBounds(100,300,200,50);	//아이디 위치
		
		
		pwPane.add(new JLabel("PW"));
		pwPane.add(pwTxt);
		pwPane.setBounds(100,350,200,50);	//pw 위치
//-----------------------ID,PW창(end)----------------------------------			
	
//-----------------------Login, Join 버튼(start)----------------------------------				
		logBtn.setBounds(320, 300, 70, 30);
		joinBtn.setBounds(320, 350, 70, 30);
		
		logBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String inputId = idTxt.getText();
				String inputPw = String.valueOf(pwTxt.getPassword());
				
				for(int i = 0; i < mManager.getMemberList().size(); i++){
					if( inputId.equals(mManager.getMemberList().get(i).getId()) && 
							inputPw.equals(mManager.getMemberList().get(i).getPw())){
						JOptionPane.showMessageDialog(imagePane, inputId+"님 환영합니다!");
						
						//여기에 게임메뉴로 넘어갈수 있게 하면 된다
						dispose();
						new GameSelectView();
					}
					else{
						JOptionPane.showMessageDialog(imagePane, "올바른 ID 혹은 PW가 아닙니다");
					}
				}
				
				
				
			}
			
		});
		
		joinBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//여기에 회원가입 메뉴로 넘어갈수 있게 하면된다.
				JOptionPane.showMessageDialog(imagePane, "회원가입메뉴로 이동합니다");
				RunJoinMenu run = new RunJoinMenu();
				run.showJoinMenu();
				
			}
			
		});
		
		
		
		
		
//-----------------------Login, Join 버튼(end)----------------------------------			
		JLabel imageLbl = new JLabel(new ImageIcon(finger));
		imagePane.add(imageLbl);
		imagePane.setBounds(140,100,200,200);
		
		
//-----------------------Frame설정(start)-------------------------------
		this.add(title);
		this.add(imagePane);
		this.add(logBtn);
		this.add(joinBtn);
		this.add(idPane);
		this.add(pwPane);
		this.setBounds(100,100,frameWidth,frameHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
//-----------------------Frame설정(end)-------------------------------		
		
	}
	
	
	
	
	
	
}
