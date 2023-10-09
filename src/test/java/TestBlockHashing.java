import org.bitcoin.mining.to.sat.model.Block;
import org.bitcoin.mining.to.sat.model.BlockHeader;
import org.bitcoin.mining.to.sat.service.Miner;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class TestBlockHashing {

    private Block block;
    private BlockHeader blockHeader;
    private Miner miner;

    @Before
    public void init() {
        this.blockHeader = new BlockHeader(
                1,
                "000000000001b2cdb438f6324a9311fae34aceff519333d1d11164ddaa87a409", // The 100499Th BTC block hash
                "9ac2659ba7ad885813586c2f47e3c3ad0987b31f974c8669a130ae753a43495c",
                1293883796,
                "1fffffff", // This differs from the actual bits which was: 0x1b04864c
                0L // Not sure if it's right, but nonce will change all the time so the initial shouldn't matter
        );

        this.block = new Block(
                438,
                this.blockHeader,
                2,
                new ArrayList<>()
        );

        this.miner = new Miner();
    }

    @Test
    public void testMineWith4Difficulty() {
        final String blockHash = miner.mineRandom(block);
        assertNotNull(blockHash);
    }
}
