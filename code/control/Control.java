package control;

import ui.Interface;
import db.Member;
import db.MemberList;
import db.Reservation;
import db.ReservationList;
import db.Ticket;
import db.TicketList;


//エラー処理を行うクラスあってもいい　メソッドごとに判定の種類分けられる
public class Control {
	
//	private static String pass;
//	private static String userName;
	private static int val_menu;
	private static int val_koumoku;
	
	public static void main(String[] args) {
	
		//コントロールのインスタンス
		start();
	
	}
	
	public static void start() {
		Interface uiinterface=new Interface();
		MemberList ml=new MemberList();
		ReservationList rl=new ReservationList();
		TicketList tl=new TicketList();
		
		Member member=null;														//メンバーオブジェクトは属性で持っていないと予約できない
		Reservation reservation=null;
		while(true) {//val_menu !=3) {
			val_menu = menu(uiinterface);											//メニューの選択
			
			switch(val_menu) {
			case 1:																//ログイン
				member = login(uiinterface,ml);									//ログインユーザーオブジェクト記録			
				break;
			
			case 2:																//新規作成
				//uiinterface.output("ユーザー名を入力してください");
				//String id=uiinterface.inputStr();
				break;
			//case 3:																//終了
				//System.exit(0);	
				//return ;
			}
			while(val_koumoku !=4) {
				val_koumoku = selectMode(uiinterface);
				
				switch(val_koumoku) {
				case 1:																//チケット予約
					//reservation=reserve(uiinterface,tl,rl,member);
					reserve(uiinterface,tl,rl,member);//予約情報オブジェクトはここで持つ必要ない
					break;
				
				case 2:																//チケット情報表示
					String[] allList_ticketDate = (tl.showAllTicketDate()).split("=");				//格納されてるチケット情報表示
					for(String line:allList_ticketDate) {
						uiinterface.output(line);
					}
					break;
				case 3:																//予約情報表示
					showReservedTicket(member);//ユーザーIDから予約一覧で検索かけてID該当する予約を一括表示
					break;
				case 4:																//システム終了 ここでプログラム終わり
					System.exit(0);	//永続化ならここいらない？
					//return ;永続化ならいる？
				}
			
			}
		}//return;ここいる？
	}
	//メニュー選択
	public static int menu(Interface uiinterface) {					//ログインするか新規作成するか
		uiinterface.output("項目に該当する数値を入力してください");
		uiinterface.output("1.ログイン");
		//uiinterface.output("2,新規作成");
		//uiinterface.output("3.終了");								//ログアウト
		while(true) {												//１か２でない場合再度入力させる
			val_menu=uiinterface.inputInt();									
			if(val_menu ==1 ||val_menu==2)break;
			System.out.println("1or2の入力をしてください");
		}
		return val_menu;
	}
	
	
	//ログイン
	public static Member login(Interface uiinterface,MemberList ml) {
		Member mm = null;
		while(mm==null) {											//ユーザーID     nullなら入力し直し
			uiinterface.output("ユーザーIDを入力してください");
			//String id=uiinterface.inputStr();
			mm=ml.checkID(uiinterface.inputStr());					//指定したIDのメンバーオブジェクトが返る
			if(mm==null)System.out.println("ユーザーIDが間違っています");
		}
		
		while(!(mm.getMmberPass(uiinterface.inputStr()))) {			//パスワード            pass正解まで繰り返し
			System.out.println("パスワードが間違っています");
		}
		return mm;													//pass変更するならここでオブジェクトを返すがよい？
	}
	//モード選択
	public static int selectMode(Interface uiinterface) {
		
		int date=0;
		uiinterface.output("項目の選択 以下数字を入力してください");
		uiinterface.output("1.チケット予約");
		uiinterface.output("2.チケット情報表示");
		uiinterface.output("3.システム終了");
		
		while(date != 1 ||date != 2 || date != 3) {
			date =uiinterface.inputInt(); 
			if(date != 1 ||date != 2 || date != 3) {
				System.out.println("入力直し");
			}
		}
		return date;	
	}
	
	//予約
	public static Reservation reserve(Interface uiinterface, TicketList tl, ReservationList rl,Member member) {
		
		Ticket ticket=null;
		int approval=2;
		int selectNumOfTicket=0;
		int countOfReservation=1;
		//要検討
		String[] date_ticketList=(tl.showTicketNumberName()).split("=");				//チケット名と番号のみ表示
		for(String line:date_ticketList) {
			uiinterface.output(line);
		}
		//↑要検討
		do {
			while(ticket == null) {
				uiinterface.output("予約したいチケット番号を入力してください");
				int num = uiinterface.inputInt();
				
				ticket = tl.getTicket(num);										//選択したチケットオブジェクト
			}
			
			//チケット情報表示してる↓													//項目のチケット情報表示を使うかどうか
			String [] date_ticket =(ticket.showTicketDate()).split("=");
			for(String line:date_ticket) {
				uiinterface.output(line);
			}
			
			uiinterface.output("このチケットを予約しますか？");
			uiinterface.output("承認なら「1」,承認しないなら「2」を入力してください");
			approval=uiinterface.inputInt();
		}while(approval ==2);													//非承認なら繰り返し
		approval=2;//trueなら１falseなら２とかでも書き換えできる
		
		//チケットごとの処理が入る枚数指定、とか		非機能要求  controlからUIに対して枚数指定反復1
		int ticketStock=ticket.getTicketStock();									//在庫数
		do {
			do {
				System.out.println("チケット枚数の指定");
				selectNumOfTicket=uiinterface.inputInt();
				uiinterface.output("予約チケット枚数");
				uiinterface.output(String.valueOf(selectNumOfTicket));
				uiinterface.output("チケットの在庫数");
				uiinterface.output(String.valueOf(ticketStock));
			}while(selectNumOfTicket>ticketStock || selectNumOfTicket<0);				//在庫数以上入力し直し
			uiinterface.output("---------");  										//見やすさのため入れるかどうか
			uiinterface.output(selectNumOfTicket+"枚のチケットを予約しますか？");
			uiinterface.output("承認なら「1」,承認しないなら「2」を入力してください");
			approval=uiinterface.inputInt();
			
		}while(approval == 2);
		//approval初期化
		//日にちの取得
		//
		//予約番号、会員名、チケット名、予約日、予約枚数    予約しました
		//Listで持ってこないと全部表示できない
		//クラスフィールドとして予約番号書き換え
		Reservation re = rl.createReservation(countOfReservation,member.getMemberID(),ticket,"予約日",selectNumOfTicket);
		
		
		String[] date_showReserv = (re.showReservationData()).split("=");
		
		for(String line:date_showReserv) {											//予約情報表示
			uiinterface.output(line);
		}
		return re;																	//予約オブジェクト
	}
	
	public static void showReservedTicket(Member member) {
		
		
		
		
	}
	
}
