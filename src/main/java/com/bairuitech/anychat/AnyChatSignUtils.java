package com.bairuitech.anychat;

import com.qchery.funda.properties.AnyChatProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class AnyChatSignUtils {

    private String PRIVATE_KEY = "";

    private String PUBLIC_KEY  = "";

    private Logger logger = LoggerFactory.getLogger(AnyChatSignUtils.class);

    @Autowired
    private AnyChatProperties anyChatProperties;

    @PostConstruct
    public void init() {
        try {
            InputStream publicKey = new FileInputStream(anyChatProperties.getPublicKeyPath());
            InputStream privateKey = new FileInputStream(anyChatProperties.getPrivateKeyPath());
            PRIVATE_KEY = loadKey(privateKey);
            PUBLIC_KEY = loadKey(publicKey);
        } catch (Exception e) {
            logger.error("密钥加载失败", e);
        }
    }

    private String loadKey(InputStream in) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String readLine;
        StringBuilder sb = new StringBuilder();

        while ((readLine = br.readLine()) != null) {
            sb.append(readLine);
            sb.append('\r');
            sb.append('\n');
        }

        return sb.toString();
    }

    public SignResult getRsaSign(String userName,String appid) {
        SignResult result = new SignResult();
        AnyChatOutParam signResult = new AnyChatOutParam();

        int errorcode = AnyChatSign.RsaSign(-1, userName, appid, PRIVATE_KEY, signResult);
        if (errorcode == 0) {
            int timestamp = signResult.GetIntValue();
            String sigStr = signResult.GetStrValue();
            result.setErrorcode(errorcode);
            result.setTimestamp(timestamp);
            result.setSigStr(sigStr);
            result.setAppId(appid);
        }

        return result;
    }

    public int verifySign(String userName, String sigstr, int timestamp,String appid) {
        return AnyChatSign.RsaVerify(-1, userName, appid, sigstr, timestamp, PUBLIC_KEY);
    }
}
