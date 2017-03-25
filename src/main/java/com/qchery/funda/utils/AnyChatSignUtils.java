package com.qchery.funda.utils;

import com.qchery.funda.entity.AnyChatOutParam;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class AnyChatSignUtils {
    // 对应用接入信息使用私钥进行签名
    public static native int rsaSign(
            int userid,
            String struserid,
            String appid,
            String privatekey,
            AnyChatOutParam outParam);

    // 对应用接入信息签名使用公钥进行验证
    public static native int RsaVerify(
            int userid,
            String struserid,
            String appid,
            String sigstr,
            int timestamp,
            String publickey);

    static {
        System.out.println("java.library.path is " + System.getProperty("java.library.path"));
        URI uri;
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                uri = AnyChatSignUtils.class.getResource("/anychatsign.dll").toURI();
            } else {
                uri = AnyChatSignUtils.class.getResource("/libanychatsign.so").toURI();
            }

            String realPath = new File(uri).getAbsolutePath();
            System.load(realPath);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

}
