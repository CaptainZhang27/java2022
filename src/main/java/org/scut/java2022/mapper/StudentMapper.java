package org.scut.java2022.mapper;


import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import org.scut.java2022.pojo.Student;

import java.util.List;

@Component
@Mapper
public interface StudentMapper {
    @Select({"<script>" ,
            "SELECT * FROM student " ,
            "   <where>",
            "       <if test='studentNumber != null'> student_number=#{studentNumber}</if>",
            "       <if test='name != null'>AND name=#{name}</if>",
            "       <if test='gender != null'>AND gender=#{gender}</if>",
            "       <if test='grade != null'>AND grade=#{grade}</if>",
            "       <if test='cls != null'>AND cls=#{cls}</if>",
            "       <if test='mobileNo != null'>AND mobile_no=#{mobileNo}</if>",
            "   </where>",
            "</script>"})
    List<Student> selectStudent(Student student);

    @Insert("INSERT INTO student(student_number,name,gender,grade,cls,mobile_no)"+
            " VALUES(#{studentNumber},#{name},#{gender},#{grade},#{cls},#{mobileNo})")
    int insertOneStudent(Student student);

    @Insert({"<script>",
            "INSERT INTO student(student_number,name,gender,grade,cls,mobile_no) VALUES",
            "<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\">",
            "(#{item.studentNumber},#{item.name},#{item.gender},#{item.grade},#{item.cls},#{item.mobileNo})",
            "</foreach>",
            "</script>"})
    int insertBatchStudent(List<Student> studentList);

    @Delete({"<script>",
            "DELETE FROM student",
            "   <where>",
            "       <if test='studentNumber != null'> student_number=#{studentNumber}</if>",
            "       <if test='name != null'>AND name=#{name}</if>",
            "       <if test='gender != null'>AND gender=#{gender}</if>",
            "       <if test='grade != null'>AND grade=#{grade}</if>",
            "       <if test='cls != null'>AND cls=#{cls}</if>",
            "       <if test='mobileNo != null'>AND mobile_no=#{mobileNo}</if>",
            "   </where>",
            "</script>"})
    int deleteStudentByStuNo(Student student);

    @Update({"<script>" ,
            "UPDATE student " ,
            "   <set>",
            "       <if test='name != null'> name=#{name},</if>",
            "       <if test='gender != null'> gender=#{gender},</if>",
            "       <if test='grade != null'> grade=#{grade},</if>",
            "       <if test='cls != null'> cls=#{cls},</if>",
            "       <if test='mobileNo != null'> mobile_no=#{mobileNo}</if>",
            "   </set>",
            "WHERE student_number=#{studentNumber}",
            "</script>"})
    int updateStudentByStuNo(Student student);
}
