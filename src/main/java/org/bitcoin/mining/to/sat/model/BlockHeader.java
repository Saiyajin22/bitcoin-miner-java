package org.bitcoin.mining.to.sat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockHeader {
    private int version;
    private String prevBlockHash;
    private String merkleRoot;
    private long timeStamp;
    private String bits; // Simplified representation of the target difficulty
    private long nonce;

    @Override
    public String toString() {
        return version + prevBlockHash + merkleRoot + timeStamp + bits + nonce;
    }

    public void printBlockHeader() {
        System.out.println("Version: " + version);
        System.out.println("Prev hash: " + prevBlockHash);
        System.out.println("Merkleroot: " + merkleRoot);
        System.out.println("Timestamp: " + timeStamp);
        System.out.println("Target difficulty: " + bits);
        System.out.println("Nonce: " + nonce);
    }

}
