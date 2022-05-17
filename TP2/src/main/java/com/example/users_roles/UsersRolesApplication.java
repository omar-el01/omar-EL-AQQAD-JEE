package com.example.users_roles;

import com.example.users_roles.Service.UserService;
import com.example.users_roles.Service.UserServiceImpl;
import com.example.users_roles.entities.Role;
import com.example.users_roles.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.users_roles.repositories.RoleRepository;

import java.util.stream.Stream;

@SpringBootApplication
public class UsersRolesApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersRolesApplication.class, args);
    }
    @Bean
    CommandLineRunner start(UserService userService, RoleRepository roleRepository){
        return args -> {
            //adding user1
            User user1= new User();
            user1.setUsername("user");
            user1.setPassword("11111");
            if (userService == null)return;
            userService.addNewUser(user1);

            //adding user2 that has ADMIN role
            User user2= new User();
            user2.setUsername("admin");
            user2.setPassword("00000");
            userService.addNewUser(user2);

            //create roles
            Stream.of("USER","ADMIN").forEach(name->{
                Role role1=new Role();
                role1.setRoleName(name);
                role1.setDesc(name+"_desc");
                userService.addNewRole(role1);
            });

            //add roles to users
            try{
                userService.addRoleToUser("admin","ADMIN");
            }catch(Exception e){
                e.printStackTrace();
            }
            userService.addRoleToUser("admin","USER");
            userService.addRoleToUser("user","USER");

            try{
                User user= userService.authenticate("admin","00000");
                System.out.println("userId:"+user.getId());
                System.out.println("username:"+user.getUsername());
                System.out.println("roles=>");
                user.getRoles().forEach(r->{
                    System.out.println("role=>"+r.getRoleName());
                });
            }catch(Exception e){
                e.printStackTrace();
            }

        };
    }

}
