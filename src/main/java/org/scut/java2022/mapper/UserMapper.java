package org.scut.java2022.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.scut.java2022.pojo.User;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE user_name=#{userName}")
    User selectPswByUname(User user);
}
