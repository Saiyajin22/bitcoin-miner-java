package org.bitcoin.mining.to.sat;

import org.bitcoin.mining.to.sat.model.Block;
import org.bitcoin.mining.to.sat.model.BlockHeader;
import org.bitcoin.mining.to.sat.service.Miner;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final Miner miner = new Miner();
        final BlockHeader blockHeader = new BlockHeader(
                1,
                "000000000001b2cdb438f6324a9311fae34aceff519333d1d11164ddaa87a409", // The 100499Th BTC block hash
                "9ac2659ba7ad885813586c2f47e3c3ad0987b31f974c8669a130ae753a43495c",
                1293883796,
                "1fffffff", // This differs from the actual bits which was: 0x1b04864c
                0L // Not sure if it's right, but nonce will change all the time so the initial shouldn't matter
        );
        // This mimics the 100,500Th block in BTC's blockchain
        final Block block = new Block(
                438,
                blockHeader,
                2,
                new ArrayList<>()
        );

        miner.mineSAT(block);
        System.out.println("End of program");

    }
}