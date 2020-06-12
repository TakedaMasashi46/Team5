package domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Reservation implements Serializable{
	
	private int reservationNumber;//予約番号
	private Member member;//会員名
	private Ticket ticket;//チケット名
	private String reservationDate;//予約日
	private int reservationMaisu;//予約枚数
	private int reservationChildMaisu;
	private int sumPrice;
	
	//予約番号、会員名、チケット名、予約日、予約枚数
	public Reservation(Member member,Ticket ticket,int maisu, int maisuChild, int count,int sumPrice) {
									//予約情報とチケット間で依存関係あり
		this.member =member;
		this.reservationNumber=count;
		this.member=member;
		this.reservationMaisu = maisu;
		this.reservationChildMaisu = maisuChild;
		this.ticket=ticket;
		this.sumPrice=sumPrice;
       
		//予約日取得
		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		this.reservationDate=dateFormat.format(date);
		
		//予約枚数を在庫から引く
		ticket.minusTicketStock((reservationMaisu+reservationChildMaisu));									
		
	}
	
	public String showReservationData() {
		String data="予約番号:"+this.reservationNumber+"\n"+"会員名:"+this.member.getMemberID()+"\n"+"チケット名:"+this.ticket.getTicketName()+"\n"+"予約日:"+this.reservationDate+"\n"+
					"大人予約枚数:"+this.reservationMaisu+"\n"+"子供予約枚数:"+this.reservationChildMaisu+"\n"+"合計金額："+this.sumPrice+"\n";
		
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
	
	public Ticket getReservationTicket() {
		return ticket;
	}
	
	public int getReservationMaisu() {
		return reservationMaisu;
	}
	public int getReservationChildMaisu() {
		return reservationChildMaisu;
	}
	public String getReservationName() {
		return member.getMemberID();
	}
	
	public int getReservationNumber() {
		return reservationNumber;
	}
	
}
