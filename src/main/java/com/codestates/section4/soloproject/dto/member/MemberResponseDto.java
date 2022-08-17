package com.codestates.section4.soloproject.dto.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberResponseDto {

    private String name;
    private String companyName;
    private String sex;
    private String nickname;
    private CompanyTypeDto companyType;
    private CompanyLocationDto companyLocation;

}
