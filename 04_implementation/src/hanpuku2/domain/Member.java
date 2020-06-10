package domain;


public class Member {
	
	private String userID;
	private String password;
	
	public Member(String ID,String pass) {
		
		this.userID=ID;
		this.password=pass;
	}
	
	public String getMemberID() {
		return this.userID;
	}
	
	public String getMemberPass() {
		return this.password;
	}
	
	public boolean getMmberPass(String pass) {
		if(this.password.equals(pass)) {
			return true;
		}
		else return false;
	}
	
	
	
//	public void setPass(String password) {
//		this.password = password;
//	}
//	
//	public void setID(String userID) {
//		this.userID = userID;
//	}
}

