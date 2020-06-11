
package domain;

import java.io.Serializable;

public class Member implements Serializable{
	
	private String userID;
	private String password;
	
	public Member(String ID,String pass) {
		
		this.userID=ID;
		this.password=pass;
	}
	
	public String getMemberID() {
		return this.userID;
	}
	
	public boolean getMemberPass(String pass) {
		if(this.password.equals(pass)) {
			return true;
		}
		else return false;
	}
	
	//test
	public String strgetMemberPass() {
		return password;
	}
	
}
