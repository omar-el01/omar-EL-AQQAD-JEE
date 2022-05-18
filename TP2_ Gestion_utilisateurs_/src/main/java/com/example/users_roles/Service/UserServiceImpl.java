package com.example.users_roles.Service;

import com.example.users_roles.entities.Role;
import com.example.users_roles.entities.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.users_roles.repositories.RoleRepository;
import com.example.users_roles.repositories.UserRepository;

import java.util.UUID;


@Service
@Transactional
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public User addNewUser(User user) {
        if (user == null) return null;
        user.setId(UUID.randomUUID().toString());

        return  userRepository.save(user);
    }
    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
    User user=userRepository.findByUsername(userName);
    Role role=roleRepository.findByRoleName(roleName);
    user.getRoles().add(role);
    userRepository.save(user);
    }

    @Override
    public User authenticate(String username, String password) {
        User user=userRepository.findByUsername(username);
        if(user==null)throw new RuntimeException("bad credential!");
        if(password.equals(user.getPassword())){
            return user;
        }
        throw new RuntimeException("bad credential!");
    }
}
