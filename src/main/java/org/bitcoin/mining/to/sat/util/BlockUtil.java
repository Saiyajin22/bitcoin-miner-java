package org.bitcoin.mining.to.sat.util;

import lombok.NonNull;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class BlockUtil {

    public static byte[] sha256(@NonNull final String valueToHash) {
        final MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        try {
            return digest.digest(valueToHash.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] sha256(@NonNull final byte[] bytes) {
        final MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        try {
            return digest.digest(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getHexadecimalStringHash(final byte[] byteHash) {
        StringBuilder stringBuilder = new StringBuilder();
        for(byte b : byteHash) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }

    public static boolean compareHexadecimalStrings(String s1, String s2, String prefix) {
        if(Objects.equals(prefix, "0x")) {
            if(Long.parseLong(s1.substring(2), 16) < Long.parseLong(s2.substring(2), 16)) {
                return true;
            }
        }

        if(Long.parseLong(s1, 16) < Long.parseLong(s2, 16)) {
            return true;
        }

        return false;
    }

    public static long byteArrayToLong(final byte[] bytes) {
        long result = 0;
        for (int i = 0; i < bytes.length; i++) {
            result <<= 8;
            result |= (bytes[i] & 0xFF);
        }
        return result;
    }

    public static boolean compareByteArrays(final byte[] b1, final byte[] b2) {
        int length = Math.min(b1.length, b2.length);
        for (int i = 0; i < length; i++) {
            if(b1[i] < b2[i]) {
                return true;
            }
        }
        return false;
    }
}
