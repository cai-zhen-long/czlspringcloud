package com.offcn.eurekaclient.Service;

import com.offcn.eurekaclient.enty.Student;

import java.util.List;

/**
 * Created by Administrator on 2019/10/3.
 */
public interface StudentService {
    public List<Student> queryAll();
    public Student queryById(int id);
    public void save(Student student);
    public void update(Student student);
    public void  delete(int id);
}
