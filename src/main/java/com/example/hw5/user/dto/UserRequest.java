package com.example.hw5.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class UserRequest {

        @Getter
        @Builder
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @NoArgsConstructor @AllArgsConstructor
        public static class UserCreateRequest{
            private String name;
            private String email;
    }
}
