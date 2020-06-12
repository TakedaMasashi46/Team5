package db;

import domain.*;

public class Test_fm {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		/*FileMember fm = new FileMember();
		MemberList ml = new MemberList();
		Member member1 = new Member("クレスコ明日","12345");
		Member member2 = new Member("クレスコ今日","13579");
		ml.addMember(member1);
		ml.addMember(member2);
		fm.setMemberdata(ml);*/
		
		
		FileTicket ft = new FileTicket();
		TicketList tl = new TicketList();
		Ticket ticket1 = new Ticket(1,"水族館",2000,"2020-07-07",20);
		Ticket ticket2 = new Ticket(2,"映画館",1000,"2020-07-12",50);
		Ticket ticket3 = new Ticket(3,"美術館",500,"2020-08-12",100);
		tl.addTicket(ticket1);
		tl.addTicket(ticket2);
		tl.addTicket(ticket3);
		ft.setTicketdata(tl);
		
		
		/*FileReservation fr = new FileReservation();
		ReservationList rl = new ReservationList();
		Reservation Reservation1 = new Reservation(1,"水族館",2000,"2020-07-07",20);
		Reservation Reservation2 = new Reservation(2,"映画館",1000,"2020-07-12",50);
		rl.addReservation(Reservation1);
		rl.addReservation(Reservation2);
		fr.setReservationdata(rl);*/
	}

}
