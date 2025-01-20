package com.example.hw5.user.entity;

import com.example.hw5.tblike.entity.Tblike;
import com.example.hw5.tbpost.entity.Tbpost;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tbpost> tbpost;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tblike> tblikes = new ArrayList<>();


    public void update(String name, String email){
        this.name = name;
        this.email = email;
    }
}
