package userInterface;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Interface {

	//使用者からの入力を受け付ける
	
	//ユーザー名,pass
	//ここでは入力されたものすべて返す
	public String inputStr() {
		output("------------------");
		System.out.print("ー＞＞＞");
		Scanner scan = new Scanner(System.in);
		String in=scan.nextLine();
		output("------------------");
		return in;
	}
	public int inputInt() {
		int in = 0;
		int count=0;
		while(count==0) {
			try {
				output("------------------");
				System.out.print("ー＞＞＞");
				Scanner scan = new Scanner(System.in);
				in=scan.nextInt();
				output("------------------");
				count=1;
			}catch(InputMismatchException e) {
				output("数値入力してください");
			}
		}
		count=0;
		return in;
	}
	public void output(String date) {
		System.out.println(date);
	}
}
