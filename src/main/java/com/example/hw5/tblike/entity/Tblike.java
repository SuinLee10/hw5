package com.example.hw5.tblike.entity;

import com.example.hw5.tbpost.entity.Tbpost;
import com.example.hw5.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tblike")
public class Tblike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Tbpost tbpost;

    private boolean liked;

    public Tblike(User user, Tbpost tbpost){
        this.user = user;
        this.tbpost = tbpost;
        this.liked = true;
    }

    public void toggleLike(){
        this.liked = !this.liked;
    }
//    public void setTbpost(Tbpost tbpost){
//        this.tbpost = tbpost;
//    }

}
