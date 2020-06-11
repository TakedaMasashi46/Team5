package domain;


import java.util.ArrayList;

public class ReservationList {
	
	//予約情報の型でリスト保存
	ArrayList<Reservation> reservationList =new ArrayList<Reservation>();
	int count=1;
	
	//予約番号、会員名、チケット名、予約枚数
	public Reservation createReservation(Member member,Ticket ticket,int selectNumOfTicket) {
		
		Reservation re=new Reservation(member,ticket,selectNumOfTicket,count);
		
		reservationList.add(re);
		count++;
		return re;
	}
	
	//getReservationDate(reservationList.get(i),member);
	//                   ログインした人の予約オブジェクトリスト             ,ログインした会員のオブジェクト
	public ArrayList<Reservation> getReservation(Member member,ArrayList<Reservation> reLogin) {
		String data = null;
		for(int i=0;i<reservationList.size();i++) {
			Reservation keepReservation = reservationList.get(i).getReservationDate(reservationList.get(i),member);//予約オブジェクトが引数
			if(keepReservation != null)reLogin.add(keepReservation);
		}
		return reLogin;
	}
	
	public void deleteReservation(int number) {
		reservationList.set(number, null);
	}
	
	
	
	public Reservation get(int num) {
		return reservationList.get(num);
	}
	
	public String showAllReservationData(String userID) {
		String data = "";
			if(reservationList.size()==0) {
				data = "予約履歴がありません";
			}else {
				for(Reservation r:reservationList) 
				data = r.showReservationData();
			}
		return data;
	}
	
	
	//ファイルから取得した予約リストをシステムの予約リストの追加する
		public void downlodeReservationData(ArrayList<Reservation> fileReservationList) {
			for(Reservation m :fileReservationList) {
				reservationList.add(m);
			}
		}
		
		//システムの予約リストをファイルに追加する
		public ArrayList<Reservation> updateReservationData(ArrayList<Reservation> fileReservationList) {
			for(Reservation m :reservationList) {
				fileReservationList.add(m);
			}
			return fileReservationList;
		}


}
