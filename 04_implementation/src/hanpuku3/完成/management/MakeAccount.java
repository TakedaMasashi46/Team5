package management;

import java.util.Map;

import domain.Member;
import domain.MemberList;

public class MakeAccount extends Command{
	
	//アカウント作成
	
	@Override
	public Object execute(Map<Integer,Object> map) {
		MemberList ml = (MemberList)map.get(1);
		Boolean approval=null;
		Member member=null;
		//情報の入力
		while(true) {
			String id;
			while(true) {
				uiinterface.output("ユーザー名を入力してください");
				id=uiinterface.inputStr();
				if(ml.checkID(id)!=null) {
					uiinterface.output("そのユーザー名は存在しています");
					continue;
				}
				break;
			}
			
			uiinterface.output("パスワードを入力してください");
			String pass=uiinterface.inputStr();
			uiinterface.output(id);
			uiinterface.output(pass);
			uiinterface.output("上記の内容でアカウント作成を行いますか？");
			approval=approval();
			if(approval) {//承認
				//メンバーリストに追加
				member=ml.setMember(id,pass);
				uiinterface.output("登録完了！続いてログインを行います。");
				break;
			}else{//非承認
				break;
			}
		}
		return member;
	}
}

	
