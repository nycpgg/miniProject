package member.joinMenuCreating;

import mainMenuCreating.MainMenu_GUI;
import member.memeberAddtion.MemberManager;

public class RunJoinMenu {

	public static void main(String[] args) {
		// 회원추가확인용
		RunJoinMenu run = new RunJoinMenu();
		run.showJoinMenu();
		
		MemberManager mm = new MemberManager();
		mm.printMember();

	}

	public void showJoinMenu() {
		JoinMenu_GUI gui = new JoinMenu_GUI();

	}

}
