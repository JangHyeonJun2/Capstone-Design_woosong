public class Main {
    public static void main(String[] args) {
    	
//        try {
//            (new Serial()).connect("COM5");
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    	ParkingLot pl = new ParkingLot();
//    	String temp = new String (buffer,0,len);
//    	Thread.sleep(500);
    	pl.addParkingLot("15"); //DB에 저장하는 메서드 호출
//    	System.out.print(temp);
        
    }
}