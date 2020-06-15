package db;

import java.io.*;
import java.util.ArrayList;
import domain.MemberList;
import domain.Member;

public class FileMember {
	public void getMemberdata(MemberList ml) {
		File dir = new File("C:\\Users\\Administrator\\eclipse-workspace\\hanpuku3\\src\\db\\MemberObject");
		File[] list = dir.listFiles(); 
		ArrayList<Member> list_M = new ArrayList<Member>();
		Member member = null;
		for(int i =0;i<list.length;i++) {
			try(FileInputStream file = new FileInputStream(list[i]);
				ObjectInputStream obj = new ObjectInputStream(file)){
				try {
					member = (Member)obj.readObject();
				}catch(Exception e) {
					
				}
				if(member!=null) {
					list_M.add(member);
				}
					
			}catch(IOException e) {
				
			}
		}
		ml.downlodeMemberData(list_M);
	}
	
	public void setMemberdata(MemberList ml) {
		Member member;
		
		try {
            File dir = new File("C:\\Users\\Administrator\\eclipse-workspace\\hanpuku3\\src\\db\\MemberObject");
    		File[] list = dir.listFiles();
            if(list!=null) {
            	for(File file: list) {
                    file.delete();
                }
            }
        }catch(Throwable th) {
            th.printStackTrace();
        }
		
		ArrayList<Member> list_M=new ArrayList<Member>();
		ml.updateMemberData(list_M);
		for(int i=0;i<list_M.size();i++) {
			String filePath = "C:\\Users\\Administrator\\eclipse-workspace\\hanpuku3\\src\\db\\MemberObject";
			File newfile = new File(filePath+"\\memberObj"+i+".ser");
			try{
			    newfile.createNewFile();
			}catch(IOException e){
			    System.out.println(e);
			}
			
			member = list_M.get(i);
			try(FileOutputStream fos = new FileOutputStream(filePath+"\\memberObj"+i+".ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(member);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
