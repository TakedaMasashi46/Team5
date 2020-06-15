package domain;

import java.util.ArrayList;

import db.FileMember;

public class MemberList {
	
	
	//ユーザー情報をクラス型で　持っておく　リストとか
	ArrayList<Member> memberList =new ArrayList<Member>();

	public MemberList() {
	}
	
	
	public Member checkID(String ID) {
		
		for(Member m:memberList ) {			
			if(ID.equals(m.getMemberID())) {
				return m;								//メンバーオブジェクト返す
			}
		}		
		return null;		
	}
	
	//Memberオブジェクトを生成する
	public Member setMember(String userID,String password) {
		Member member = new Member(userID,password);
		memberList.add(member);
		return member;
	}
	
	public void addMember(Member member) {
		memberList.add(member);
	}
	
	//ファイルから取得したメンバーリストをシステムのメンバーリストの追加する
	public void downlodeMemberData(ArrayList<Member> fileMemberList) {
		for(Member m :fileMemberList) {
			memberList.add(m);
		}
	}
	
	//システムのメンバーリストをファイルに追加する
	public ArrayList<Member> updateMemberData(ArrayList<Member> fileMemberList) {
		for(Member m :memberList) {
			fileMemberList.add(m);
		}
		return fileMemberList;
	}
	
}

