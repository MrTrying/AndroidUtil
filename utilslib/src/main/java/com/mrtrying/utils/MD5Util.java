package com.mrtrying.utils;

import android.util.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Description :
 * PackageName : com.mrtrying.utils
 * Created by mrtrying on 2019/6/27 17:10.
 * e_mail : ztanzeyu@gmail.com
 */
public class MD5Util {

    /**
     * @param value
     *
     * @return
     */
    public static String encode(String value) {
        byte[] bytes = new byte[0];

        try {
            bytes = MessageDigest.getInstance("MD5").digest(value.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayToHexString(bytes).toString();
    }

    /**
     * @param value
     *
     * @return
     */
    public static String encodeBase64String(String value) {
        byte[] bytes = Base64.decode(value, 0);

        try {
            return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(bytes)).toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param file
     *
     * @return
     */
    public static String encode(File file) {
        int bufferSize = 1024;
        FileInputStream fis = null;
        DigestInputStream dis = null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            fis = new FileInputStream(file);
            dis = new DigestInputStream(fis, messageDigest);

            byte[] buffer = new byte[bufferSize];

            while (dis.read(buffer) > 0) ;

            messageDigest = dis.getMessageDigest();

            byte[] bytes = messageDigest.digest();

            return byteArrayToHexString(bytes).toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @param bytes
     *
     * @return
     */
    public static StringBuilder byteArrayToHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            if ((b & 0xFF) < 0x10) {
                //避免出现0x5这样的数字，应该是0x05
                hex.append("0");
            }
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex;
    }
}

