package domain;


import java.util.ArrayList;

public class ReservationList {
	
	//予約情報の型でリスト保存
	ArrayList<Reservation> reservationList =new ArrayList<Reservation>();
	
	
	//予約番号、会員名、チケット名、予約枚数
	public Reservation createReservation(Member member,Ticket ticket, int selectNumOfTicket) {
		
		Reservation re=new Reservation(member,ticket,selectNumOfTicket);
		
		reservationList.add(re);
		
		return re;
	}
	
	//getReservationDate(reservationList.get(i),member);
	//                   ログインした人の予約オブジェクトリスト             ,ログインした会員のオブジェクト
	public ArrayList<Reservation> getReservation(Member member,ArrayList<Reservation> reLogin) {
		String data = null;
		for(int i=0;i<reservationList.size();i++) {
			Reservation keepReservation = reservationList.get(i).getReservationDate(reservationList.get(i),member);//予約オブジェクトが引数
			if(reLogin != null)reLogin.add(keepReservation);
		}
		return reLogin;
	}
	
	public void deleteReservation(int number) {
		reservationList.set(number, null);
	}
	
	
	
	public Reservation get(int num) {
		return reservationList.get(num);
	}
	
	
	


}
