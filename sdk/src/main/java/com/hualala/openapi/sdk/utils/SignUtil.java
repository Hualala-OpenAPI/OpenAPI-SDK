package com.hualala.openapi.sdk.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hualala.openapi.sdk.beans.PairBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class SignUtil {
    public static final String SIGNATURE = "signature";
    private static final String SIGNATURE_PREFIX = "key"; // 签名前缀
    private static final String SIGNATURE_SUFFIX = "secret"; // 签名后缀

    public static String getSHA_1(String encryptStr) throws Exception {
        try {
            if (StringUtils.isBlank(encryptStr)) {
                return null;
            }
            //指定sha1算法
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(encryptStr.getBytes());
            //获取字节数组
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            // 转换为全大写
            return hexString.toString().toUpperCase();
        } catch (Exception e) {
            //日志
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    private static List<PairBean<String>> parseValue(String key, Object value) {
        List<PairBean<String>> list = new ArrayList<>();

        if (null != value && !SIGNATURE.equalsIgnoreCase(key)) {
            if (value instanceof JSONArray) {
                JSONArray tmp = (JSONArray) value;
                if (!tmp.isEmpty()) {
                    Object element = tmp.get(0);
                    if (element instanceof JSONArray || element instanceof JSONObject) {
                        //list结构非空, 取第一个元素
                        list.addAll(parseValue(key, element));
                    }
                }
            } else if (value instanceof JSONObject) {
                JSONObject tmp = (JSONObject) value;
                for (String k : tmp.keySet()) {
                    list.addAll(parseValue(k, tmp.get(k)));
                }
            } else {
                list.add(new PairBean<>(key, value.toString()));
            }
        }

        return list;
    }

    public static String calcSign(String json) {
        String sign = null;

        JSONObject jsonObject = JSONObject.parseObject(json);
        if (null != jsonObject) {
            try {
                List<PairBean<String>> fieldList = parseValue(null, jsonObject);
                String paramList = fieldList.stream()
                    .sorted((a, b) -> a.getKey().compareToIgnoreCase(b.getKey()))
                    .map(e -> String.format("%s%s", e.getKey(), e.getValue()))
                    .collect(Collectors.joining());

                sign = getSHA_1(SIGNATURE_PREFIX + paramList + SIGNATURE_SUFFIX);
            } catch (Exception e) {
                log.error("签名异常 getSign json: {}", json, e);
            }
        }

        return sign;
    }

    /*
     * 加密
     * 1.构造密钥生成器
     * 2.根据ecnodeRules规则初始化密钥生成器
     * 3.产生密钥
     * 4.创建和初始化密码器
     * 5.内容加密
     * 6.返回字符串
     */
    public static String AESEncode(String appSecret, String content) throws Exception {
        try {
            if (StringUtils.isNotBlank(appSecret) && appSecret.length() < 16) {
                appSecret = appSecret + appSecret;
            }
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();

            byte[] dataBytes = content.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }

            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keySpec = new SecretKeySpec(appSecret.getBytes(), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(appSecret.getBytes());

            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            byte[] encrypted = cipher.doFinal(plaintext);

            return new sun.misc.BASE64Encoder().encode(encrypted);
        } catch (Exception e) {
            log.error("AESEncode error ", e);
            throw e;
        }
    }
}
