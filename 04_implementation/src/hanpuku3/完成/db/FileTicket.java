package db;

import java.io.*;
import java.util.ArrayList;
import domain.TicketList;
import domain.Ticket;

public class FileTicket {
	public void getTicketdata(TicketList tl) {
		File dir = new File("C:\\Users\\Administrator\\eclipse-workspace\\hanpuku3\\src\\db\\TicketObject");
		File[] list = dir.listFiles(); 
		ArrayList<Ticket> list_M = new ArrayList<Ticket>();
		Ticket ticket = null;
		for(int i =0;i<list.length;i++) {
			try(FileInputStream file = new FileInputStream(list[i]);
				ObjectInputStream obj = new ObjectInputStream(file)){
				try {
					ticket = (Ticket)obj.readObject();
				}catch(Exception e) {
					
				}
				if(ticket!=null) {
					list_M.add(ticket);
				}
					
			}catch(IOException e) {
				
			}
		}
		tl.douwnlodeTicketData(list_M);
	}
	
	public void setTicketdata(TicketList tl) {
		Ticket ticket;
		
		try {
            File dir = new File("C:\\Users\\Administrator\\eclipse-workspace\\hanpuku3\\src\\db\\TicketObject");
    		File[] list = dir.listFiles();
            if(list!=null) {
            	for(File file: list) {
                    file.delete();
                }
            }
        }catch(Throwable th) {
            th.printStackTrace();
        }
		
		ArrayList<Ticket> list_M=new ArrayList<Ticket>();
		tl.updateTicketData(list_M);
		for(int i=0;i<list_M.size();i++) {
			String filePath = "C:\\Users\\Administrator\\eclipse-workspace\\hanpuku3\\src\\db\\TicketObject";
			File newfile = new File(filePath+"\\TicketObj"+i+".ser");
			try{
			    newfile.createNewFile();
			}catch(IOException e){
			    System.out.println(e);
			}
			
			ticket = list_M.get(i);
			try(FileOutputStream fos = new FileOutputStream(filePath+"\\TicketObj"+i+".ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(ticket);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}

