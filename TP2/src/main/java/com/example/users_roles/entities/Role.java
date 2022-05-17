package com.example.users_roles.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;

    @Column(name = "description")
    private String desc;

    @ManyToMany(fetch = FetchType.EAGER) // ?
    @JoinTable(name = "users_roles") // association table name
    @ToString.Exclude
    private List<User> users= new ArrayList<>();

}
