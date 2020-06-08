package TicketSystem;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ShowTicketTest {
	@Test
	public void ShowTicketTest1() {
		Control control = new Control();
		Interface ui = new Interface();
		
		String ans = control.showTicket();
		ui.output(ans);
		String s = "チケット番号:1\n" + "チケット名:水族館\n" +
				"価格:1000\n" + 	"開催日:2020-6-6\n" +
				"在庫:28\n" + "チケット番号:2\n" +
				"チケット名:族館\n" + "価格:2000\n" + "開催日:2025-7-6\n" +
				"在庫:22\n" + "チケット番号:3\n" + "チケット名:館\n" + "価格:3000\n" + 	
				"開催日:2023-6-9\n" + "在庫:23\n" ;
		
		assertThat(s,is(ans));
		
	
	}
}
