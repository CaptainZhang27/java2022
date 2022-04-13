package org.scut.java2022.service.impl;

import org.springframework.stereotype.Service;

import org.scut.java2022.mapper.StudentMapper;
import org.scut.java2022.pojo.Student;
import org.scut.java2022.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentServiceImp implements StudentService{
    private final StudentMapper studentMapper;

    public StudentServiceImp(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public Map<String,Object> queryStudent(Student student) {
        List<Student> studentList=studentMapper.selectStudent(student);
        Map<String,Object> result=new HashMap<>();
        if(!studentList.isEmpty()){
            result.put("code","1000");
            result.put("data",studentList);
        }
        else{
            result.put("code","3001");
            result.put("msg","学生信息不存在");
        }

        return result;
    }

    @Override
    public Map<String,Object> addOneStudent(Student student) {
        Map<String,Object> result=new HashMap<>();
        if(studentMapper.insertOneStudent(student)>0){
            result.put("code","1000");
            result.put("msg","添加成功");
        }
        else{
            result.put("code","3002");
            result.put("msg","添加失败");
        }

        return result;
    }

    @Override
    public Map<String,Object> batchAddStudent(List<Student> studentList) {
        Map<String,Object> result=new HashMap<>();
        if(studentMapper.insertBatchStudent(studentList)>0){
            result.put("code","1000");
            result.put("msg","添加成功");
        }
        else{
            result.put("code","3002");
            result.put("msg","添加失败");
        }
        return result;
    }

    @Override
    public Map<String,Object> deleteStudentByStuNo(Student student) {
        Map<String,Object> result=new HashMap<>();
        if(studentMapper.deleteStudentByStuNo(student)>0){
            result.put("code","1000");
            result.put("msg","删除成功");
        }
        else{
            result.put("code","3002");
            result.put("msg","删除失败");
        }
        return result;
    }

    @Override
    public Map<String,Object> updateStudentByStuNo(Student student) {
        Map<String,Object> result=new HashMap<>();
        if(studentMapper.updateStudentByStuNo(student)>0){
            result.put("code","1000");
            result.put("msg","修改成功");
        }
        else{
            result.put("code","3002");
            result.put("msg","修改失败");
        }
        return result;
    }
}
