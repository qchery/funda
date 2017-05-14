package com.qchery.funda.modules.sys.controller;

import com.alibaba.fastjson.JSON;
import com.qchery.funda.Result;
import com.qchery.funda.exception.ResultException;
import com.qchery.funda.modules.sys.entity.User;
import com.qchery.funda.modules.sys.model.UserModel;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * @author Chery
 * @date 2017/5/13 - 上午11:29
 */
public class RestTemplateTest {

    @Test
    public void test() {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        String path = "{module}/user/{method}";
        UserModel request = new UserModel();
        request.setUsername("13632675555");
        request.setPassword("123456");
        request.setAge(10);
        try {
            ParameterizedTypeReference<Result<List<User>>> typeReference = new ParameterizedTypeReference<Result<List<User>>>() {
            };
            UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host("localhost").port("8080").path("{module}/user/{method}").build();
            ResponseEntity<Result<List<User>>> responseEntity = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.POST,
                    new HttpEntity<>(request), typeReference, "sys", "list");
            Object listBody = responseEntity.getBody().getData();
            System.out.println(listBody.getClass());
            if (listBody instanceof List) {
                List list = (List) listBody;
                if (list.size() > 0) {
                    System.out.println(list.get(0).getClass());
                }
            }
            System.out.println(JSON.toJSONString(listBody));

            String url = "http://localhost:8080/" + path;
            ResponseEntity<Result> userResponseEntity = restTemplate.postForEntity(url, request, Result.class, "sys", "login");
            Object loginBody = userResponseEntity.getBody().getData();
            System.out.println(loginBody.getClass());
            System.out.println(JSON.toJSONString(loginBody));
        } catch (ResultException e) {
            e.printStackTrace();
        }
    }

}
