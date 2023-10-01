import org.bitcoin.mining.to.sat.util.BlockUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestHashComparison {

    @Test
    public void testHexadecimalStringComparisonWithTwoChars() {
        final String s1 = "00F";
        final String s2 = "0AF";

        final boolean result = BlockUtil.compareHexadecimalStrings(s1, s2);
        assertTrue(result);
    }

    @Test
    public void testHexadecimalStringComparisonWithMultipleChars() {
        final String s1 = "00F";
        final String s2 = "0AF";

        final boolean result1 = BlockUtil.compareHexadecimalStrings(s1, s2);
        assertTrue(result1);

        final String s3 = "0FFF";
        final String s4 = "00AF";

        final boolean result2 = BlockUtil.compareHexadecimalStrings(s3, s4);
        assertFalse(result2);
    }
}
