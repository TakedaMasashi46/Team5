package db;

import java.util.ArrayList;

public class MemberList {
	
	
	//ユーザー情報をクラス型で　持っておく　リストとか
	ArrayList<Member> memberList =new ArrayList<Member>();

	public MemberList() {
		memberList.add(new Member());
	}
	
	
	public Member checkID(String ID) {
		
		for(Member m:memberList ) {			
			if(ID==m.getMemberID()) {
				return m;								//メンバーオブジェクト返す
			}
		}		
		return null;		
	}
	
	
	
	
}
