package control;

import ui.Interface;
import db.MemberList;
import db.ReservationList;
import db.TicketList;


//エラー処理を行うクラスあってもいい　メソッドごとに判定の種類分けられる
public class Control {
	
	public static void main(String[] args) {
	
		Interface uiinterface=new Interface();
		MemberList ml=new MemberList();
		ReservationList rl=new ReservationList();
		TicketList tl=new TicketList();
		
		String pass;
		String val;
		
		//ログインするか新規作成するか
		uiinterface.output("項目に該当する数値を選択してください");
		uiinterface.output("1.ログイン");
		uiinterface.output("2,新規作成");
		uiinterface.output("3.終了");								//ログアウト
		val=uiinterface.input();									//１か２でない場合再度入力させる
		
		
		if(val.equals("1")) {
															//ログイン DBから値をもってきて判定はcontrol?それともDBのクラス？制御だからcontrol?
			uiinterface.output("ユーザー名を入力してください");
			String id=uiinterface.input();
															//mlから入力された名前を持ってくるなければ再入力or新規作成?
		
			uiinterface.output("パスワードを入力してください");
			pass=uiinterface.input();
															//ここで入力ミスはし直しさせる
		}
		
		if(val.equals("2")) {								//新規作成
			
		}
		if(val.equals("3")) {
			System.exit(0);									//反復１では永続化しないから0でプログラム終了
		}
		
		uiinterface.output("項目に該当する数値を選択してください");
		uiinterface.output("1.チケットの予約");
		uiinterface.output("2,チケットのキャンセル");
		uiinterface.output("3.予約情報の確認");
		uiinterface.output("4.終了する");						//一つ上の項目に戻る

		
	}
}
