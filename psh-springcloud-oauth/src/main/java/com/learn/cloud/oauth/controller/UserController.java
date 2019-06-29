package com.learn.cloud.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by peiyue.xing on 2019/6/29 14:50
 *
 * @version: 1.0
 */
@RestController
@RequestMapping("/users")
public class UserController {
    //暴露Remote Token Services接口
    //如果其它服务需要验证Token，则需要远程调用授权服务暴露的验证Token的API接口
    @GetMapping("/current")
    public Principal getUser(Principal principal) {
        return principal;
    }
}
