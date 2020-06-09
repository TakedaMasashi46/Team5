package management;

import domain.Member;
import domain.MemberList;
import userInterface.Interface;

public class MakeAccount {
	
	//アカウント作成
	public Member newAccount(Interface uiinterface, MemberList ml) {
		int approval=0;
		Member member=null;
		//情報の入力
		while(true) {
			uiinterface.output("ユーザー名を入力してください");
			String id=uiinterface.inputStr();
			uiinterface.output("パスワードを入力してください");
			String pass=uiinterface.inputStr();
			uiinterface.output("----------------------------");
			uiinterface.output(id);
			uiinterface.output(pass);
			uiinterface.output("----------------------------");
			uiinterface.output("上記の内容でアカウント作成を行いますか？");
			uiinterface.output("承認なら「1」,承認しないなら「2」を入力してください");
			approval=uiinterface.inputInt();
			if(approval==1) {//承認
				//メンバーリストに追加
				member=ml.setMember(id,pass);
				
				break;
			}else if (approval == 2){//非承認
				break;
			}else {
				uiinterface.output("「1」か「2」を入力してください");
			}
		}
		return null;
	}
}
