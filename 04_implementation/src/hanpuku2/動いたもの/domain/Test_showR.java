package domain;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import management.*;

public class Test_showR {
	//test1 予約履歴がある場合
	@Test
	public void testshowReservation_1() {
		Member m = new Member("クレスコ明日","12345");
		Ticket ticket = new Ticket(1,"水族館",1000,"2020-06-10",20);
		ReservationList rl = new ReservationList();
		ShowInformation s = new ShowInformation();
		
		String userID = m.getMemberID();
		rl.createReservation("クレスコ明日", ticket, "予約日", 1);
		
		String actual = rl.showAllReservationData(userID);

		String expected =   "予約履歴\r\n" + 
							"・予約情報１\r\n" + 
							"　予約番号：1\r\n" + 
							"　会員名：クレスコ明日\r\n" + 
							"　チケット名：水族館\r\n" + 
							"　予約日：2020-06-10※\r\n" + 
							"　予約枚数：1";
		
		//検証
		assertThat(actual,is(expected));
	}
	
		//test2 予約履歴がない場合
		@Test
		public void testshowReservation_2() {
			Member m = null;
			Ticket ticket = null;
			ReservationList rl = new ReservationList();
			ShowInformation s = new ShowInformation();
			
			String userID = "クレスコ明後日";
			
			String actual = rl.showAllReservationData(userID);

			String expected = "予約履歴がありません";
			
			//検証
			assertThat(actual,is(expected));
		
	}
}
