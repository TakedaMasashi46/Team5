package database;

import java.util.ArrayList;

public class TicketList {
	
	
	
	ArrayList<Ticket> ticketList =new ArrayList<Ticket>();
	
	public TicketList() {
		ticketList.add(new Ticket(1, "水族館", 1000, "2020-6-6", 20));
		ticketList.add(new Ticket(2,"映画館",3000,"2020-07-10",50));
		ticketList.add(new Ticket(3,"美術館",800,"2020-08-12",10));

	}
	
	public String showTicketNumberName() {
		String data = "チケット名:チケット番号=";
		
		for(Ticket t:ticketList) {
			data+=t.getTicketName();
			data+=":";
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
		String data="";
		for(Ticket t:ticketList) {
			data+=t.showTicketDate();
			data+="=";
			data+="---------"; 
			data+="=";
		}
		return data;
	}
	
}