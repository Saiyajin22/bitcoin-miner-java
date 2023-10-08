package org.bitcoin.mining.to.sat.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.bitcoin.mining.to.sat.model.Block;
import org.bitcoin.mining.to.sat.model.BlockHeader;
import org.bitcoin.mining.to.sat.util.BlockUtil;

import java.util.Objects;
import java.util.Random;

public class Miner {

    public String mine(final BlockHeader blockHeader) {
        final String targetDifficulty = blockHeader.getBits();
        long nonce;

        while (true) {
            nonce = new Random().nextLong();
            blockHeader.setNonce(nonce);

            final byte[] byteHash = BlockUtil.sha256(BlockUtil.sha256(blockHeader.toString()));
            final String newBlockHash = BlockUtil.getHexadecimalStringHash(byteHash);

            if (newBlockHash.startsWith(targetDifficulty)) {
                System.out.println("BlockHeader mined!");
                System.out.println("Valid Nonce: " + nonce);
                System.out.println("New BlockHeader Hash: " + newBlockHash);

                return newBlockHash;
            }
        }
    }

    public String convertBitsToTarget(final String bits) {
        if (Objects.isNull(bits) || bits.length() != 8) {
            throw new RuntimeException("The bits should be a 8 character long string");
        }
        final StringBuilder target = new StringBuilder();
        final String exponent = bits.substring(0, 2);
        final String coefficient = bits.substring(2, 8);
        long exponentAsDecimal = Long.parseLong(exponent, 16);

        for (int i = 0; i < 64 - (exponentAsDecimal * 2); i++) {
            target.append("0");
        }
        target.append(coefficient);
        for (int i = 0; i < exponentAsDecimal * 2 - 6; i++) {
            target.append("0");
        }

        return target.toString();
    }

    public void mineSAT(final Block block, int numberOfLeadingZeros, int lastIteration) {
        final String targetDifficulty = convertBitsToTarget(block.getHeader().getBits());
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
