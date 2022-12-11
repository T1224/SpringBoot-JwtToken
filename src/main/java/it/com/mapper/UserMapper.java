package it.com.mapper;

import it.com.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     * @return list集合
     */
    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user where username=#{username} and password=#{password}")
    public List<User> login(@Param("username")String username, @Param("password")String password);
}
