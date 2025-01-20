package com.example.hw5.tbpost.service;

import com.example.hw5.tblike.dto.TblikeResponse;
import com.example.hw5.tblike.repository.TblikeRepository;
import com.example.hw5.tblike.service.TblikeService;
import com.example.hw5.tbpost.dto.TbpostRequest;
import com.example.hw5.tbpost.dto.TbpostResponse;
import com.example.hw5.tbpost.entity.Tbpost;
import com.example.hw5.tbpost.repository.TbpostRepository;
import com.example.hw5.user.entity.User;
import com.example.hw5.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TbpostService {
    private final UserRepository userRepository;
    private final TbpostRepository tbpostRepository;
    private final TblikeService tblikeService;
    private final TblikeRepository tblikeRepository;

    //새로운 게시글 작성 시 작성자 선택
    public void createTbpostByUserId(Long userId, TbpostRequest.TbpostCreateRequest req){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("찾으시는 User 정보: " + userId + "가 존재하지 않습니다."));
        Tbpost tbpost = Tbpost.from(req.getTitle(), req.getContent(), user);
        tbpostRepository.save(tbpost);
    }

    //작성자별 게시글 목록 조회
    public List<TbpostResponse.TbpostReadResponse> readTbpostByUSer(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("찾으시는 User 정보: " + userId + "가 존재하지 않습니다."));

        List<Long> likedPostIds = tblikeRepository.findlikedPostIdsByUserId(userId);
        return tbpostRepository.findAllByUser(user).stream()
                .map(tbpost -> {
                    int likeCount = tblikeRepository.countByTbpost(tbpost); // 각 게시글의 좋아요 개수
                    boolean likedByCurrentUser = likedPostIds.contains(tbpost.getId()); // 현재 사용자가 좋아요 눌렀는지 확인
                    return new TbpostResponse.TbpostReadResponse(
                            tbpost.getId(),
                            tbpost.getTitle(),
                            tbpost.getContent(),
                            likeCount,
                            likedByCurrentUser
                    );
                })
                .collect(Collectors.toList());
    }

    //게시글 수정
    public TbpostResponse.TbpostReadResponse update(Long tbpostId, TbpostRequest.TbpostCreateRequest req){
        Optional<Tbpost> b = tbpostRepository.findById(tbpostId);
        Tbpost tbpost = b.get();
        tbpost.update(req.getTitle(), req.getContent());
        tbpostRepository.save(tbpost);

        int likeCount = tblikeRepository.countByTbpost(tbpost);
        boolean likedByCurrentUser = tblikeRepository.existsByUserAndTbpost(tbpost.getUser(), tbpost);

        return new TbpostResponse.TbpostReadResponse(tbpost.getId(), tbpost.getTitle(), tbpost.getContent(), likeCount, likedByCurrentUser);
    }

    //좋아요 토글
    public TblikeResponse toggleLike(Long userId, Long tbpostId){
        return tblikeService.toggleLike(userId, tbpostId);
    }
    //게시글 삭제
    public void delete(Long tbpostId){
        Tbpost tbpost = tbpostRepository.findById(tbpostId).orElseThrow(IllegalAccessError::new);
        tbpostRepository.delete(tbpost);
    }
}
