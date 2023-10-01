import org.bitcoin.mining.to.sat.model.BlockHeader;
import org.bitcoin.mining.to.sat.util.BlockUtil;
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
                0L,
                "0x000000000FFFFFF",
                "0x000000112FFFFFF",
                "BlockHeader#2",
                12453443L,
                "0x00F",
                0L
        );

        this.blockHeader2 = new BlockHeader(
                1L,
                "0x00FF",
                "0x12FF",
                "Block32",
                23232L,
                "0x00F",
                2
        );
    }

    @Test
    public void testBlockCreation() {
        assertEquals(blockHeader1.getHash(), "0x000000000FFFFFF");
    }

    @Test
    public void testBlockStringRepresentation() {
        final String expectedResult = blockHeader2.getVersion() +
                blockHeader2.getHash() +
                blockHeader2.getPreviousHash() +
                blockHeader2.getMerkleRoot() +
                blockHeader2.getTimeStamp() +
                blockHeader2.getTargetDifficulty() +
                blockHeader2.getNonce();

        assertEquals(blockHeader2.toString(), expectedResult);
    }

    @Test
    public void testBlockHashSHA256() {
        final byte[] byteHash = BlockUtil.sha256(blockHeader1.toString());
        final String hexadecimalStringHash = BlockUtil.getHexadecimalStringHash(byteHash);
        System.out.println(hexadecimalStringHash);

        assertNotNull(hexadecimalStringHash);
        assertEquals(hexadecimalStringHash.length(), 64);
    }
}
