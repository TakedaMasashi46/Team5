package database;

public class Ticket {
	
	private int ticketNumber;			//チケット番号
	private String ticketName;			//チケット名
	private int price;					//価格
	private String eventDate;				//開催日
	private int stock;					//在庫
	
	
	public Ticket(int tNum,String tName,int price,String date,int stock) {
		this.ticketNumber=tNum;
		this.ticketName=tName;
		this.price=price;
		this.eventDate=date;
		this.stock=stock;
	}
	
	public int getTicketNumber() {
		return this.ticketNumber;
	}
	
	public String getTicketName() {
		return this.ticketName;
	}
	
	public String showTicketData() {
		
		String str="チケット番号:"+ticketNumber+"="+"チケット名:"+ticketName+"="+"価格:"+price+"="+"開催日:"+ eventDate+"="+"在庫:"+stock;
		
		return str;
	}
	
	public int getTicketStock() {
		return this.stock;
	}
	
	//予約枚数を在庫から引く
	public void minusTicketStock(int selectNumOfTicket) {
		this.stock -=selectNumOfTicket;
	}
	
	
}
