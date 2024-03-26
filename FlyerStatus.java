
import java.util.Random;

public enum FlyerStatus {
	Gold, Silver, Bronze, None;
	
	
	public static final FlyerStatus randomValues() {
		Random rand = new Random();
		int rvalues = rand.nextInt(4);
		FlyerStatus[] flyerstatus = FlyerStatus.values();
		
		return flyerstatus[rvalues];
		
	}
	
	

}
