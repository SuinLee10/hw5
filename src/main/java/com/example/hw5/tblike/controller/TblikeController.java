package com.example.hw5.tblike.controller;

import com.example.hw5.tblike.service.TblikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class TblikeController {
    private final TblikeService tblikeService;

    @PostMapping("/{userId}/{tbpostId}")
    public void toggleLike(@PathVariable Long userId, @PathVariable Long tbpostId){
        tblikeService.toggleLike(userId, tbpostId);
    }
}
