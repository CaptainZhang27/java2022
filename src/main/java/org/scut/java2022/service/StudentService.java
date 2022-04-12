package org.scut.java2022.service;


import org.scut.java2022.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> queryStudent(Student student);

    int addOneStudent(Student student);

    int batchAddStudent(List<Student> studentList);

    int deleteStudentByStuNo(Student student);

    int updateStudentByStuNo(Student student);
}
