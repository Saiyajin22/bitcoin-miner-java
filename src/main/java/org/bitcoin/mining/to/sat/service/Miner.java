package org.bitcoin.mining.to.sat.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.bitcoin.mining.to.sat.model.BlockHeader;
import org.bitcoin.mining.to.sat.util.BlockUtil;

import java.sql.Timestamp;
import java.util.Random;

public class Miner {

    public BlockHeader mine(final BlockHeader blockHeader) {
        final String targetDifficulty = blockHeader.getTargetDifficulty();
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

                return new BlockHeader(
                        blockHeader.getVersion(),
                        newBlockHash,
                        blockHeader.getPreviousHash(),
                        blockHeader.getMerkleRoot(),
                        new Timestamp(System.currentTimeMillis()).getTime(),
                        blockHeader.getTargetDifficulty(),
                        nonce
                );
            }
        }
    }

    public void mineSAT(final BlockHeader blockHeader, int numberOfLeadingZeros, int lastIteration) {
        final String targetDifficulty = blockHeader.getTargetDifficulty();
        int counter = 0;

        while (true) {
            counter++;
            if (counter == lastIteration) {
                break;
            }
            int flag = 0;
            long nonce = new Random().nextLong();
            blockHeader.setNonce(nonce);

            try {
                String sha256hex = DigestUtils.sha256Hex(DigestUtils.sha256Hex(blockHeader.toString()));
                boolean isValidHash = true;
                // Check leading zeros
                for (int i = 0; i < numberOfLeadingZeros; i++) {
                    if (sha256hex.charAt(i) != '0') {
                        isValidHash = false;
                    }
                }

                if (isValidHash) {
                    if (!BlockUtil.compareHexadecimalStrings(sha256hex.substring(numberOfLeadingZeros), targetDifficulty.substring(numberOfLeadingZeros))) {
                        assert (flag == 0);
                    } else {
                        assert (nonce == 0);
                        break;
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void mineWithGivenNonce(final BlockHeader blockHeader, final long nonce) {
        blockHeader.setNonce(nonce);
        String sha256hex = DigestUtils.sha256Hex(DigestUtils.sha256Hex(blockHeader.toString()));

        BlockHeader blockHeader1 = new BlockHeader(
                blockHeader.getVersion(),
                sha256hex,
                blockHeader.getPreviousHash(),
                blockHeader.getMerkleRoot(),
                new Timestamp(System.currentTimeMillis()).getTime(),
                blockHeader.getTargetDifficulty(),
                nonce
        );

        blockHeader1.printBlockHeader();
    }
}
