import org.bitcoin.mining.to.sat.util.BlockUtil;
import org.junit.Test;

public class TestLoops {

    /**
     * This loop runs for a very long amount of time. > 29 minutes.
     */
    @Test
    public void testForLoopWithMaximumNonce() {
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < BlockUtil.MAXIMUM_NONCE; i++) {
            long x = i*2;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Looping through all possible nonce values takes up to: " + (endTime-startTime));
    }
}
