package com.codestates.section4.soloproject.service;

import com.codestates.section4.soloproject.dto.member.MemberPostDto;
import com.codestates.section4.soloproject.dto.member.MemberResponseDto;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceStub implements MemberService {

    @Override
    public MemberResponseDto postMember(MemberPostDto postDto) {
        return null;
    }
}
