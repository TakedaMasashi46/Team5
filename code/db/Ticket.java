package db;

public class Ticket {
	
	private int ticketNumber;			//チケット番号
	private String ticketName;			//チケット名
	private int price;					//価格
	private String date;				//開催日
	private int stock;					//在庫
	
	
	
	public int getTicketNumber() {
		return this.ticketNumber;
	}
	/*public String getTicketNumber() {
		return String.valueOf(this.ticketNumber);
	}*/
	
	
	public String getTicketName() {
		return this.ticketName;
	}
	
	public String showTicketDate() {
		
		String str="チケット番号:"+ticketNumber+"="+"チケット名:"+ticketName+"="+"価格:"+price+"="+"開催日:"+ date+"="+"在庫:"+stock;
		
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
