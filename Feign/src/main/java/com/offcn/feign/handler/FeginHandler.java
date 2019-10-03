package com.offcn.feign.handler;

import com.offcn.feign.enty.Student;
import com.offcn.feign.mapper.FeiginProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/10/3.
 */
@RestController
@RequestMapping("/fegin")
public class FeginHandler {
    @Autowired
    private FeiginProvider feiginProvider;

    @GetMapping("queryAll")
    public List<Student> queryAll(){
        return feiginProvider.queryAll();
    }

    @GetMapping("index")
    public String index(){
        return feiginProvider.index();
    }
}
