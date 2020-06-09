package domain;

import java.util.ArrayList;

public class MemberList {
	
	//ユーザー情報をクラス型で　持っておく　リストとか
	ArrayList<Member> memberList =new ArrayList<Member>();

	public MemberList() {
	}
	
	public Member checkID(String ID) {
		
		for(Member m:memberList ) {
			if(ID.equals(m.getMemberID()))return m;//メンバーオブジェクト返す
		}
		return null;
	}
	
	//金子テスト用追加 リスト内要素リターン
	public Member getMember(int idx) {
		return memberList.get(idx);
	}

	public Member setMember(String id, String pass) {
		memberList.add(new Member(id,pass));
		//新しくリスト追加したメンバーを取得
		Member member=memberList.get(0);
		return member;
	}
	
}
