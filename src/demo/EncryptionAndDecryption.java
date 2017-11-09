package demo;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

/**
 * Created by 54472 on 2017/10/24.
 */
public class EncryptionAndDecryption {
    private static String sKey = "abcdef0123456789";
    private static String ivParameter = "0123456789abcdef";

    //加密
    public static String encrypt(String str) {
        String result = null;
        try {
            Cipher cipher;
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] raw = sKey.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(raw, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(str.getBytes("UTF-8"));
            result = new BASE64Encoder().encode(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(result);
        return result;
    }

    //解密
    public static String decrypt(String str) {
        try {
            byte[] raw = new byte[0];
            raw = sKey.getBytes("ASCII");
            SecretKeySpec secretKeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] encrypted = new BASE64Decoder().decodeBuffer(str);
            byte[] original = cipher.doFinal(encrypted);
            String originalString = new String(original, EncodingUtil.CHART_SET);

            System.out.println(originalString);
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class EncodingUtil {

        public static final String CHART_SET = "UTF-8";

        /**
         * 中文乱码处理
         *
         * @param content 乱码字符
         */
        public static String decode(String content) throws UnsupportedEncodingException {
            return java.net.URLDecoder.decode(content, CHART_SET);
        }

        /**
         * URL传值乱码处理
         *
         * @throws UnsupportedEncodingException
         */
        public static String urlDecode(String urlParam) throws UnsupportedEncodingException {
            return new String(urlParam.getBytes("iso8859-1"), "utf-8");
        }
    }
}
