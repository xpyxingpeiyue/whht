package com.learn.cloud.ribbon.controller;

import com.learn.cloud.ribbon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
        //使用ribbon  直接使用微服务的server-id
        //VIP 虚拟ip
        return restTemplate.getForObject("http://springcloud-provider-user/user/" + id, User.class);
    }
}
