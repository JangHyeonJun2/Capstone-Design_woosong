import java.io.IOException;

import java.io.InputStream;

public class SerialReader implements Runnable {
    InputStream in;
    String str;
   public SerialReader() {
        
    }
    
    public SerialReader(InputStream in) {
        this.in = in;
    }

    public void run() {
    	byte[] buffer = new byte[1024];
        int len = -1;
        try {
            while ((len = this.in.read(buffer)) > -1) {
                
                try {
                	ParkingLot pl = new ParkingLot();
                	String temp = new String (buffer,0,len);
                	Thread.sleep(500);
                	pl.addParkingLot(temp); //DB에 저장하는 메서드 호출
                	System.out.print(temp);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public String getter() {
//    	return 
//    }
    
}