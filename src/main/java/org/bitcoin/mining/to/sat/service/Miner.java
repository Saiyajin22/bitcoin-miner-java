package org.bitcoin.mining.to.sat.service;

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

    public void mineSAT(final BlockHeader blockHeader) {
        final String targetDifficulty = blockHeader.getTargetDifficulty();
        long nonce;

        while (true) {
            int flag = 0;
            nonce = new Random().nextLong();
            blockHeader.setNonce(nonce);

            final byte[] byteHash = BlockUtil.sha256(BlockUtil.sha256(blockHeader.toString()));
            final String newBlockHash = BlockUtil.getHexadecimalStringHash(byteHash);
            // TODO Assume leading zeros!

            if (!newBlockHash.startsWith(targetDifficulty)) {
                flag = 1;
            }

            assert(flag == 1);
        }
    }
}
