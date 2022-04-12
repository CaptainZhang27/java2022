package org.scut.java2022.service;

import org.junit.jupiter.api.Test;
import org.scut.java2022.Java2022ApplicationTests;
import org.scut.java2022.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceTest extends Java2022ApplicationTests {
    @Autowired
    private StudentService studentService;

    @Test
    public void selectAllStudentTest(){
    }
}
