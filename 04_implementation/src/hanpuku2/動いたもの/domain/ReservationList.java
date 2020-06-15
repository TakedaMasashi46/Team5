package domain;


import java.util.*;

public class ReservationList {
	
	//予約情報の型でリスト保存
	Map<Integer,Reservation> reservationList = new HashMap<Integer,Reservation>();
	int count = 1;
	
	//予約番号、会員名、チケット名、予約枚数
	public Reservation createReservation(Member member,Ticket ticket,int selectNumOfTicket) {
		while(true) {
			if(reservationList.get(count)==null) {
				break;
			}
			count++;
		}
		Reservation re=new Reservation(member,ticket,selectNumOfTicket,count);
		count=1;
		reservationList.put(re.getReservationNumber(),re);
		return re;
	}
	
	//                   ログインした人の予約オブジェクトリスト             ,ログインした会員のオブジェクト
	public Map<Integer,Reservation> getReservation(Member member,Map<Integer,Reservation> reLogin) {
		String data = null;

		for(Map.Entry<Integer,Reservation> entry:reservationList.entrySet()) {
			Reservation keepReservation = entry.getValue().getReservationDate(entry.getValue(),member);//予約オブジェクトが引数
			if(keepReservation != null)reLogin.put(keepReservation.getReservationNumber(),keepReservation);
		}
		return reLogin;
	}
	
	public void deleteReservation(int number) {
		Reservation res = reservationList.get(number);
		res.getReservationTicket().returnStock(res.getReservationMaisu());
		reservationList.remove(number);
	}
	
	
	
	public Reservation get(int num) {
		return reservationList.get(num);
	}
	
	public String showAllReservationData(Member member) {
		String data = "";
		Map<Integer,Reservation> map = new HashMap<Integer,Reservation>();
		getReservation(member,map);
			if(map.size()==0) {
				data = "予約履歴がありません";
			}else {
				for(Map.Entry<Integer,Reservation> entry:reservationList.entrySet()) {
						data += entry.getValue().showReservationData();
						data+="---------------\n";
				}
				
			}
		return data;
	}
	
	
	//ファイルから取得した予約リストをシステムの予約リストの追加する
		public void downlodeReservationData(ArrayList<Reservation> fileReservationList) {
			for(Reservation m :fileReservationList) {
				reservationList.put(m.getReservationNumber(),m);
			}
		}
		
		//システムの予約リストをファイルに追加する
		public ArrayList<Reservation> updateReservationData(ArrayList<Reservation> fileReservationList) {
			for(Map.Entry<Integer,Reservation> entry:reservationList.entrySet()) {
				fileReservationList.add(entry.getValue());
			}
			return fileReservationList;
		}


}
