package management;

import java.util.Map;

import domain.Member;
import domain.TicketList;
import domain.ReservationList;
import userInterface.Interface;

public class ShowReservationLog extends Command{

	
	//予約情報表示メソッド
	@Override
	public  Object execute(Map<Integer,Object> map){
	Member member = (Member)map.get(1);
	ReservationList rl = (ReservationList)map.get(2);
		String data = rl.showAllReservationData(member);
		uiinterface.output(data);
		return null;
	}
}
