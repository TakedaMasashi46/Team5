package ui;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Scanner;

import org.junit.Test;
import java.util.InputMismatchException;

public class Test_Interface {
	@Test
	/*
	 * 1-1: int型入力が正しく行われる場合
	 * 
	 */
	public void testUI_1_1() {
		// 事前準備
		Interface ui = new Interface();
		Scanner scan = new Scanner(System.in);
	
		/* 出力 */
		int expected_out = 1;

		// 実行
		System.out.println("数値を入力してください");
		//1を手入力
		int out = ui.inputInt();
		System.out.println(out);

		// 検証
		assertThat(out, is(expected_out));

	}
	@Test
	/*
	 * 1-2: int型以外の入力がなされた後、int型入力が正しく行われる場合
	 */
	public void testUI_1_2() {
		// 事前準備
		Interface ui = new Interface();
		Scanner scan = new Scanner(System.in);
	
		/* 出力 */
		int expected_out = 1;

		// 実行
		System.out.println("値を入力してください");
		//aを手入力
		//1を手入力
		int out = ui.inputInt();

		// 検証
		assertThat(out, is(expected_out));

	}

	@Test
	/*
	 * 2: String型入力が正しく行われる場合
	 * 
	 */
	public void testUI_2() {
		// 事前準備
		Interface ui = new Interface();
		Scanner scan = new Scanner(System.in);
	
		/* 出力 */
		String expected_out = "cresco明日";

		// 実行
		System.out.println("文字を入力してください");
		//cresco明日を手入力
		String out = ui.inputStr();
		System.out.println(out);

		// 検証
		assertThat(out, is(expected_out));

	}

	@Test
	/*
	 * 3: 出力が正しく行われる場合
	 * 
	 */
	public void testUI_6() {
		// 事前準備
		Interface ui = new Interface();
	
		/* 出力 */
		String expected_out = "テスト";

		// 実行
		ui.output("テスト");


	}

}
