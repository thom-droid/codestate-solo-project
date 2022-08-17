package com.codestates.section4.soloproject.dto.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberPostDto {

    @NotBlank
    @Pattern(regexp = "'\\d{10}",
            message = "사업자 번호는 10자리 숫자입니다.")
    private String businessRegistrationNumber;

    @NotBlank
    @Pattern(regexp = "/^[ㄱ-ㅎ|가-힣|]+$/",
            message = "한글만 입력가능합니다.")
    private String name;

    @NotBlank
    private String companyName;

    @NotBlank
    private String password;

    @NotBlank
    private String sex;

    @NotBlank
    @Pattern(regexp = "/^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|]+$/",
            message = "닉네임은 한글 및 알파벳 대소문자, 숫자만 가능합니다.")
    private String nickname;

    @NotNull(message = "업종 정보가 필요합니다.")
    private CompanyTypeDto companyType;

    @NotNull(message = "업소 위치 정보가 필요합니다.")
    private CompanyLocationDto companyLocation;

}
