package management;

import java.util.*;

import domain.*;
import userInterface.Interface;

public class Cancel {

	public void cancel(Interface uiinterface, Member member, ReservationList rl,TicketList tl) {
		
		int approval =0;
		int number=0;
		
		int count =0;//予約情報オブジェクトのカウント
		
		Reservation plusStock=null;
		
		Map<Integer,Reservation> reLogin=new HashMap<Integer,Reservation>();//log inした人の予約情報をもつリスト
		
		
		while(approval !=1 || approval == -1) {//終了条件にメインメニューへ戻る
			//予約情報の表示
			
			reLogin=rl.getReservation(member,reLogin);//log inしたmemberオブジェクト,log inした人が持ってる予約情報
			
			if(reLogin.size()==0) {
				uiinterface.output("予約情報がありません");
				break;
			}
			String data = "";
			//予約が一つもなければ予約情報なしでメニュー選択戻る
			//Iterator iterator =reLogin.iterator();
			//while(iterator.hasNext()) {
				
				for(Map.Entry<Integer,Reservation> entry:reLogin.entrySet()) {
					data +=entry.getValue().showReservationData();//予約情報の詳細
					data +="\n";
					count++;
				}
			//}
			while(true) {
				uiinterface.output(data);
				//予約番号入力
				uiinterface.output("キャンセルする予約番号を入力してくだい");
				number = uiinterface.inputInt();
				if(reLogin.get(number)!=null) {
					//選択した予約情報表示
					uiinterface.output(reLogin.get(number).showReservationData());
					break;
				}
				uiinterface.output("予約番号入力が間違っています");
			}
		
			//承認非承認
			while(true) {
				uiinterface.output("承認なら1　非承認なら２　メインメニューへ戻る場合は-1を入力してくだい");
				approval = uiinterface.inputInt();
				if(approval ==1|| approval == 2 || approval ==-1) {
					break;
				}
				uiinterface.output("1or2or-1を入力してくだい");//入力ミス
			}
			if(approval ==1 || approval == -1) {
				break;
			}
		}
		//予約情報の削除
		if(approval ==1)rl.deleteReservation(number);
	}
	

}
