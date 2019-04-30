package com.ia.service.impl;

import com.ia.dao.UserDao;
import com.ia.dto.UserDTO;
import com.ia.models.Role;
import com.ia.models.User;
import com.ia.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public void addUser(UserDTO user){
        if(user.getUsername().isEmpty() || user.getPassword().isEmpty()){
            throw new IllegalArgumentException("Username or password cannot be empty!");
        }
        if(!new String(user.getPassword()).equals(user.getConfirmPassword())){
            throw new IllegalArgumentException("Passwords doesn't match!");
        }
        user.setEnabled(true);
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        User new_user = convertDTO(user);
        this.userDao.addUser(new_user);
    }
    @Override
    public List<User> listUsers(int user_id){
        return this.userDao.listUsers(user_id);
    }
    @Override
    public User getUserById(int id){
        return this.userDao.getUserById(id);
    }
    @Override
    public void removeUser(int id){
        this.userDao.removeUser(id);
    }

    @Override
    public void addRole(Role role) {
        this.userDao.addRole(role);
    }

    @Override
    public Role getRoleById(int id) { return this.userDao.getRoleById(id); }

    private User convertDTO(UserDTO user){
        User new_user = new User();
        new_user.setUsername(user.getUsername());
        new_user.setPassword(user.getPassword());
        new_user.setRoles(user.getRoles());
        new_user.setEnabled(user.getEnabled());
        return new_user;
    }

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
