package com.offcn.hystrix.mapper;

import com.offcn.hystrix.enty.Student;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2019/10/3.
 */
@Component
public class FeginProviderError implements FeiginProvider{
    @Override
    public List<Student> queryAll() {
        return null;
    }

    @Override
    public String index() {
        return "服务维护中";
    }
}
