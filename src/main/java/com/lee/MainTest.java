package com.lee;

import com.alibaba.fastjson.JSONObject;
import com.lee.controller.AnyController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Description:
 * On 2017/10/11 11:07 created by LW
 */
public class MainTest {
    public static void main(String[] args) {
        Date now = Calendar.getInstance().getTime();
        Calendar futurn = Calendar.getInstance();
        futurn.add(Calendar.YEAR, 1);
        futurn.add(Calendar.MONTH, 1);

        System.out.println(now.getTime() + "  " + futurn.getTime().getTime());
    }
    /*public static void main(String[] args) {
        String body = "{\"hair\":\"blond!\",\"ab\":\"blond!\"}";
        Map<String, String> param = JSONObject.parseObject(body, Map.class);

        String key = "3BQ47KVsh8PLlH4h96";
        String UTF8= "utf-8";
        String sorted = SignUtil.getSignContent(param);
        System.out.println(sorted);
        String ppp = "";
        try {
            String signedBody = SignUtil.md5Sign(sorted, key, UTF8, "md5");
            param.put("sign", signedBody);
            ppp = JSONObject.toJSONString(param);
            System.out.println(ppp);;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        param = JSONObject.parseObject(ppp, Map.class);
        String sign = param.get("sign");
        String nakedBody = SignUtil.getSignCheckContent(param);
        System.out.println(nakedBody);
        boolean valid = false;
        try {
            valid = SignUtil.md5Check(nakedBody, sign, key, UTF8, "md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(valid);
    }*/
}
