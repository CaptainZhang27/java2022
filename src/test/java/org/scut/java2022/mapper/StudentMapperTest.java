package org.scut.java2022.mapper;

import org.junit.jupiter.api.Test;
import org.scut.java2022.Java2022ApplicationTests;
import org.scut.java2022.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class StudentMapperTest extends Java2022ApplicationTests {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void queryTest(){
        Student student=new Student();
        student.setStudentNumber("201930442247");
        List<Student> studentList=studentMapper.selectStudent(student);
        for (Student stu : studentList){
            System.out.println(stu);
        }
    }

    @Test
    public void insertBatchTest(){
        List<Student> studentList=new LinkedList<Student>();
        for(int i=0;i<2;i++){
            Student student=new Student();
            student.setStudentNumber("2020"+i);
            studentList.add(student);
        }
        System.out.println(studentMapper.insertBatchStudent(studentList));
    }

    @Test
    public void deleteTest(){
        Student student=new Student();
        student.setStudentNumber("20200");
        System.out.println(studentMapper.deleteStudentByStuNo(student));
    }

    @Test
    public void updateTest(){
        Student student=new Student();
        student.setStudentNumber("20201");
        student.setName("张三");
        System.out.println(studentMapper.updateStudentByStuNo(student));
    }
}
