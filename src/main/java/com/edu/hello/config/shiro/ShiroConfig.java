package com.edu.hello.config.shiro;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultSecurityManager defaultSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultSecurityManager);
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/add","anon");
        filterMap.put("/user/update","authc");
        System.out.println("设置验证过滤器");
        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm);
        return manager;

    }
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

}
