package com.codestates.section4.soloproject.service;

import com.codestates.section4.soloproject.dto.member.MemberPostDto;
import com.codestates.section4.soloproject.dto.member.MemberResponseDto;

public interface MemberService {

    MemberResponseDto postMember(MemberPostDto postDto);
}
