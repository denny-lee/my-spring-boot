package com.lee;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 签名util.
 */
public class SignUtil {


    public static String getSignContent(Map<String, String> sortedParams) {
        StringBuffer content = new StringBuffer();
        ArrayList keys = new ArrayList(sortedParams.keySet());
        Collections.sort(keys);
        int index = 0;

        for (int i = 0; i < keys.size(); ++i) {
            String key = (String) keys.get(i);
            String value = (String) sortedParams.get(key);
            if (null!=key && null !=value) {
                content.append((index == 0 ? "" : "&") + key + "=" + value);
                ++index;
            }
        }

        return content.toString();
    }

    private static String byte2hex(byte[] b) {
        StringBuffer buf = new StringBuffer();
        int i;

        for (int offset = 0; offset < b.length; offset++) {
            i = b[offset];
            if (i < 0)
                i += 256;
            if (i < 16)
                buf.append("0");
            buf.append(Integer.toHexString(i));
        }

        return buf.toString();
    }

    public static String md5Sign(String content, String secretKey, String charset, String signType) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        content = content + "&secret_key=" + secretKey;

        MessageDigest md = MessageDigest.getInstance(signType);
        return byte2hex(md.digest(content.getBytes(charset)));
    }

    public static boolean md5Check(String content, String sign, String secretKey, String charset, String signType) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        content = content + "&secret_key=" + secretKey;
        MessageDigest md = MessageDigest.getInstance(signType);
        String mySign = byte2hex(md.digest(content.getBytes(charset)));
        return org.apache.commons.lang3.StringUtils.equals(mySign, sign);

    }

    public static String getSignCheckContent(Map<String, String> params) {
        if (params == null) {
            return null;
        } else {
            params.remove("sign");
            StringBuffer content = new StringBuffer();
            List<String> keys = new ArrayList(params.keySet());
            Collections.sort(keys);

            for(int i = 0; i < keys.size(); ++i) {
                String key = (String)keys.get(i);
                String value = (String)params.get(key);
                content.append((i == 0 ? "" : "&") + key + "=" + value);
            }

            return content.toString();
        }
    }
}
