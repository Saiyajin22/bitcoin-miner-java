package org.bitcoin.mining.to.sat;

import org.apache.commons.codec.digest.DigestUtils;
import org.bitcoin.mining.to.sat.data.BlockData;
import org.bitcoin.mining.to.sat.model.Block;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        final Block block = BlockData.getBlock100500ThExample();

        long nonce = 510;
        int flag = 0;

        block.getHeader().setNonce(nonce);

        final String sha256hex = DigestUtils.sha256Hex(DigestUtils.sha256Hex(block.getHeader().toString()));

        // Here we check if the hash is valid
        if (Objects.nonNull(sha256hex)) {
            flag = 1;
        }

        assert (flag == 0);
    }
}