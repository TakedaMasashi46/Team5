package db;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import org.junit.jupiter.api.Test;

class Ticket_Test {

	@Test
	void test1() {
		Ticket ticket = new Ticket(1,"水族館",2000,"2020-07-07",20);
		
		String actual = ticket.showTicketDate();
		String expect = "チケット番号:1"+"\n"+"チケット名:水族館"+"\n"+"価格:2000"+"\n" +"開催日:2020-07-07"+"\n"+"在庫:20";
		assertThat(actual,is(expect));
	
	}
	
	@Test
	void Test2() {
		Ticket ticket = new Ticket(1,"水族館",2000,"2020-07-07",20);
		
		int actual = ticket.getTicketNumber();
		int expect = 1;
		assertThat(actual,is(expect));

	}
	@Test
	void Test3() {
		Ticket ticket = new Ticket(1,"水族館",2000,"2020-07-07",20);
		ticket.minusTicketStock(3);
		int actual = ticket.getTicketStock();
		int expect = 17;
		assertThat(actual,is(expect));
	}
	
	@Test
	void Test4() {
		Ticket ticket = new Ticket(1,"水族館",2000,"2020-07-07",20);
		String actual = ticket.getTicketName();
		String expect = "水族館";
		assertThat(actual,is(expect));
	}
}
