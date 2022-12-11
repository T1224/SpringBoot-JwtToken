package it.com.service;

import it.com.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> findAll();
    public List<User> login(User user);
}
