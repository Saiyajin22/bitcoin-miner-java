package org.bitcoin.mining.to.sat.data;

import org.bitcoin.mining.to.sat.model.Block;
import org.bitcoin.mining.to.sat.model.BlockHeader;

import java.util.ArrayList;

public class BlockData {
    public static Block getBlock100500ThExample() {
//        return new Block(
//                438,
//                new BlockHeader(
//                        1,
//                        "000000000001b2cdb438f6324a9311fae34aceff519333d1d11164ddaa87a409", // The 100499Th BTC block hash
//                        "9ac2659ba7ad885813586c2f47e3c3ad0987b31f974c8669a130ae753a43495c",
//                        1293883796,
//                        "1fffffff", // This differs from the actual bits which was: 0x1b04864c
//                        0L // Not sure if it's right, but nonce will change all the time so the initial shouldn't matter
//                ),
//                2,
//                new ArrayList<>()
//        );
        return new Block(
                0
        );
    }

    public static Block getBlock670500ThExample() {
        final BlockHeader blockHeader = new BlockHeader(
                536928256, // 2000E000
                "0000000000000000000a4897e7aa310a0f9306a27e4e41750c176ec54b91f933", // The 670499Th BTC block hash
                "2eb2501787bf2387b3f5835b9cee507e8a51aa98ca636ac2f1f9faa58f95612c",
                1613265748,
                "1effffff", // This differs from the actual bits which was: 0x1b04864c
                0L // Not sure if it's right, but nonce will change all the time so the initial shouldn't matter
        );

        final Block block = new Block(
                1190378,
                blockHeader,
                1412,
                new ArrayList<>()
        );

        return block;
    }

    public static Block getBlock670500ThExample2() {
        final BlockHeader blockHeader = new BlockHeader(
                536928256, // 2000E000
                "0000000000000000000a4897e7aa310a0f9306a27e4e41750c176ec54b91f933", // The 670499Th BTC block hash
                "2eb2501787bf2387b3f5835b9cee507e8a51aa98ca636ac2f1f9faa58f95612c",
                1613265748,
                "1cffffff", // This differs from the actual bits which was: 0x1b04864c
                0L // Not sure if it's right, but nonce will change all the time so the initial shouldn't matter
        );

        final Block block = new Block(
                1190378,
                blockHeader,
                1412,
                new ArrayList<>()
        );

        return block;
    }
}
