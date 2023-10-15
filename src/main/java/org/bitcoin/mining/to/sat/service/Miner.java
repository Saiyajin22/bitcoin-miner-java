package org.bitcoin.mining.to.sat.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.bitcoin.mining.to.sat.model.Block;
import org.bitcoin.mining.to.sat.util.BlockUtil;

import java.security.SecureRandom;

public class Miner {

    public static String mineRandom(final Block block) {
        final String targetDifficulty = BlockUtil.convertBitsToTarget(block.getHeader().getBits());
        long step = 0;
        long nonce = 0;

        while (step <= BlockUtil.MAXIMUM_NONCE) {
            if (step != 0) {
                nonce = new SecureRandom().nextLong() % (BlockUtil.MAXIMUM_NONCE + 1);
            }
            block.getHeader().setNonce(nonce);
            final String hash = DigestUtils.sha256Hex(DigestUtils.sha256Hex(block.getHeader().toString()));
            if (BlockUtil.compareHexadecimalStrings(hash, targetDifficulty)) {
                return hash;
            }
            step++;

            // If no nonce was good, repeat the process with changed timestamp
            if (step > BlockUtil.MAXIMUM_NONCE) {
                block.getHeader().setTimeStamp(System.currentTimeMillis());
                nonce = 0;
                step = 0;
            }
        }

        return null;
    }

    public static String mineIncrement(final Block block) {
        final String targetDifficulty = BlockUtil.convertBitsToTarget(block.getHeader().getBits());
        long nonce = -1;

        while (nonce <= BlockUtil.MAXIMUM_NONCE) {
            nonce++;
            block.getHeader().setNonce(nonce);
            final String hash = DigestUtils.sha256Hex(DigestUtils.sha256Hex(block.getHeader().toString()));
            if (BlockUtil.compareHexadecimalStrings(hash, targetDifficulty)) {
                return hash;
            }
            nonce++;

            // If no nonce was good, repeat the process with changed timestamp
            if (nonce > BlockUtil.MAXIMUM_NONCE) {
                block.getHeader().setTimeStamp(System.currentTimeMillis());
                nonce = -1;
            }
        }

        return null;
    }

    public static void mineSAT(final Block block) {
        final String targetDifficulty = BlockUtil.convertBitsToTarget(block.getHeader().getBits());
        final long numberOfLeadingZeros = BlockUtil.getNumberOfLeadingZeros(block.getHeader().getBits());
        long nonce = -1;

        while (nonce <= BlockUtil.MAXIMUM_NONCE) {
            int flag = 0;
            nonce++;
            block.getHeader().setNonce(nonce);

            try {
                final String sha256hex = DigestUtils.sha256Hex(DigestUtils.sha256Hex(block.getHeader().toString()));
                boolean sufficientZeros = true;
                // Check leading zeros
                for (int i = 0; i < numberOfLeadingZeros; i++) {
                    if (sha256hex.charAt(i) != '0') {
                        sufficientZeros = false;
                        break;
                    }
                }

                // Here we check if the hash is valid
                if (sufficientZeros && BlockUtil.compareHexadecimalStrings(sha256hex.substring((int) numberOfLeadingZeros), targetDifficulty.substring((int) numberOfLeadingZeros))) {
                    flag = 1;
                }

                assert (flag == 0);

                // If no nonce was good, repeat the process with changed timestamp
                if (nonce > BlockUtil.MAXIMUM_NONCE) {
                    block.getHeader().setTimeStamp(System.currentTimeMillis());
                    nonce = -1;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void mineWithGivenNonce(final Block block, final long nonce) {
        block.getHeader().setNonce(nonce);
        String sha256hex = DigestUtils.sha256Hex(DigestUtils.sha256Hex(block.getHeader().toString()));

        System.out.println("Found new hash: " + sha256hex + ", with nonce: " + nonce);
    }
}
