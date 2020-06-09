package management;

import userInterface.Interface;
import domain.Member;
import domain.MemberList;

import domain.ReservationList;
import domain.TicketList;


//エラー処理を行うクラスあってもいい　メソッドごとに判定の種類分けられる
public class Control {

	private int val_menu;
	private int val_koumoku;
	
	public void start() {
		
		//オブジェクト群
		Interface uiinterface=new Interface();
		MemberList ml=new MemberList();
		ReservationList rl=new ReservationList();
		TicketList tl=new TicketList();											//チケットオブジェクトも生成
		Login login=new Login();
		ShowInformation infor=new ShowInformation();
		MakeAccount makeaccount=new MakeAccount();
		TicketReservation tr=new TicketReservation();
		Cancel cancel=new Cancel();
		//属性
		Member member=null;														//メンバーオブジェクトは属性で持っていないと予約できない
		
		while(true) {//val_menu !=3) {
														//メニューの選択
			//メニュー選択
			val_menu= uiinterface.inputInt();
			
			while(val_menu!=1) {
				val_menu = menu(uiinterface);
				switch(val_menu) {
				case 1:																//ログイン
					member = login.login(uiinterface,ml);									//ログインユーザーオブジェクト記録			
					break;
				
				case 2:																//新規作成
					member= makeaccount.newAccount(uiinterface,ml);
					break;
				//case 3:																//終了
					//System.exit(0);	
					//return ;
				}
			}
			//項目選択
			while(true) {
				val_koumoku = selectMode(uiinterface);
				
				switch(val_koumoku) {
				case 1://チケット予約
					tr.reserve(uiinterface,tl,rl,member);
					break;
				case 2://チケット情報表示
					infor.showallTicketData(tl);
					break;
				case 3://予約情報表示
					infor.showReservationLog(member);//ユーザーIDから予約一覧で検索かけてID該当する予約を一括表示
					break;
				case 4://予約キャンセル
					cancel.cancel(uiinterface,member,rl);
				case 5://システム終了 
					System.exit(0);
				}
			}
		}
	}

	//メニュー選択
	public int menu(Interface uiinterface) {					//ログインするか新規作成するか
		uiinterface.output("項目に該当する数値を入力してください");
		uiinterface.output("1.ログイン");
		uiinterface.output("2,新規作成");
		//uiinterface.output("3.終了");								//ログアウト
		while(true) {												//１か２でない場合再度入力させる
			val_menu=uiinterface.inputInt();									
			if(val_menu ==1 ||val_menu==2)break;
			System.out.println("1or2の入力をしてください");
		}
		return val_menu;
	}
	//モード選択
	public int selectMode(Interface uiinterface) {
		
		int date=0;
		uiinterface.output("項目の選択 以下数字を入力してください");
		uiinterface.output("1.チケット予約");
		uiinterface.output("2.チケット情報表示");
		uiinterface.output("3.予約情報表示");
		uiinterface.output("4.チケットキャンセル");
		uiinterface.output("5.システム終了");
		
		while(true) {
			date =uiinterface.inputInt(); 
			if(date == 1 ||date == 2 || date == 3 || date == 4 || date == 5) {
				break;
			}
			System.out.println("入力直し");
		}
		return date;
	}
}
