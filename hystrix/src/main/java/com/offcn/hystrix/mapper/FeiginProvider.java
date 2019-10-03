package com.offcn.hystrix.mapper;


import com.offcn.hystrix.enty.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Administrator on 2019/10/3.
 */
@FeignClient(value = "provider",fallback = FeginProviderError.class)
public interface FeiginProvider {
    @GetMapping("/queryAll")
    public List<Student> queryAll();
    @GetMapping("/index")
    public String index();
}
