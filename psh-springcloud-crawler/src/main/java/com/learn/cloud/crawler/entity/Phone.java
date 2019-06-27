package com.learn.cloud.crawler.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 添加JPA注解
 * */
@Entity
@Table(name = "t_phone")
public class Phone implements Serializable {
    @Id
    @GeneratedValue(strategy=  GenerationType.IDENTITY)
    private Long id;
    @Column
    private String phone;
    @Column
    private String provice;
    @Column
    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
