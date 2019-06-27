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
            //创建MD5转换器和文件流
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            fis = new FileInputStream(file);
            dis = new DigestInputStream(fis, messageDigest);

            byte[] buffer = new byte[bufferSize];
            //DigestInputStream实际上在流处理文件时就在内部就进行了一定的处理
            while (dis.read(buffer) > 0) ;

            //通过DigestInputStream对象得到一个最终的MessageDigest对象。
            messageDigest = dis.getMessageDigest();

            // 通过messageDigest拿到结果，也是字节数组，包含16个元素
            byte[] bytes = messageDigest.digest();
            // 同样，把字节数组转换成字符串
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

