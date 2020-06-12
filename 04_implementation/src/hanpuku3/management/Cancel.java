package management;

import java.util.*;

import domain.*;
import userInterface.Interface;

public class Cancel extends Command{

	@Override
	public Object execute(HashMap<Integer,Object> map) {// void cancel(Interface uiinterface, Member member, ReservationList rl,TicketList tl) {
		
		ReservationList rl =(ReservationList) map.get(1);//予約情報リスト
		Member member=(Member) map.get(2);//ログインしたメンバーオブジェクト

		int number=0;
		int count =0;//予約情報オブジェクトのカウント
		
		Reservation plusStock=null;
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
			count++;
		}
		while(true) {
			while(true) {
				uiinterface.output(data);//ログインした人の予約情報一覧表示
				uiinterface.output("キャンセルする予約番号もしくは予約キャンセルをする場合は「-1」を入力してくだい");
				number = uiinterface.inputInt();//予約番号入力
				if(number ==-1)break;//cancelせずにメインメニューへ戻る
				if(reLogin.get(number)!=null) {
					uiinterface.output(reLogin.get(number).showReservationData());//選択した予約情報表示
					break;//?
				}
				uiinterface.output("予約番号入力が間違っています");
			}
			if(number ==-1)break;
			//承認非承認
			uiinterface.output("承認なら1　非承認なら２を入力してくだい");
			if(approval()) {
				rl.deleteReservation(number);//予約情報の削除
				break;
			}
		}
		return null;
	}
}