package org.bitcoin.mining.to.sat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Block {
    private final String magicNumber = "D9B4BEF9";
    private int size; // Size in bytes. It's maximum is 1MB (in case of Bitcoin)
    private BlockHeader header; // 80 Byte field containing six individual components
    private int txCount;
    private List<Transaction> transactions;

    public Block(int size) {
        this.size = size;
    }
}
