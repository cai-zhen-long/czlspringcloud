package com.offcn.ribbon.controller;

import com.offcn.ribbon.enty.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Administrator on 2019/10/3.
 */
@RestController
@RequestMapping("/ribbon")
public class RibbonHandler {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("queryAll")
    public List<Student> queryAll(){
        return  restTemplate.getForObject("http://provider/queryAll",List.class);
    }

    @GetMapping("index")
    public String index(){
        return  restTemplate.getForObject("http://provider/index",String.class);
    }

}
