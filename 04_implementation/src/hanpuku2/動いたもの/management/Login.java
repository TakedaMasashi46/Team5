package management;

import domain.Member;
import domain.MemberList;
import userInterface.Interface;

public class Login {
	//ログイン
		public Member login(Interface uiinterface,MemberList ml) {
			Member mm = null;
			while(mm==null) {											//ユーザーID     nullなら入力し直し
				uiinterface.output("ユーザーIDを入力してください");
				//String id=uiinterface.inputStr();
				mm=ml.checkID(uiinterface.inputStr());					//指定したIDのメンバーオブジェクトが返る
				if(mm==null) {
				System.out.println("ユーザーIDが間違っています");
				uiinterface.output("ログインメニューに戻る場合は「１」、ユーザーIDを再入力する場合は「２」を選択してください");
				int check = uiinterface.inputInt();
				if(check==1) return returnMenu();
			}
			}
			
			while(true) {			//パスワード            pass正解まで繰り返し
				System.out.println("パスワードを入力してください");
				String pass = uiinterface.inputStr();
				if(mm.getMemberPass(pass))break;
				System.out.println("パスワードが間違っています");
			}
			return mm;													//pass変更するならここでオブジェクトを返すがよい？
		}
	
	public Member returnMenu() {
		Member mm = null;
		return mm;
	}
}
