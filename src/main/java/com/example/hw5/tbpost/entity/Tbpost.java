package com.example.hw5.tbpost.entity;

import com.example.hw5.tblike.entity.Tblike;
import com.example.hw5.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Tbpost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "tbpost", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tblike> tblikes = new ArrayList<>();
    public static Tbpost from(String title, String content, User user){
        return new Tbpost(null, title, content, user, new ArrayList<>());
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
