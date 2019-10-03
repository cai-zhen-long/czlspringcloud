package com.offcn.eurekaclient.mapper;

import com.offcn.eurekaclient.enty.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/10/3.
 */
@Mapper
public interface StudentMapper {

    public List<Student> queryAll();
    public Student queryById(int id);
    public void save(Student student);
    public void update(Student student);
    public void  delete(int id);
}
