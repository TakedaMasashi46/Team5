package database;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class Test_rl {
	@Test
	public void test1() {
		Ticket ti = new Ticket(1,"水族館",2000,"2020-07-07",20);
		ReservationList rl = new ReservationList();
		Reservation re = rl.createReservation("クレスコ明日", ti,"2020-06-06", 1);
		Reservation re2 = rl.createReservation("クレスコ今日", ti,"2020-06-07", 1);
		String test = re.showReservationData();
		System.out.println("test1:"+test);
		System.out.println("test2:"+re2.showReservationData());
		
		assertThat(test, is("予約番号:1=会員名:クレスコ明日=チケット名:水族館=予約日:2020-06-06=予約枚数:1"));
		
	}
}
