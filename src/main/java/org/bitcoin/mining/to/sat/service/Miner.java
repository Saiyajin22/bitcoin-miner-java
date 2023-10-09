package org.bitcoin.mining.to.sat.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.bitcoin.mining.to.sat.model.Block;
import org.bitcoin.mining.to.sat.util.BlockUtil;

import java.security.SecureRandom;
import java.util.Random;

public class Miner {

    public String mineRandom(final Block block) {
        final String targetDifficulty = BlockUtil.convertBitsToTarget(block.getHeader().getBits());
        long step = 0;
        long nonce = 0;

        while (step <= BlockUtil.MAXIMUM_NONCE) {
            if(step != 0) {
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

    public String mineIncrement(final Block block) {
        final String targetDifficulty = BlockUtil.convertBitsToTarget(block.getHeader().getBits());
        long step = 0;
        long nonce = -1;

        while (step <= BlockUtil.MAXIMUM_NONCE) {
            nonce++;
            block.getHeader().setNonce(nonce);
            final String hash = DigestUtils.sha256Hex(DigestUtils.sha256Hex(block.getHeader().toString()));
            if (BlockUtil.compareHexadecimalStrings(hash, targetDifficulty)) {
                return hash;
            }
            step++;

            // If no nonce was good, repeat the process with changed timestamp
            if (step > BlockUtil.MAXIMUM_NONCE) {
                block.getHeader().setTimeStamp(System.currentTimeMillis());
                nonce = -1;
                step = 0;
            }
        }

        return null;
    }

    public void mineSAT(final Block block, int numberOfLeadingZeros, int lastIteration) {
        final String targetDifficulty = BlockUtil.convertBitsToTarget(block.getHeader().getBits());
        int counter = 0;

        while (true) {
            counter++;
            if (counter == lastIteration) {
                break;
            }
            long nonce = new Random().nextLong();
            block.getHeader().setNonce(nonce);

            try {
                String sha256hex = DigestUtils.sha256Hex(DigestUtils.sha256Hex(block.getHeader().toString()));
                boolean isValidHash = true;
                // Check leading zeros
                for (int i = 0; i < numberOfLeadingZeros; i++) {
                    if (sha256hex.charAt(i) != '0') {
                        isValidHash = false;
                        break;
                    }
                }

                if (isValidHash) {
                    if (BlockUtil.compareHexadecimalStrings(sha256hex.substring(numberOfLeadingZeros), targetDifficulty.substring(numberOfLeadingZeros))) {
                        assert (false);
                        break;
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void mineWithGivenNonce(final Block block, final long nonce) {
        block.getHeader().setNonce(nonce);
        String sha256hex = DigestUtils.sha256Hex(DigestUtils.sha256Hex(block.getHeader().toString()));

        System.out.println("Found new valid hash: " + sha256hex + ", with nonce: " + nonce);
    }
}
