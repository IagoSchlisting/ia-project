package com.ia.service;

import com.ia.dto.UserDTO;
import com.ia.models.Role;
import com.ia.models.User;

import java.util.List;

public interface UserService {

    public void addUser(UserDTO user);
    public List<User> listUsers(int user_id);
    public User getUserById(int id);
    public void removeUser(int id);

    public void addRole(Role role);
    public Role getRoleById(int id);

}
