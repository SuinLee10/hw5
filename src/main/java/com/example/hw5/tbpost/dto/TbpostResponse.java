package com.example.hw5.tbpost.dto;

import com.example.hw5.tblike.repository.TblikeRepository;
import com.example.hw5.tbpost.entity.Tbpost;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class TbpostResponse {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TbpostReadResponse{
        private Long tbpostId;
        private String title;
        private String content;
        private int likeCount;
        private boolean likedByCurrentUser;

        public static List<TbpostReadResponse> tbpostToDto(List<Tbpost> tbposts, List<Long> likedPostId, TblikeRepository tblikeRepository){
            List<TbpostReadResponse> ret = new ArrayList<>();
            for(Tbpost tbpost : tbposts){
                int likeCount = tblikeRepository.countByTbpost(tbpost);
                boolean likedByCurrentUser = likedPostId.contains(tbpost.getId());
                TbpostReadResponse b =
                        new TbpostReadResponse(tbpost.getId(), tbpost.getTitle(), tbpost.getContent(), likeCount, likedByCurrentUser);
                ret.add(b);
            }
            return ret;
        }
    }




}
