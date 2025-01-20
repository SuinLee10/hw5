package com.example.hw5.tblike.service;

import com.example.hw5.tblike.dto.TblikeResponse;
import com.example.hw5.tblike.entity.Tblike;
import com.example.hw5.tblike.repository.TblikeRepository;
import com.example.hw5.tbpost.entity.Tbpost;
import com.example.hw5.tbpost.repository.TbpostRepository;
import com.example.hw5.user.entity.User;
import com.example.hw5.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TblikeService {
    private final UserRepository userRepository;
    private final TbpostRepository tbpostRepository;
    private final TblikeRepository tblikeRepository;

    public TblikeResponse toggleLike(Long userId, Long tbpostId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User 정보를 찾을 수 없습니다."));
        Tbpost tbpost = tbpostRepository.findById(tbpostId)
                .orElseThrow(() -> new NoSuchElementException("Post 정보를 찾을 수 없습니다."));

        Optional<Tblike> tblikeOptional = tblikeRepository.findByUserAndTbpost(user, tbpost);
        boolean liked;

        if(tblikeOptional.isPresent()){
            Tblike tblike = tblikeOptional.get();
            tblike.toggleLike();
            tblikeRepository.save(tblike);
            liked = tblike.isLiked();
        }else{
            Tblike newLike = new Tblike(user, tbpost);
            tblikeRepository.save(newLike);
            liked = true;
        }
        int totalLikes = tblikeRepository.countByTbpost(tbpost);

        return TblikeResponse.builder()
                .tbpostId(tbpostId)
                .userId(userId)
                .liked(liked)
                .totalLikes(totalLikes)
                .build();
    }
}
