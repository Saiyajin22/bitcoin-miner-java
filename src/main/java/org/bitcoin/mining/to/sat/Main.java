package org.bitcoin.mining.to.sat;

import org.bitcoin.mining.to.sat.model.BlockHeader;
import org.bitcoin.mining.to.sat.service.Miner;

public class Main {
    public static void main(String[] args) {
        final Miner miner = new Miner();
        final BlockHeader genesisBlock = new BlockHeader(
                1L,
                "000000000019d6689c085ae165831e934ff763ae46a2a6c172b3f1b60a8ce26f", // It's BTC's genesis block's hash
                null,
                null,
                1231006505,
                "004b6a2cba19d6689c085ae165831e934ff763ae46a2a6c172b3f1b60a8c1234",
                0
        );

        miner.mineSAT(genesisBlock, 2, 10000);
//            miner.mineWithGivenNonce(genesisBlock, 74240);
        System.out.println("End of program");

    }
}