
import java.sql.Timestamp;
import java.util.Date;

public class Passenger implements Comparable{
    private String passportnumber;
    private FareCode farecode;
    private FlyerStatus flyerStatus;
    private Timestamp time;


public Passenger(String pn) {
    	passportnumber = pn;
    	farecode = FareCode.randomValue();
    	flyerStatus = FlyerStatus.randomValues();
    	time = new Timestamp(System.currentTimeMillis());
    }
    
	
	public String getPassportNumber() {
		return passportnumber;
	}
    public FareCode getFareCode() {
    	return farecode;
    }
    public FlyerStatus getFlyerStatus() {
    	return flyerStatus;
    }
    public Timestamp getTime() {
    	return time;
    }
    
    public String toString() {
    	return "(Passport Number: "+ passportnumber+ ", Fare: " + farecode 
    			+ ", FlyerStatus: "+flyerStatus+", Time: "+ time+")";
    }
    


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Passenger p=(Passenger)o;
		return passportnumber.compareTo(p.passportnumber);
	}
}

