package db;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import ui.Interface;

public class Test_ticketlist {
	@Test
	/*
	 * 1-1: すべてのチケット情報を表示する場合
	 * 
	 */
	public void testUI_1_1() {
		// 事前準備
		TicketList tl =new TicketList();

	
		/* 出力 */
		String expected_out = "チケット番号:1"+"\n"+"チケット名:水族館"+"\n"+"価格:1000"+"\n"+"開催日:2020-06-06"+"\n"+"在庫:20"
						+"\n"+ "チケット番号:2"+"\n"+"チケット名:映画館"+"\n"+"価格:3000"+"\n"+"開催日:2020-07-10"+"\n"+"在庫:50"
						+"\n"+ "チケット番号:3"+"\n"+"チケット名:美術館"+"\n"+"価格:800"+"\n"+"開催日:2020-08-12"+"\n"+"在庫:10"+"\n";
	

		// 実行
		String out=tl.showAllTicketDate();
		System.out.println(out);

		// 検証
		assertThat(out, is(expected_out));

	}
	@Test
	/*
	 * 1-2: 入力されたチケット番号と同じチケットが存在するチケットの取得

	 * 
	 */
	public void testUI_1_2() {
		// 事前準備
		TicketList tl =new TicketList();
	
		/* 出力 */
		String expected_out = "チケット番号:2"+"\n"+"チケット名:映画館"+"\n"+"価格:3000"+"\n"+"開催日:2020-07-10"+"\n"+"在庫:50";

		// 実行
		Ticket out=tl.getTicket(2);
		System.out.println(out.showTicketDate());

		// 検証
		assertThat(out.showTicketDate(), is(expected_out));
		

	}
	@Test
	/*
	 * 1-3: 入力されたチケット番号と同じチケットが存在しないチケットの取得

	 * 
	 */
	public void testUI_1_3() {
		// 事前準備
		TicketList tl =new TicketList();
	
		/* 出力 */
		String expected_out = null;

		// 実行
		Ticket out=tl.getTicket(4);

		// 検証
		assertThat(out, is(expected_out));
		

	}
}
