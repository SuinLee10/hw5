package com.example.hw5.tblike.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TblikeResponse {
    private Long tbpostId;
    private Long userId;
    private boolean liked;
    private int totalLikes;
}
