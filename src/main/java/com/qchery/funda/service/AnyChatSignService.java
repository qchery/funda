package com.qchery.funda.service;

import com.qchery.funda.entity.AnyChatOutParam;
import com.qchery.funda.entity.AnyChatSign;
import com.qchery.funda.properties.AnyChatProperties;
import com.qchery.funda.utils.AnyChatSignUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Chery
 * @date 2017/3/25 - 下午9:52
 */
@Service
public class AnyChatSignService {

    private Logger logger = LoggerFactory.getLogger(AnyChatSignService.class);

    private String PRIVATE_KEY = "";

    private String PUBLIC_KEY  = "";

    @Autowired
    private AnyChatProperties anyChatProperties;

    @PostConstruct
    public void initKey() {
        try {
            InputStream publicKey = new FileInputStream(anyChatProperties.getPrivateKeyPath());
            InputStream privateKey = new FileInputStream(anyChatProperties.getPublicKeyPath());
            PRIVATE_KEY = loadKey(privateKey);
            PUBLIC_KEY = loadKey(publicKey);
        } catch (Exception e) {
            logger.error("密钥文件：{} 或 {} 加载失败", anyChatProperties.getPrivateKeyPath(),
                    anyChatProperties.getPublicKeyPath(), e);
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

    public AnyChatSign getRsaSign(String userName, String appid) {
        AnyChatSign result = new AnyChatSign();
        AnyChatOutParam anyChatOutParam = new AnyChatOutParam();

        int errorcode = AnyChatSignUtils.rsaSign(-1, userName, appid, PRIVATE_KEY, anyChatOutParam);
        if (errorcode == 0) {
            int timestamp = anyChatOutParam.getiValue();
            String sigStr = anyChatOutParam.getSzValue();
            result.setErrorCode(errorcode);
            result.setTimestamp(timestamp);
            result.setSigStr(sigStr);
            result.setAppId(appid);
        }

        return result;
    }

    public int verifySign(String userName, String sigstr, int timestamp, String appid) {
        return AnyChatSignUtils.RsaVerify(-1, userName, appid, sigstr, timestamp, PUBLIC_KEY);
    }

}
