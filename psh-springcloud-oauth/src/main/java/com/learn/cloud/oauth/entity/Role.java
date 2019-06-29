package com.learn.cloud.oauth.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by peiyue.xing on 2019/6/29 11:35
 *
 * @version: 1.0
 */
@Entity
public class Role implements GrantedAuthority {
    private Integer id;
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
