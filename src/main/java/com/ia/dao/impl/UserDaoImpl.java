package com.ia.dao.impl;

import com.ia.dao.UserDao;
import com.ia.dto.UserDTO;
import com.ia.models.Role;
import com.ia.models.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Override
    @Transactional
    public void addUser(User user){
         this.getHibernateTemplate().save(user);
    }
    @Override
    public List<User> listUsers(int user_id){
        return (List<User>) getHibernateTemplate().find("from com.ia.models.User where not USER_ID = "+ user_id);

    }
    @Override
    public User getUserById(int id){
        User user = getHibernateTemplate().get(User.class, id);
        return user;
    }

    @Override
    @Transactional
    public void removeUser(int id){
        getHibernateTemplate().delete(this.getUserById(id));
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        getHibernateTemplate().save(role);
    }

    @Override
    public Role getRoleById(int id) {
        Role role = getHibernateTemplate().get(Role.class, id);
        return role;
    }
}
