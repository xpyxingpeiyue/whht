package com.learn.cloud.pshprovider.dao;


import com.learn.cloud.pshprovider.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * dao层直接操作数据库
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
