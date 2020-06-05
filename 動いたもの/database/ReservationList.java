package database;

import java.util.ArrayList;

public class ReservationList {
	
	//予約情報の型でリスト保存
	ArrayList<Reservation> reservationList =new ArrayList<Reservation>();
	
	
	//予約番号、会員名、チケット名、予約日、予約枚数
	public Reservation createReservation(String userName,Ticket ticket, String date, int selectNumOfTicket) {
		
		Reservation re=new Reservation(userName,ticket,date,selectNumOfTicket);
		
		reservationList.add(re);
		
		return re;
	}
	
	public Reservation get(int num) {
		return reservationList.get(num);
	}
	

	
}
