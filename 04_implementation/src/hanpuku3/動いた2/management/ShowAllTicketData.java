package management;


import java.util.*;

import domain.Member;
import domain.TicketList;
import domain.ReservationList;
import userInterface.Interface;

public class ShowAllTicketData extends Command{
	
	//チケット情報表示
	@Override
	public  Object execute(Map<Integer,Object> map){
		TicketList tl = (TicketList)map.get(1);
		String data = tl.showAllTicketData();
		uiinterface.output(data);
		return null;
	}
	
}
