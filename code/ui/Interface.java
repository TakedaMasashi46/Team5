package ui;
import java.util.Scanner;

public class Interface {

	//使用者からの入力を受け付ける
	
	//ユーザー名,pass
	//controlに投げてDB判定してもらってよければ次へ
	//入力のみ？判定はcontrol?
	//ならここでは入力されたものすべて返す
	public String input() {
		 Scanner scan = new Scanner(System.in);
		 String in=scan.nextLine();
		return in;
	}
	public void output(String date) {
		System.out.println(date);
	}
}
