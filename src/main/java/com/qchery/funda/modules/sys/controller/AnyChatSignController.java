package com.qchery.funda.modules.sys.controller;

import com.bairuitech.anychat.AnyChatSignUtils;
import com.bairuitech.anychat.SignResult;
import com.qchery.funda.Result;
import com.qchery.funda.modules.sys.model.AnyChatSignModel;
import com.qchery.funda.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chery
 * @date 2017/3/25 - 下午9:44
 */
@RestController
@RequestMapping("/sys/anychat")
public class AnyChatSignController {

    @Autowired
    private AnyChatSignUtils anyChatSignUtils;

    @PostMapping("sign")
    public Result sign(@RequestBody AnyChatSignModel signModel) {
        SignResult rsaSign = anyChatSignUtils.getRsaSign(signModel.getUserName(), signModel.getAppid());
//        response.addHeader("Access-Control-Allow-Origin", "*");
        return ResultUtils.success(rsaSign);
    }

    @PostMapping("verify")
    public Result verifySign(@RequestBody AnyChatSignModel signModel) {
        int verifySign = anyChatSignUtils.verifySign(signModel.getUserName(),
                signModel.getSigStr(), signModel.getTimestamp(), signModel.getAppid());
        return ResultUtils.success(verifySign);
    }

}
