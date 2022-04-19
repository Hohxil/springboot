package com.edu.hello.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


/**
 * 初始化Druid连接池
 */
@ConfigurationProperties("spring.datasource.druid")  //指定前缀
@Component  //也可以使用@Configuration，@Configuration包含了@Component
@Setter  //Lombok的注解。流程是调用空参构造器创建对象，再调用setter方法注入属性值，也可以使用@Data
public class DruidConfig {
    //属性名要与springboot配置文件中属性名一致
    private String url;
    private String driverClassName;
    private String username;
    private String password;
    private int initialSize;
    private int maxActive;
    private int minIdle;
    private int maxWait;
    // private boolean poolPreparedStatements;
    private int maxOpenPreparedStatements;

    @Bean  //放到Spring容器中
    // @Primary  //声明为主数据源，如果配置了多个数据源，未显式指定使用哪个数据源时，自动使用主数据源
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(url);
        datasource.setDriverClassName(driverClassName);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setInitialSize(initialSize);
        datasource.setMaxActive(maxActive);
        datasource.setMinIdle(minIdle);
        datasource.setMaxWait(maxWait);
        // datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);

        return datasource;
    }

}

