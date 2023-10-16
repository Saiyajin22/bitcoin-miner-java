package org.bitcoin.mining.to.sat;

import org.apache.commons.codec.digest.DigestUtils;
import org.bitcoin.mining.to.sat.data.BlockData;
import org.bitcoin.mining.to.sat.model.Block;
import org.bitcoin.mining.to.sat.util.BlockUtil;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
//        runSAT();
//        run1();
        run2();
    }

    public static void runSAT() {
        final Block block = BlockData.getBlock100500ThExample();
        final String targetDifficulty = BlockUtil.convertBitsToTarget(block.getHeader().getBits());

        long nonce = 510;
        int flag = 0;

        block.getHeader().setNonce(nonce);

        final String sha256hex = DigestUtils.sha256Hex(DigestUtils.sha256Hex(block.getHeader().toString()));

        // Here we check if the hash is valid
        if (Objects.nonNull(sha256hex)) {
            flag = 1;
        }

        assert (flag == 0);
    }

    public static void run1() {
        int x = 0;
        for(int i = 0; i < 100000; i++) {
            x++;
        }

        assert (x == 0);
    }

    public static void run2() {
        int x = 0;
        int y = 10;
        y++;
        x += y;
        String s = "";
        String k = "";
        while(x < 100000) {
            x++;
            s += String.valueOf(x);
            s += String.valueOf(x);
        }
        int z = x + y;
        if(x == 500) {
            x = 2;
        }

        assert (x == 0);
    }


}