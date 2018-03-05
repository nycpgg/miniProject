package member.memeberAddtion;

import java.io.*;
import java.util.*;

public class MemberManager {

	private ArrayList<Member> memberList = new ArrayList();
	private Member member;
	
	
	
	public MemberManager(){
		memberList.add(new Member("admin","1234","administrator",100,100,100));
	}
	public MemberManager(ArrayList memberList){
		this.memberList= memberList;
	}
	
	
//------------Getter & Setter---------------------	
	public ArrayList<Member> getMemberList(){
		return memberList;
	}
	
		
	public void addMember(String id, String pw, String nName){//멤버정보를 객체단위로 Member.dat에 저장하자
		memberList.add(new Member(id,pw,nName,0,0,0));
		
		try(ObjectOutputStream saveMember = new ObjectOutputStream(new FileOutputStream("Member.dat")))
		{
			for(Member member : memberList){
				saveMember.writeObject(member);
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public void printMember(){
		System.out.println(memberList);
	}
	
	
	
	
}
