package com.jeeplus.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

/**
 * DES加密解密类
 * Created by yuzp17311 on 2016/8/31.
 */
public class DesUtils {

    private static Logger logger= LoggerFactory.getLogger(DesUtils.class);

    private static Key key;
    private static String KEY_STR="jeeplus";
    static {
        try {
            KeyGenerator generator=KeyGenerator.getInstance("DES");
            SecureRandom secureRandom=SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(KEY_STR.getBytes());
            key=generator.generateKey();
            generator=null;
        }catch (Exception e){
            logger.error("运行时异常："+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * 对字符串进行加密，返回BASE64的加密字符串
     * @param string 要进行加密的字符串
     * @return
     */
    public static String getEncryptString(String string){
        BASE64Encoder base64Encoder=new BASE64Encoder();
        System.out.println(key);
        try {
            byte[] strBytes=string.getBytes("UTF-8");
            Cipher cipher=Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] encryptStrBytes=cipher.doFinal(strBytes);
            return base64Encoder.encode(encryptStrBytes);
        }catch (Exception e){
            logger.error("对字符串加密失败："+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     *  对BASE64加密字符串进行解密
     * @param string 要进行解密的字符串
     * @return
     */
    public static String getDecryptString(String string){
        BASE64Decoder base64Decoder=new BASE64Decoder();
        try {

            byte[] strBytes=base64Decoder.decodeBuffer(string);
            Cipher cipher=Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE,key);
            byte[] encryptStrBytes=cipher.doFinal(strBytes);
            return new String(encryptStrBytes,"UTF-8");
        }catch (Exception e){
            logger.error("对字符串解密失败："+e.getMessage());
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args)
    {
        String name ="root";
        String password="yzp140103";
        String encryname = getEncryptString(name);
        String encrypassword = getEncryptString(password);
        System.out.println(encryname);
        System.out.println(encrypassword);

        System.out.println(getDecryptString(encryname));
        System.out.println(getDecryptString(encrypassword));
    }


}
