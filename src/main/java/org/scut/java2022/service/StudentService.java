package org.scut.java2022.service;


import org.scut.java2022.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    Map<String,Object> queryStudent(Student student);

    Map<String,Object> addOneStudent(Student student);

    Map<String,Object> batchAddStudent(List<Student> studentList);

    Map<String,Object> deleteStudentByStuNo(Student student);

    Map<String,Object> updateStudentByStuNo(Student student);
}
