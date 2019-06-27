package com.learn.cloud.pshconsumer.controller;

import com.learn.cloud.pshconsumer.entity.User;
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
        return restTemplate.getForObject("http://127.0.0.1:8090/user/" + id, User.class);
    }
}
