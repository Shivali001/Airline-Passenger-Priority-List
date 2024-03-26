
import java.util.Comparator;

public class PassengerComparator implements Comparator<Passenger>{


	public int compare(Passenger a, Passenger b) {
		if(a.getFareCode().compareTo(b.getFareCode()) <0){
			return -1;
		}
		else if(a.getFareCode().compareTo(b.getFareCode())==0){
			if(a.getFlyerStatus().compareTo(b.getFlyerStatus())<0){
				return -1;
			}
			else if(a.getFlyerStatus().compareTo(b.getFlyerStatus())>0){
				return 1;
			}
			else{
				return a.getTime().compareTo(b.getTime());
		}
		
	}
		return 1;
	
}
}

