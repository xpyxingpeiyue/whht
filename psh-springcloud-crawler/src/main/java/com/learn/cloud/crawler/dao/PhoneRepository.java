package com.learn.cloud.crawler.dao;


import com.learn.cloud.crawler.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * dao层直接操作数据库
 */
@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {

}
