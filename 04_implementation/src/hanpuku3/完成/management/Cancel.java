package management;

import java.util.*;

import domain.*;

public class Cancel extends Command{

	@Override
	public Object execute(Map<Integer,Object> map) {
		
		Member member=(Member) map.get(1);//ログインしたメンバーオブジェクト
		ReservationList rl =(ReservationList) map.get(2);//予約情報リスト
		TicketList tl = (TicketList)map.get(3);

		int number=0;
		
		Map<Integer,Reservation> reLogin=new HashMap<Integer,Reservation>();//log inした人の予約情報をもつリスト
		
		//予約情報の表示
		reLogin=rl.getReservation(member,reLogin);//log inしたmemberオブジェクト,log inした人が持ってる予約情報
		//予約が一つもなければ予約情報なしでメニュー選択戻る
		if(reLogin.size()==0) {
			uiinterface.output("予約情報がありません");
			return null;
		}
		String data = "";
		for(Map.Entry<Integer,Reservation> entry:reLogin.entrySet()) {
			data +=entry.getValue().showReservationData();//予約情報の詳細
			data +="\n";
		}
		
		while(true) {
			while(true) {
				uiinterface.output(data);//ログインした人の予約情報一覧表示
				uiinterface.output("キャンセルする予約番号もしくは予約キャンセルをする場合は「-1」を入力してくだい");
				number = uiinterface.inputInt();//予約番号入力
				if(number ==-1)break;//cancelせずにメインメニューへ戻る
				if(reLogin.get(number)!=null) {
					uiinterface.output(reLogin.get(number).showReservationData());//選択した予約情報表示
					break;
				}
				uiinterface.output("予約番号入力が間違っています");
			}
			//承認非承認
			if((number!=-1)&&approval()) {
				Ticket ticket = tl.getTicket(reLogin.get(number).getReservationTicket().getTicketNumber());
				rl.deleteReservation(number,ticket);//予約情報の削除
				break;
			}
			if(number==-1) {
				break;
			}
		}
		return null;
	}
			
}