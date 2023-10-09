import org.bitcoin.mining.to.sat.service.Miner;
import org.junit.Before;
import org.junit.Test;
import testdata.TestData;

import static org.junit.Assert.assertNotNull;

public class TestBlockHashing {
    private Miner miner;

    @Before
    public void init() {
        this.miner = new Miner();
    }

    @Test
    public void testMineWith4Difficulty() {
        final String blockHash = miner.mineRandom(TestData.getBlock100500Th());
        assertNotNull(blockHash);
    }
}
