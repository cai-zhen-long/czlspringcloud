package com.offcn.eurekaclient.configuration;

/**
 * Created by Administrator on 2019/9/26.
 */
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;

/**
 * dao层接口扫描
 * @author Administrator
 * @date 2019/9/26 0026 16:52
 * @description
 */
@SpringBootConfiguration
//保证在DeptMybatisConfiguration实例化之后再实例化该类
@AutoConfigureAfter(MybatisConfigBean.class)
public class MapperScannerBean {
    @Bean
    // mapper接口的扫描器
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.offcn.eurekaclient.mapper");
        return mapperScannerConfigurer;
    }
}
