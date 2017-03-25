package com.qchery.funda.controller;

import com.qchery.funda.Result;
import com.qchery.funda.entity.AnyChatSign;
import com.qchery.funda.model.AnyChatSignModel;
import com.qchery.funda.service.AnyChatSignService;
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
    private AnyChatSignService anyChatSignService;

    @PostMapping("sign")
    public Result sign(@RequestBody AnyChatSignModel signModel) {
        AnyChatSign sign = anyChatSignService.getRsaSign(signModel.getUserName(), signModel.getAppid());
//        response.addHeader("Access-Control-Allow-Origin", "*");
        return ResultUtils.success(sign);
    }

    @PostMapping("verify")
    public Result verifySign(@RequestBody AnyChatSignModel signModel) {
        int verifySign = anyChatSignService.verifySign(signModel.getUserName(),
                signModel.getSigStr(), signModel.getTimestamp(), signModel.getAppid());
        return ResultUtils.success(verifySign);
    }

}
