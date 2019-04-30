package com.ia.dao;

import com.ia.dto.UserDTO;
import com.ia.models.Role;
import com.ia.models.User;

import java.util.List;

public interface UserDao {

    public void addUser(User user);
    public List<User> listUsers(int user_id);
    public User getUserById(int id);
    public void removeUser(int id);
    public void addRole(Role r);
    public Role getRoleById(int id);
}
