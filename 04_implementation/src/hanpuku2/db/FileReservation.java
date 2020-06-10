package db;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import domain.ReservationList;
import domain.Reservation;

public class FileReservation {
	public void getReservationdata(ReservationList ReservationList) {
		File dir = new File("C:\\Users\\Administrator\\eclipse-workspace\\hanpuku2\\src\\db\\ReservationObject");
		File[] list = dir.listFiles(); 
		ArrayList<Reservation> list_M = new ArrayList<Reservation>();
		Reservation reservation=null;
		for(int i =0;i<list.length;i++) {
			try(FileInputStream file = new FileInputStream(list[i]);
				ObjectInputStream obj = new ObjectInputStream(file)){
				try {
					reservation = (Reservation)obj.readObject();
				}catch(Exception e) {
					
				}
				if(reservation!=null) {
					list_M.add(reservation);
				}
					
			}catch(IOException e) {
				
			}
		}
		ReservationList.downlodeReservationData(list_M);
	}
	
	public void setReservationdata(ReservationList ml) {
		Reservation reservation;
		
		try {
            File dir = new File("C:\\Users\\Administrator\\eclipse-workspace\\hanpuku2\\src\\db\\ReservationObject");
    		File[] list = dir.listFiles();
            if(list!=null) {
            	for(File file: list) {
                    file.delete();
                }
            }
        }catch(Throwable th) {
            th.printStackTrace();
        }
		
		ArrayList<Reservation> list_M=new ArrayList<Reservation>();
		ml.updateReservationData(list_M);
		for(int i=0;i<list_M.size();i++) {
			String filePath = "C:\\Users\\Administrator\\eclipse-workspace\\hanpuku2\\src\\db\\ReservationObject";
			File newfile = new File(filePath+"\\ReservationObj"+i+".ser");
			try{
			    newfile.createNewFile();
			}catch(IOException e){
			    System.out.println(e);
			}
			
			reservation = list_M.get(i);
			try(FileOutputStream fos = new FileOutputStream(filePath+"\\ReservationObj"+i+".ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(reservation);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
