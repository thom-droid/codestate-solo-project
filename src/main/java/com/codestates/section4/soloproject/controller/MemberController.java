package com.codestates.section4.soloproject.controller;

import com.codestates.section4.soloproject.dto.SingleResponse;
import com.codestates.section4.soloproject.dto.member.MemberPostDto;
import com.codestates.section4.soloproject.dto.member.MemberResponseDto;
import com.codestates.section4.soloproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/member")
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<SingleResponse<MemberResponseDto>> postMember(@RequestBody MemberPostDto postDto) {
        MemberResponseDto responseDto = memberService.postMember(postDto);
        return new ResponseEntity<>(new SingleResponse<>(responseDto), HttpStatus.CREATED);
    }

}
