package com.offcn.eurekaclient.Controller;

import com.offcn.eurekaclient.Service.StudentService;
import com.offcn.eurekaclient.enty.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2019/10/3.
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/queryAll")
    public List<Student> queryAll(){
        return  studentService.queryAll();
    }
    @GetMapping("/queryById/{id}")
    public Student queryById(@PathVariable("id") int id){
        return studentService.queryById(id);
    }
    @PostMapping("/save")
    public void save(@RequestBody Student student){
        studentService.save(student);
    }
    @PutMapping("update")
    public void update(@RequestBody Student student){
        studentService.update(student);
    }
    @DeleteMapping("/delete/{id}")
    public void  delete(@PathVariable("id") int id){
        studentService.delete(id);
    }

    @GetMapping("/index")
    public String index(){
        return port;
    }
}
