package com.learn.cloud.pshconsumer.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.learn.cloud.pshconsumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MoverController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 这种生产者与消费者之间的调用问题
     * 1  地址很难管理  变化的地址和端口
     * @param id
     * @return
     */
    @GetMapping("/move/{id}")
    public User findById(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://127.0.0.1:8090/user/" + id, User.class);
    }
    @GetMapping("/oauth/redirect")
    public Object oauth(HttpServletRequest request, HttpServletResponse response){
        //获取授权码
        String code = request.getParameter("code");

        HashMap<String,Object> param = new HashMap<>();
        param.put("client_id","b7ffd6602d645fff3782");
        param.put("client_secret","e6390498d10fb66dcef232152c3b9b652e623c67");
        param.put("code",code);
       String json = HttpRequest.post("https://github.com/login/oauth/access_token")
                .header("accept","application/json")
                .form(param)
                .execute()
                .body();
        System.out.println(json);
        JSONObject result = JSONUtil.parseObj(json);
        String token = result.getStr("access_token");
        String type = result.getStr("token_type");

        String user = HttpRequest.get("https://api.github.com/user")
                .header("accept","application/json")
                .header("Authorization","token  "+token)
                .execute()
                .body();
        return user;
    }
}
