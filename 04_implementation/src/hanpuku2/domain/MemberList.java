package domain;

import java.util.ArrayList;

import db.FileMember;

public class MemberList {
	
	
	//ユーザー情報をクラス型で　持っておく　リストとか
	ArrayList<Member> memberList =new ArrayList<Member>();

	public MemberList() {
		memberList.add(new Member("クレスコ明日","12345"));
		memberList.add(new Member("クレスコ今日","13579"));
		memberList.add(new Member("クレスコ昨日","02468"));
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
	public void setMember(String userID,String password) {
		Member member = new Member(userID,password);
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
		
		
		
	//金子テスト用追加 リスト内要素リターン
	public Member getMember(int idx) {
		return memberList.get(idx);
	}
	
}

