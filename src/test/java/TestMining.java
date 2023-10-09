import org.bitcoin.mining.to.sat.service.Miner;
import org.junit.Before;
import org.junit.Test;
import testdata.TestData;

public class TestMining {

    private Miner miner;

    @Before
    public void init() {
        this.miner = new Miner();
    }

    // The target is lower than the actual one
    @Test
    public void testMiningTimeWithBlock100500Th() {
        long startTime = System.currentTimeMillis();
        miner.mineRandom(TestData.getBlock100500ThExample());
        long endTime = System.currentTimeMillis();

        System.out.println("Random mining takes time up to: " + (endTime-startTime));

        startTime = System.currentTimeMillis();
        miner.mineIncrement(TestData.getBlock100500ThExample());
        endTime = System.currentTimeMillis();

        System.out.println("Incremental mining takes time up to: " + (endTime-startTime));
    }

    // The target is lower than the actual one
    @Test
    public void testMiningTimeWithBlock670500Th() {
        long startTime = System.currentTimeMillis();
        miner.mineRandom(TestData.getBlock670500ThExample());
        long endTime = System.currentTimeMillis();

        System.out.println("Random mining takes time up to: " + (endTime-startTime));

        startTime = System.currentTimeMillis();
        miner.mineIncrement(TestData.getBlock670500ThExample());
        endTime = System.currentTimeMillis();

        System.out.println("Incremental mining takes time up to: " + (endTime-startTime));
    }

    // The target is lower than the actual one

    /**
     * This test runs for 1h 52m on a I5 9600k.
     */
    @Test
    public void testMiningTimeWithBlock670500Th2() {
        long startTime = System.currentTimeMillis();
        miner.mineRandom(TestData.getBlock670500ThExample2());
        long endTime = System.currentTimeMillis();

        System.out.println("Random mining takes time up to: " + (endTime-startTime));

        startTime = System.currentTimeMillis();
        miner.mineIncrement(TestData.getBlock670500ThExample2());
        endTime = System.currentTimeMillis();

        System.out.println("Incremental mining takes time up to: " + (endTime-startTime));
    }
}
