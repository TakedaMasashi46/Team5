package database;

import java.util.ArrayList;

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
	
	
	//金子テスト用追加 リスト内要素リターン
	public Member getMember(int idx) {
		return memberList.get(idx);
	}
	
}
