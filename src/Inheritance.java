import java.util.stream.Stream;

class Vehicle{
	public Vehicle() {
		System.out.println("Vehicle constructor");
	}
    public void move(){
    	System.out.println("Vehicles can move!!");
    }
    public void own(){
        System.out.println("Vehicles are owned by me!!");
    }
         
}

class MotorBike extends Vehicle{
	public MotorBike() {
		System.out.println("MotorBike constructor");
	}
	public void move(){
    	System.out.println("MotorBike can move and accelerate too!!");
    }
    public void bikers(){
        System.out.println("I am a biker!!");
    }
}

public class Inheritance{
	static String message;
    public static void main(String[] args){
	    /*Vehicle vh1 = new Vehicle();
	    vh1.move();
	    vh1.own();
	    System.out.println("------------------------------------------");
	    MotorBike mb1 = new MotorBike();
	    mb1.move();
	    mb1.bikers();
	    System.out.println("------------------------------------------");
	    Vehicle vh = new MotorBike();
	    vh.move();    
	    //vh.bikers();
	    ((MotorBike)vh).bikers();
	    vh.own();
	    System.out.println("------------------------------------------");
	    // MotorBike mb2 = new Vehicle(); // error: child can't hold parent instance 
    */
    	/*int i = 0;
    	for(;;){
    		
    	}
    	Stream.of("1red","2red","3red").anyMatch(s -> {System.out.println(s);return s.startsWith("1");});
    	Stream.of("1RED","2RED","3RED").findFirst().map(String::toLowerCase).ifPresent(System.out::println);
    	System.out.println("0999999999999");;
    	Stream.of("1red","2red","3red").filter(s -> s.endsWith("1")).forEach(System.out::println);*/
    	try{
    		String message = getMessage();
    		System.out.println(message);
    		
    	}catch(Exception e){
    		message+="F";
    		System.out.print(message);
    	}finally{
    		System.out.println(message);
    	}
	}
    public static String getMessage() throws Exception {
    	String message = "A";
    	try{
    		throw new Exception();
    	} catch (Exception e) {
    		try {
    			try {
    				throw new Exception();
    			} catch (Exception ex) {
    				message += "B";
    			}
    			throw new Exception();
    		} catch (Exception x) {
    			message += "C";
    		} finally {
    			message += "D";
    		}    		
    	} finally {
    		message += "E";
    	}
    	return message;
    }
}
