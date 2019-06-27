package com.learn.cloud.crawler;

import com.learn.cloud.crawler.controller.PhoneController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PhoneControllerTest {
    @Autowired
    private PhoneController phoneController;
    @Test
    public void test(){
        phoneController.save();
    }
}
