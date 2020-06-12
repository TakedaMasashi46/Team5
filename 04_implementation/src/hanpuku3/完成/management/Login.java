package management;

import java.util.Map;

import domain.Member;
import domain.MemberList;
import userInterface.Interface;

public class Login extends Command{
	
	//ログイン
	@Override
	public Object execute(Map<Integer,Object> map) {
		
				MemberList ml = (MemberList) map.get(1);
				
			Member mm = null;
			while(mm==null) {											//ユーザーID     nullなら入力し直し
				uiinterface.output("ユーザーIDを入力してください");
				mm=ml.checkID(uiinterface.inputStr());					//指定したIDのメンバーオブジェクトが返る
				if(mm==null) {
					uiinterface.output("ユーザーIDが間違っています");
				uiinterface.output("ログインメニューに戻る場合は「１」、ユーザーIDを再入力する場合は「２」を選択してください");
				int check = uiinterface.inputInt();
				if(check==1) return returnMenu();
			}
			}
			
			while(true) {			//パスワード            pass正解まで繰り返し
				uiinterface.output("パスワードを入力してください");
				String pass = uiinterface.inputStr();
				if(mm.getMemberPass(pass))break;
				uiinterface.output("パスワードが間違っています");
			}
			return mm;													
		}
		
//メニューを返す
	public Member returnMenu() {
		Member mm = null;
		return mm;
	}
}