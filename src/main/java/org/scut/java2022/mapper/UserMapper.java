package org.scut.java2022.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    @Select("SELECT password FROM user WHERE user_name=#{userName}")
    String selectPswByUname(String userName);
}
