package com.learn.cloud.crawler.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.learn.cloud.crawler.dao.PhoneRepository;
import com.learn.cloud.crawler.entity.Phone;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class PhoneController {
    private static final Log log = LogFactory.get();
    @Autowired
    private PhoneRepository phoneRepository;

    @PostMapping("/phone")
    public Object save() {
        Document document = null;
        String url = "http://so.qqdna.com/";
        try {
            document = Jsoup.connect(url).timeout(60 * 1000).ignoreContentType(true).maxBodySize(10 * 1024 * 1024).get();
            Elements elements = document.select(".all>ul");
            this.parse(elements, url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void parse(Elements elements, String url) {
        if (ObjectUtil.isNotNull(elements)) {
            List<Map<Object, Object>> mapList = new ArrayList<>();
            elements.forEach(t -> {
                String provice = t.selectFirst("li>span>a>b").text();//获取省
                Elements lis = t.select("li>a");//获取所有市
                List<Map<Object, Object>> maps = lis.stream().map(m -> MapUtil.builder()
                        .put("href", url + m.attr("href"))
                        .put("name", provice + m.text()).build())
                        .collect(Collectors.toList());
                mapList.addAll(maps);
            });

//            mapList.forEach(t -> {
//                log.info(JSONUtil.parse(t).toString());
//            });
            parseMap(mapList);
        }

    }

    private void parseMap(List<Map<Object, Object>> mapList) {

        mapList.forEach(p -> {
            String url = Convert.toStr(p.get("href"));
            Document document;
            try {
                document = Jsoup.connect(url).timeout(60 * 1000).ignoreContentType(true).maxBodySize(10 * 1024 * 1024).get();
                Elements elements = document.select(".all>ul");//获取所有的ul
                phone(elements, p.get("name"));
            } catch (Exception e) {
                log.error(e);
            }
        });
    }

    private void phone(Elements elements, Object name) {
        List<Phone> list = new ArrayList<>();
        elements.forEach(t -> {
            //获取此元素的同级上一个元素
            Element element = t.previousElementSibling();
            //获取联通 电信 移动
            String content = element.select(".num_bg").text();

            //获取ul下的电话号码
            Elements lis = t.select("li>a");
            List<Phone> ps = lis.stream().map(p->{
                Phone phone = new Phone();
                phone.setType(Convert.toInt(getType(content)));
                phone.setProvice(Convert.toStr(name));
                phone.setPhone(p.text());
                return phone;
            }).collect(Collectors.toList());
            list.addAll(ps);
        });
        phoneRepository.saveAll(list);
    }

    //1 电信 2 联通 3 移动
    private String getType(String content) {
        if (content.contains("联通")) {
            return "2";
        }
        if (content.contains("电信")) {
            return "1";
        }
        if (content.contains("移动")) {
            return "3";
        }
        return "";
    }
}
