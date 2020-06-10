package domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
	private static int counter=1;
	private int reservationNumber;//予約番号
	private String name;//会員名
	private String ticketName;//チケット名
	private String reservationDate;//予約日
	private int  reservationMaisu;//予約枚数
	
	//予約番号、会員名、チケット名、予約日、予約枚数
	public Reservation(String userName,Ticket ticket,int selectNumOfTicket) {
		
		String ticketName=ticket.getTicketName();									//予約情報とチケット間で依存関係あり
		
		this.reservationNumber=counter;
		counter++;
		this.name=userName;
		this.ticketName=ticketName;
       
		//予約日取得
		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		this.reservationDate=dateFormat.format(date);
		this.reservationMaisu=selectNumOfTicket;
		
		//予約枚数を在庫から引く
		ticket.minusTicketStock(selectNumOfTicket);									
		
	}
	
	public String showReservationData() {
		String data="予約番号:"+this.reservationNumber+"="+"会員名:"+this.name+"="+"チケット名:"+this.ticketName+"="+"予約日:"+this.reservationDate+"="+"予約枚数:"+this.reservationMaisu;
		
		return data;
	}

}
