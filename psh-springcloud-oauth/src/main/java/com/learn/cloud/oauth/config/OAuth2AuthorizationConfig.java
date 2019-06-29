package com.learn.cloud.oauth.config;

import com.learn.cloud.oauth.service.UserServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;


/**
 * Created by peiyue.xing on 2019/6/29 11:52
 *
 * @version: 1.0
 */
@Configuration
@EnableAuthorizationServer//开启授权服务的功能
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {


    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Autowired
    private UserServiceDetail userServiceDetail;

    public JdbcTokenStore jdbcTokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //配置客户端的基本信息
        clients.inMemory()//将客户端信息存储在内存中
                .withClient("browser")//创建了一个client名为browser的客户端
                .authorizedGrantTypes("refresh_token", "password")//配置验证类型
                .scopes("ui")//配置客户端域为“ui”
                .and()
                .withClient("service-hi")
                .secret("123456")
                .authorizedGrantTypes("client_credentials", "refresh_token", "password")
                .scopes("server");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(jdbcTokenStore())//Token的存储方式为内存
                .authenticationManager(authenticationManager) //WebSecurity配置好的
                .userDetailsService(userServiceDetail);//读取用户的验证信息
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //配置获取Token的策略
        security.tokenKeyAccess("permitAll()")//对获取Token的请求不再拦截
                .checkTokenAccess("isAuthenticated()");//验证获取Token的验证信息
    }
}
