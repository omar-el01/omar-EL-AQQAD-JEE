package com.example.users_roles.Service;

import com.example.users_roles.entities.Role;
import com.example.users_roles.entities.User;

public interface UserService {

    User addNewUser(User user);
    Role addNewRole(Role role);

    User findUserByUserName(String userName);

    void addRoleToUser(String userName,String roleName);
    User authenticate(String username,String password);
}
