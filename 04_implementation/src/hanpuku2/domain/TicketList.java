package domain;

import java.util.ArrayList;

public class TicketList {
	
	ArrayList<Ticket> ticketList =new ArrayList<Ticket>();
	
	public TicketList() {
	}
	
	//チケット名：チケット番号を表示　（チケット選択の時）
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
	
	//リストに含まれるチケットオブジェクトを取得
	public Ticket getTicket(int num) {
		
		for(Ticket t:ticketList ) {			
			if(num == t.getTicketNumber()) {
				return t;								//メンバーオブジェクト返す
			}
		}
		return null;
	}
	
	//全てのチケット情報を表示
	public String showAllTicketData() {
		String data="";
		for(Ticket t:ticketList) {
			data+=t.showTicketData();
			data+="=";
			data+="---------"; 
			data+="=";
		}
		return data;
	}
	
	//ファイルから取得したチケットリストをシステムのチケットリストに追加
	public void douwnlodeTicketData(ArrayList<Ticket> fileTicketList) {
		for(int num=0;num < fileTicketList.size();) {
			Ticket ticket = fileTicketList.get(num);
			ticketList.add(ticket);
		}
	}
	
	//システムのチケットリストをファイルのチケットリストに追加
	public ArrayList<Ticket> updateTicketData (ArrayList<Ticket> fileTicketList) {
		for(int num=0;num < ticketList.size();) {
			Ticket newTicket = ticketList.get(num);
			fileTicketList.add(newTicket);
		}
		return fileTicketList;
	}
}

