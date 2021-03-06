package com.platform.util;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.FactoryBean;

public final class EncryptDBUtil implements FactoryBean {

    /**
     * 加密密码
     */
    private String password;

    /**
     * 加密方法
     */
    private String encode(String secret) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
                                        BadPaddingException, IllegalBlockSizeException {
        byte[] kbytes = "caishujinfu".getBytes();
        SecretKeySpec key = new SecretKeySpec(kbytes, "Blowfish");

        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encoding = cipher.doFinal(secret.getBytes());
        BigInteger n = new BigInteger(encoding);
        return n.toString(16);
    }

    /**
     * 解密方法
     */
    public char[] decode(String secret) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
                                        BadPaddingException, IllegalBlockSizeException {
        byte[] kbytes = "caishujinfu".getBytes();
        SecretKeySpec key = new SecretKeySpec(kbytes, "Blowfish");

        BigInteger n = new BigInteger(secret, 16);
        byte[] encoding = n.toByteArray();

        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decode = cipher.doFinal(encoding);
        return new String(decode).toCharArray();
    }

    public String getObject() throws Exception {
        if (password != null) {
            return String.valueOf(decode(password));
        } else {
            return null;
        }
    }

    public Class<String> getObjectType() {
        return String.class;
    }

    public boolean isSingleton() {
        return true;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) throws Exception {

        EncryptDBUtil encrypt = new EncryptDBUtil();

        String secret = "caishulicai";
        String secText = encrypt.encode(secret);
        System.out.println(secText);

        System.out.println(encrypt.decode(secText));
    }

}
