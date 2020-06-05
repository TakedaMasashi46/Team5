package database;

public class Reservation {
	
	private static int counter=1;
	private int reservNumber;//予約番号
	private String name;//会員名
	private String ticketName;//チケット名
	private String ticketDate;//予約日
	private int  reservMaisu;//予約枚数
	
	//予約番号、会員名、チケット名、予約日、予約枚数
	public Reservation(String userName,Ticket ticket,String date,int selectNumOfTicket) {
		
		String ticketName=ticket.getTicketName();									//予約情報とチケット間で依存関係あり
		
		this.reservNumber=counter;
		counter++;
		this.name=userName;
		this.ticketName=ticketName;
		this.ticketDate=date;
		this.reservMaisu=selectNumOfTicket;
		
		ticket.minusTicketStock(selectNumOfTicket);									//予約枚数を在庫から引く
		
	}
	
	public String showReservationData() {
		String data="予約番号:"+this.reservNumber+"="+"会員名:"+this.name+"="+"チケット名:"+this.ticketName+"="+"予約日:"+this.ticketDate+"="+"予約枚数:"+this.reservMaisu;
		
		return data;
	}
	
	
	
}
