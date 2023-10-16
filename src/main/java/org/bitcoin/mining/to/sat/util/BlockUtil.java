package org.bitcoin.mining.to.sat.util;

import lombok.NonNull;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class BlockUtil {
    public static final long MAXIMUM_NONCE = 4294967295L;

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
        for (byte b : byteHash) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }

    public static boolean compareHexadecimalStrings(String s1, String s2) {
        if (s1 != null && s2 != null && s1.length() != s2.length()) {
            throw new RuntimeException("The two strings must be the same length!");
        }

        for (int i = 0; i < s1.length(); i++) {
            long firstNum = Long.parseLong(s1.substring(i, i + 1), 16);
            long secondNum = Long.parseLong(s2.substring(i, i + 1), 16);
            if (firstNum < secondNum) {
                return true;
            } else if (firstNum > secondNum) {
                return false;
            }
        }

        return true;
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
            if (b1[i] < b2[i]) {
                return true;
            }
        }
        return false;
    }

    public static String getTarget(final int difficulty) {
        StringBuilder target = new StringBuilder();
        for (int i = 0; i < difficulty; i++) {
            target.append("0");
        }
        for (int i = 0; i < 64 - difficulty; i++) {
            target.append("f");
        }
        return target.toString();
    }

    public static String convertBitsToTarget(final String bits) {
        if (Objects.isNull(bits) || bits.length() != 8) {
            throw new RuntimeException("The bits should be a 8 character long string");
        }
        final StringBuilder target = new StringBuilder();
        final String exponent = bits.substring(0, 2);
        final String coefficient = bits.substring(2, 8);
        long exponentAsDecimal = Long.parseLong(exponent, 16);

//        for (int i = 0; i < 64 - (exponentAsDecimal * 2); i++) {
//            target.append("0");
//        }
//        target.append(coefficient);
//        for (int i = 0; i < exponentAsDecimal * 2 - 6; i++) {
//            target.append("0");
//        }

        return target.toString();
    }

    public static long getNumberOfLeadingZeros(final String bits) {
        if (Objects.isNull(bits) || bits.length() != 8) {
            throw new RuntimeException("The bits should be a 8 character long string");
        }
        final String exponent = bits.substring(0, 2);
        long exponentAsDecimal = Long.parseLong(exponent, 16);

        return 64 - (exponentAsDecimal * 2);
    }
}
