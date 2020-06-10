package domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
	
	private int reservationNumber;//予約番号
	private Member member;//会員名
	private String ticketName;//チケット名
	private String reservationDate;//予約日
	private int  reservationMaisu;//予約枚数
	
	//予約番号、会員名、チケット名、予約日、予約枚数
	public Reservation(Member member,Ticket ticket,int selectNumOfTicket,int count ) {
		
		String ticketName=ticket.getTicketName();									//予約情報とチケット間で依存関係あり
		this.member =member;
		this.reservationNumber=count;
		this.member=member;
		 reservationMaisu =selectNumOfTicket;
		this.ticketName=ticketName;
       
		//予約日取得
		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		this.reservationDate=dateFormat.format(date);
		
		//予約枚数取得
		this.reservationMaisu=selectNumOfTicket;
		
		//予約枚数を在庫から引く
		ticket.minusTicketStock(selectNumOfTicket);									
		
	}
	
	public String showReservationData() {
		String data="予約番号:"+this.reservationNumber+"="+"会員名:"+this.member.getMemberID()+"="+"チケット名:"+this.ticketName+"="+"予約日:"+this.reservationDate+"="+"予約枚数:"+this.reservationMaisu;
		
		return data;
	}
	
	public Reservation getReservationDate(Reservation re,Member mm) {
		//ユーザーIDの取得 
		String userName = mm.getMemberID();//ログインした人のID
		String id = re.member.getMemberID();//その予約オブジェクトのID
		if(userName.equals(id)) {
			return re;//予約オブジェクト
		}
		else {//その予約オブジェクトのIDとログインした人のIDが異なる
			return null; 
		}
	}
	
}
