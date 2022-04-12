package org.scut.java2022.controller;

import org.scut.java2022.pojo.Student;
import org.scut.java2022.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/query")
    public List<Student> query(Student student){
        return studentService.queryStudent(student);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(Student student){
        if(studentService.deleteStudentByStuNo(student)>0)
            return "Delete successfully.";
        else
            return "Fail to delete.";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(Student student){
        if(studentService.updateStudentByStuNo(student)>0)
            return "Update successfully.";
        else
            return "Fail to update";
    }

    @RequestMapping(value = "/addOne",method = RequestMethod.POST)
    public String addOne(Student student){
        if(studentService.addOneStudent(student)>0)
            return "Add successfully.";
        else
            return "Fail to add";
    }

    @RequestMapping(value = "batchAdd",method = RequestMethod.POST)
    public String batchAdd(List<Student> studentList){
        if(studentService.batchAddStudent(studentList)>0)
            return "Add successfully.";
        else
            return "Fail to add";
    }
}
