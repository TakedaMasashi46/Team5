package management;

import java.util.Map;
import java.util.Objects;

import domain.Member;
import domain.Reservation;
import domain.ReservationList;
import domain.Ticket;
import domain.TicketList;

public class TicketReservation extends Command{
	//予約
		@Override
		public Object execute(Map<Integer,Object> map) {	
			TicketList tl = (TicketList)map.get(1);
			ReservationList rl = (ReservationList)map.get(2);
			Member member = (Member)map.get(3);
			
			Ticket ticket=null;
			boolean approval=false;
			int selectNumOfTicket=0;
			int selectNumOfChildTicket=0;
	
			String[] date_ticketList=(tl.showTicketNumberName()).split("=");				//チケット名と番号のみ表示
			for(String line:date_ticketList) {
					uiinterface.output(line);
				
				
			}
			do {
				while(ticket == null) {
					uiinterface.output("予約したいチケット番号を入力してください");
					int num = uiinterface.inputInt();
					
					ticket = tl.getTicket(num);	//選択したチケットオブジェクト
					if(Objects.isNull(ticket)) {
						uiinterface.output("※存在するチケット番号を入力してください");
						continue;
					}
					if(ticket.getTicketStock()==0) {
						ticket =null;
						uiinterface.output("※在庫がありません");
					}
						
				}
				
				//チケット情報表示してる↓													//項目のチケット情報表示を使うかどうか
				String [] date_ticket =(ticket.showTicketData()).split("=");
				uiinterface.output("・チケット情報");
				for(String line:date_ticket) {
					uiinterface.output(line);
				}
				uiinterface.output("このチケットを予約しますか？");
				
				approval = approval();
				if(approval==false) ticket = null;
			}while(approval ==false);													//非承認なら繰り返し
			approval=false;//trueなら１falseなら２とかでも書き換えできる
			
			//チケットごとの処理が入る枚数指定
			int ticketStock=ticket.getTicketStock();									//在庫数
			do {
				while(true) {
					while(true) {
						uiinterface.output("大人のチケット枚数の指定");
						selectNumOfTicket=uiinterface.inputInt();
						if(selectNumOfTicket<0||ticketStock<selectNumOfTicket) {
							uiinterface.output("不正な値です");
							continue;
						}else {
							break;
						}
					}
					uiinterface.output("大人予約チケット枚数:"+String.valueOf(selectNumOfTicket));
					
					while(true) {
						uiinterface.output("子供のチケット枚数の指定");
						selectNumOfChildTicket=uiinterface.inputInt();
						if(selectNumOfTicket<0||ticketStock<selectNumOfTicket) {
							uiinterface.output("不正な値です");
							continue;
						}else {
							break;
						}
					}
					uiinterface.output("子供予約チケット枚数:"+String.valueOf(selectNumOfChildTicket));
					uiinterface.output("チケットの在庫数:"+String.valueOf(ticketStock));
					if((selectNumOfTicket+selectNumOfChildTicket)>ticketStock) {
						uiinterface.output("チケットの在庫超過しています");
					}else if((selectNumOfTicket+selectNumOfChildTicket)<=0) {
						uiinterface.output("不正な値です");
					}else {
						break;
					}
				}				//在庫数以上入力し直し  								
				uiinterface.output("大人"+selectNumOfTicket+"枚, 子供"+selectNumOfChildTicket+"枚のチケットを予約しますか？");
				approval=approval();
			}while(approval == false);
			approval = false;
			//approval初期化
			//予約番号、会員名、チケット名、予約日、予約枚数    予約しました
			//クラスフィールドとして予約番号書き換え
			Reservation re = rl.createReservation(member,ticket,selectNumOfTicket,selectNumOfChildTicket, ticketSumPrice(selectNumOfTicket,selectNumOfChildTicket,ticket));
			
			
			String[] date_showReserv = (re.showReservationData()).split("=");
			
			uiinterface.output("・予約情報");
			for(String line:date_showReserv) {		//予約情報表示
				uiinterface.output(line);
			}
			return re;																	//予約オブジェクト
		}
		private int ticketSumPrice(int maisu, int maisuChild,Ticket ticket) {
			int price = ticket.getPrice();
			return maisu*price + maisuChild*(int)(0.5*price);
		}
}