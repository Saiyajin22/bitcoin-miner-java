package org.bitcoin.mining.to.sat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockHeader {
    //{Header: Hash+everything else }{Body: Prev.Hash, Nonce, MR, Timestamp}
    private long version;
    private String hash;
    private String previousHash;
    private String merkleRoot;
    private long timeStamp;
    private String targetDifficulty;
    private long nonce;

    // TODO Remove the hash from the toString method! Modify the structure based on Hamza's advices.
    @Override
    public String toString() {
        return version + hash + previousHash + merkleRoot + timeStamp + targetDifficulty + nonce;
    }

    public void printBlockHeader() {
        System.out.println("Version: " + version);
        System.out.println("Hash: " + hash);
        System.out.println("Prev hash: " + previousHash);
        System.out.println("Merkleroot: " + merkleRoot);
        System.out.println("Timestamp: " + timeStamp);
        System.out.println("Target difficulty: " + targetDifficulty);
        System.out.println("Nonce: " + nonce);
    }

}
