package org.bitcoin.mining.to.sat;

import org.bitcoin.mining.to.sat.data.BlockData;
import org.bitcoin.mining.to.sat.service.Miner;

public class Main {
    public static void main(String[] args) {
        Miner.mineSAT(BlockData.getBlock100500ThExample());
    }
}