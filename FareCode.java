

import java.util.Random;


public enum FareCode {
    Full, Disc, Buddy;

    /**
     * Generates a random fare code.
     *
     * @return A randomly selected fare code.
     */
    public static final FareCode randomValue() {
        Random rand = new Random();
        int rvalues = rand.nextInt(3);
        FareCode[] fares = FareCode.values();
        return fares[rvalues];
    }
}