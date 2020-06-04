package ui;
import java.util.Scanner;

public class Interface {

	//使用者からの入力を受け付ける
	
	//ユーザー名,pass
	//controlに投げてDB判定してもらってよければ次へ
	//入力のみ？判定はcontrol?
	//ならここでは入力されたものすべて返す
	public String inputStr() {
		 Scanner scan = new Scanner(System.in);
		 String in=scan.nextLine();
		return in;
	}
	public int inputInt() {
		int in = 0;
		int count=0;
		while(count==0) {
			try {
				Scanner scan = new Scanner(System.in);
				in=scan.nextInt();
				count=1;
			}catch(NumberFormatException e) {
				System.out.println("数値入力してください");
			}
		}
		count=0;
		return in;
	}
	public void output(String date) {
		System.out.println(date);
	}
}
