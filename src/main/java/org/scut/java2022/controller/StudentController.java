package org.scut.java2022.controller;

import lombok.extern.slf4j.Slf4j;
import org.scut.java2022.pojo.Student;
import org.scut.java2022.service.StudentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public Map<String,Object> queryGet(Student student){
        log.info("query student info: {}", student);
        return studentService.queryStudent(student);
    }

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public Map<String,Object> queryPost(@RequestBody Student student){
        log.info("query student info: {}", student);
        return studentService.queryStudent(student);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> delete(@RequestBody Student student){
        log.info("delete student info: {}", student);
        return studentService.deleteStudentByStuNo(student);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map<String,Object> update(@RequestBody Student student){
        log.info("update student info: {}", student);
        return studentService.updateStudentByStuNo(student);
    }

    @RequestMapping(value = "/addOne",method = RequestMethod.POST)
    public Map<String,Object> addOne(@RequestBody Student student){
        log.info("add student info: {}", student);
        return studentService.addOneStudent(student);
    }

    @RequestMapping(value = "batchAdd",method = RequestMethod.POST)
    public Map<String,Object> batchAdd(@RequestBody List<Student> studentList){
        log.info("list info: {}", studentList);
        return studentService.batchAddStudent(studentList);
    }
}
