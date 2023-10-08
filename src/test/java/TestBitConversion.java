import org.bitcoin.mining.to.sat.util.BlockUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestBitConversion {

    @Test
    public void testConvert() {
        final String target = BlockUtil.convertBitsToTarget("1d00ffff");
        assertEquals(target, "00000000ffff0000000000000000000000000000000000000000000000000000");
    }

    @Test
    public void testConvert2() {
        final String target = BlockUtil.convertBitsToTarget("1b04864c");
        assertEquals(target, "000000000004864c000000000000000000000000000000000000000000000000");
    }

    @Test
    public void testConvert3() {
        final String target = BlockUtil.convertBitsToTarget("180130e0");
        assertEquals(target, "00000000000000000130e0000000000000000000000000000000000000000000");
    }
}
