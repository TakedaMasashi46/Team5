package db;

import domain.*;

public class Test_fmr {
	public static void main(String args[]) {
		FileMember fm = new FileMember();
		MemberList ml = new MemberList();
		fm.getMemberdata(ml);
		ml.showAllMemberData();
		
		FileTicket ft = new FileTicket();
		TicketList tl = new TicketList();
		ft.getTicketdata(tl);
		Ticket ticket = tl.getTicketobj(0);
		System.out.println(ticket.getTicketName());
		
	}
}
