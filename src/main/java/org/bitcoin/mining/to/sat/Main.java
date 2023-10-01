package org.bitcoin.mining.to.sat;

import org.bitcoin.mining.to.sat.model.BlockHeader;
import org.bitcoin.mining.to.sat.service.Miner;

public class Main {
    public static void main(String[] args) {
        final Miner miner = new Miner();
        final BlockHeader genesisBlock = new BlockHeader(
                1L,
                "000000000019d6689c085ae165831e934ff763ae46a2a6c172b3f1b60a8c", // It's BTC's genesis block's hash
                null,
                null,
                1231006505,
                "0000",
                0
        );

        miner.mineSAT(genesisBlock);
        System.out.println("End of program");
    }
}