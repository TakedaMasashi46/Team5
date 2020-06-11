package management;

import domain.Member;
import domain.TicketList;
import domain.ReservationList;
import userInterface.Interface;

public class ShowInformation {
	Interface ui = new Interface();
	
	//チケット情報表示	
	public void showallTicketData(TicketList tl) {
		String data = tl.showAllTicketData();
		ui.output(data);
	}
	
	//予約情報表示メソッド
	public void showReservationLog(Member member,ReservationList rl) {
		String data = rl.showAllReservationData(member);
		ui.output(data);
	}
}
