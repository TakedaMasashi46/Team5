package db;

public class Member {
	
	private String userID;
	private String password;
	
	public void Member(String ID,String pass) {
		
		this.userID=ID;
		this.password=pass;
	}
	
	public String getMemberID() {
		return this.userID;
	}
	
	public boolean getMmberPass(String pass) {
		if(this.password==pass) {
			return true;
		}
		else return false;
	}
	
}
