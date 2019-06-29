package com.learn.cloud.oauth.entity;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by peiyue.xing on 2019/6/29 11:36
 *
 * @version: 1.0
 */
@Entity
public class UserRole implements Serializable {
    private Integer userId;
    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
