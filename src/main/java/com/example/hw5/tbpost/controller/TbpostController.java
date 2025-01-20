package com.example.hw5.tbpost.controller;

import com.example.hw5.tblike.dto.TblikeResponse;
import com.example.hw5.tblike.service.TblikeService;
import com.example.hw5.tbpost.dto.TbpostRequest;
import com.example.hw5.tbpost.dto.TbpostResponse;
import com.example.hw5.tbpost.entity.Tbpost;
import com.example.hw5.tbpost.service.TbpostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tbpost")
public class TbpostController {
    private final TbpostService tbpostService;
    private final TblikeService tblikeService;

    @PostMapping("/{userId}")
    public void createTbpostByUser(@PathVariable Long userId,
                           @RequestBody TbpostRequest.TbpostCreateRequest req){
        tbpostService.createTbpostByUserId(userId, req);
    }
    @GetMapping("/user/{userId}")
    public List<TbpostResponse.TbpostReadResponse> readTbpostByUser(@PathVariable Long userId){
        return tbpostService.readTbpostByUSer(userId);
    }


    @PatchMapping("/{postId}")
    public TbpostResponse.TbpostReadResponse updateTbpost(@PathVariable Long postId, @RequestBody TbpostRequest.TbpostCreateRequest req){
        return tbpostService.update(postId, req);
    }
    @DeleteMapping("/{tbpostId}")
    public void deleteTbpost(@PathVariable Long tbpostId){
        tbpostService.delete(tbpostId);
    }

    @PostMapping("/{tbpostId}/like/{userId}")
    public TblikeResponse toggleLike(@PathVariable Long tbpostId, @PathVariable Long userId) {
        return tblikeService.toggleLike(userId, tbpostId); // 좋아요 토글 기능 호출
    }
}
