package com.bairuitech.anychat; // 不能修改包的名称

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class AnyChatSign {
    // 对应用接入信息使用私钥进行签名
    public static native int RsaSign(
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
            
            if (os.indexOf("win") >= 0) {
                uri = AnyChatSign.class.getResource("/anychatsign.dll").toURI();                
            } else {
                uri = AnyChatSign.class.getResource("/libanychatsign.so").toURI();  
            }


            String realPath = new File(uri).getAbsolutePath();
            System.load(realPath);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

}
