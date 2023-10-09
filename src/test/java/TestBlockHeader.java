import org.apache.commons.codec.digest.DigestUtils;
import org.bitcoin.mining.to.sat.model.BlockHeader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestBlockHeader {
    private BlockHeader blockHeader1;
    private BlockHeader blockHeader2;

    @Before
    public void init() {
        this.blockHeader1 = new BlockHeader(
                0,
                "0x000000000FFFFFF",
                "0x000000112FFFFFF",
                12453443L,
                "0x00F",
                0L
        );

        this.blockHeader2 = new BlockHeader(
                1,
                "0x00FF",
                "0x12FF",
                23232L,
                "0x00F",
                2L
        );
    }

    @Test
    public void testBlockCreation() {
        assertEquals(blockHeader1.getBits(), "0x00F");
    }

    @Test
    public void testBlockStringRepresentation() {
        final String expectedResult = blockHeader2.getVersion() +
                blockHeader2.getPrevBlockHash() +
                blockHeader2.getMerkleRoot() +
                blockHeader2.getTimeStamp() +
                blockHeader2.getBits() +
                blockHeader2.getNonce();

        assertEquals(blockHeader2.toString(), expectedResult);
    }

    @Test
    public void testBlockHashSHA256() {
        final String hash = DigestUtils.sha256Hex(blockHeader1.toString());

        assertNotNull(hash);
        assertEquals(hash.length(), 64);
    }
}
