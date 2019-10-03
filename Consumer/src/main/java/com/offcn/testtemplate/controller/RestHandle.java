package com.offcn.testtemplate.controller;



import com.offcn.testtemplate.enty.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.Null;
import java.util.List;

/**
 * Created by Administrator on 2019/10/3.
 */
@RestController
@RequestMapping("/consumer")
public class RestHandle {
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/queryAll")
    public List<Student> queryAll(){
        return restTemplate.getForObject("http://localhost:8010/queryAll",List.class);
    }

    @GetMapping("/queryById/{id}")
    public Student queryById(@PathVariable("id") int id){
       return restTemplate.getForObject("http://localhost:8010/queryById/{id}",Student.class,id);
    }
    @PostMapping("/save")
    public void save(@RequestBody Student student){
        restTemplate.postForObject("http://localhost:8010/save",student, Null.class);
    }
    @PutMapping("update")
    public void update(@RequestBody Student student){
       restTemplate.put("http://localhost:8010/update",student);
    }
    @DeleteMapping("/delete/{id}")
    public void  delete(@PathVariable("id") int id){
        restTemplate.delete("http://localhost:8010/delete/{id}",id);
    }
}
