package db;

import java.util.ArrayList;

public class TicketList {
	
	
	
	ArrayList<Ticket> ticketList =new ArrayList<Ticket>();
	
	public TicketList() {
	//	ticketList.add();
	}
	
	public String showTicketNumberName() {
		String data = null;
		
		for(Ticket t:ticketList) {
			data+=t.getTicketName();
			data+=t.getTicketNumber();
			data+="=";
		}
		
		return data;
	}
	public Ticket getTicket(int num) {
		
		for(Ticket t:ticketList ) {			
			if(num == t.getTicketNumber()) {
				return t;								//メンバーオブジェクト返す
			}
		}		
		return null;
	}
	
	public String showAllTicketDate() {
		String data=null;
		for(Ticket t:ticketList) {
			data+=t.showTicketDate();
			data+="=";
		}
		return data;
	}
	
}
