package it.com.service.impl;

import it.com.mapper.UserMapper;
import it.com.pojo.User;
import it.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public List<User> login(User user) {
        return userMapper.login(user.getUsername(),user.getPassword());
    }
}