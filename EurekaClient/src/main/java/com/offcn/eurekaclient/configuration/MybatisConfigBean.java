package com.offcn.eurekaclient.configuration;

/**
 * Created by Administrator on 2019/9/26.
 */
import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * 配置类
 *
 * @author Administrator
 * @date 2019/9/26 0026 16:21
 * @description
 */
@SpringBootConfiguration
@PropertySource(value = {"classpath:db.properties"}, ignoreResourceNotFound = true)
public class MybatisConfigBean {
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.driverClassName}")
    private String driverClass;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 创建数据源
     *
     * @return
     */
    @Bean(initMethod="init",destroyMethod="close")
    public DruidDataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        //设置数据库连接属性
        dataSource.setUrl(jdbcUrl);
        dataSource.setDriverClassName(driverClass);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        //数据库连接池属性
        //配置初始化大小、最小、最大
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(20);
        //连接泄漏监测
        dataSource.setRemoveAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(30);
        //配置获取连接等待超时的时间
        dataSource.setMaxWait(20000);
        //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setTimeBetweenEvictionRunsMillis(20000);
        //防止过期
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(true);
        return dataSource;
    }

    /**
     * 创建SqlSessionFactoryBean
     * @return
     */
    @Bean
    @ConditionalOnMissingBean//在ioc容器中不存在SqlSessionFactoryBean对象时，创建该对象
    public SqlSessionFactoryBean sqlSessionFactoryBean(DruidDataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 加载mybatis配置文件
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //加载mybatis的配置文件
        Resource mybatisConfigXml = resolver.getResource("classpath:mybatis/mybatisConfig.xml");
        //
        sqlSessionFactoryBean.setConfigLocation(mybatisConfigXml);
        //
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*Mapper.xml"));
        // 设置别名包
        sqlSessionFactoryBean.setTypeAliasesPackage("com.offcn.eurekaclient.enty");
        return sqlSessionFactoryBean;
    }



    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}