import org.bitcoin.mining.to.sat.model.BlockHeader;
import org.bitcoin.mining.to.sat.service.Miner;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class TestBlockHashing {

    private BlockHeader difficulty4BlockHeader;
    private BlockHeader difficulty5BlockHeader;

    private BlockHeader difficulty6BlockHeader;
    private Miner miner;

    @Before
    public void init() {
        this.difficulty4BlockHeader = new BlockHeader(
                0L,
                "0x000000000FFFFFF",
                "0x000000112FFFFFF",
                "BlockHeader#2",
                12453443L,
                "0000",
                0L
        );

        this.difficulty5BlockHeader = new BlockHeader(
                1L,
                "0x00FF",
                "0x12FF",
                "Block32",
                23232L,
                "00000",
                2
        );

        this.difficulty6BlockHeader = new BlockHeader(
                1L,
                "0x00FF",
                "0x12FF",
                "Block32",
                23232L,
                "000000",
                2
        );

        this.miner = new Miner();
    }

    @Test
    public void testMineWith4Difficulty() {
        final BlockHeader newBlockHeader = miner.mine(difficulty4BlockHeader);
        assertNotNull(newBlockHeader);
    }

    @Test
    public void testMineWith5Difficulty() {
        final BlockHeader newBlockHeader = miner.mine(difficulty5BlockHeader);
        assertNotNull(newBlockHeader);
    }

    @Test
    public void testMineWith6Difficulty() {
        final BlockHeader newBlockHeader = miner.mine(difficulty6BlockHeader);
        assertNotNull(newBlockHeader);
    }
}
