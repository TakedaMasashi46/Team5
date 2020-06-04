package db;

import java.util.ArrayList;

public class TicketList {
	
	
	
	ArrayList<Ticket> ticketList =new ArrayList<Ticket>();
	
	public TicketList() {
	//	ticketList.add();
	}
	
	public String showTicketList() {
		String date = null;
		
		for(Ticket t:ticketList) {
			date+=t.getTicketName();
			date+=t.getTicketNumber();
			date+="=";
		}
		
		return date;
	}
	public Ticket getTicket(int num) {
		
		for(Ticket t:ticketList ) {			
			if(num == t.getTicketNumber()) {
				return t;								//メンバーオブジェクト返す
			}
		}		
		return null;
	}
	
	
}
