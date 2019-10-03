package com.offcn.feign.mapper;

import com.offcn.feign.enty.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
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
