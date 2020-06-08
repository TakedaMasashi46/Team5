package center;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import userInterface.Interface;
import database.Member;
import database.MemberList;
import database.Reservation;
import database.ReservationList;
import database.Ticket;
import database.TicketList;

public class Test_control {
	@Test public void test1() {
		Control co = new Control();
		Interface in = new Interface();
		TicketList tl = new TicketList();
		ReservationList rl = new ReservationList();
		Member mm = new Member("クレスコ明日","12345");
		
		Reservation re = co.reserve(in, tl, rl,mm);
		assertThat(re,is(rl.get(0)));
		
	}
}
