package com.example.competition.config;

import com.example.competition.util.MyRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Chen Anran
 * @date 2021/3/21
 */

@Configuration
public class ShiroConfiguration {
    @Bean
    MyRealm myRealm() {
        return new MyRealm();
    }

    @Bean
    SecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm());
        return manager;
    }

    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager());
//        // 登录页面
//        bean.setLoginUrl("/login");
//        // 登录成功页面
//        bean.setSuccessUrl("/index");
//        bean.setUnauthorizedUrl("/unauthorizedurl");
        // 配置路径拦截规则，需要有序
        // 常用的过滤器：
        // anon：可以直接匿名使用
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/user/login", "anon");
        // 需要登录才能授权
//        map.put("/**", "authc");
        // 需要特定的角色
        map.put("/**", "roles[teacher]");
        // 需要特定的操作许可
//        map.put("/**", "perms[user:create]");
        bean.setFilterChainDefinitionMap(map);
        return bean;
    }
}