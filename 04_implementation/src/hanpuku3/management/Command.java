package management;

import java.util.*;

import userInterface.Interface;

abstract class Command {
	
	Map<Integer,Object> map=new HashMap<Integer,Object>();
	Interface uiinterface =new Interface();
	//各メソッドで中身実装
	public abstract Object execute();
	
	//承認非承認
	public boolean approval() {	
		int approval=0;
		while(true) {
			uiinterface.output("承認なら1　非承認なら２を入力してくだい");
			approval = uiinterface.inputInt();
			if(approval ==1)return true;
			if(approval ==2) return false;
			uiinterface.output("1or2を入力してくだい");//入力ミス
		}
	}
}
