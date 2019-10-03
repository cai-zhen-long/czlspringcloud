package com.offcn.eurekaclient.Service.impl;

import com.offcn.eurekaclient.Service.StudentService;
import com.offcn.eurekaclient.enty.Student;
import com.offcn.eurekaclient.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/10/3.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> queryAll() {
        return studentMapper.queryAll();
    }

    @Override
    public Student queryById(int id) {
        return studentMapper.queryById(id);
    }

    @Override
    public void save(Student student) {
        studentMapper.save(student);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void delete(int id) {
        studentMapper.delete(id);
    }
}
