package org.scut.java2022.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.scut.java2022.mapper.StudentMapper;
import org.scut.java2022.pojo.Student;
import org.scut.java2022.service.StudentService;
import java.util.List;

@Service("studentService")
public class StudentServiceImp implements StudentService{
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> queryStudent(Student student) {
        return studentMapper.selectStudent(student);
    }

    @Override
    public int addOneStudent(Student student) {
        return studentMapper.insertOneStudent(student);
    }

    @Override
    public int batchAddStudent(List<Student> studentList) {
        return studentMapper.insertBatchStudent(studentList);
    }

    @Override
    public int deleteStudentByStuNo(Student student) {
        return studentMapper.deleteStudentByStuNo(student);
    }

    @Override
    public int updateStudentByStuNo(Student student) {
        return studentMapper.updateStudentByStuNo(student);
    }
}
