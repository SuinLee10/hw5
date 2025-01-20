package com.example.hw5.user.dto;

import com.example.hw5.tbpost.dto.TbpostResponse;
import com.example.hw5.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class UserResponse {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReadUser{
        private String name;
        private String email;
        private List<TbpostResponse.TbpostReadResponse> tbposts;

        public static ReadUser from(User user, List<TbpostResponse.TbpostReadResponse> tbposts){
            return new ReadUser(user.getName(),user.getEmail(), tbposts);
        }
    }
}
