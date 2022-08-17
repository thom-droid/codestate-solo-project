package com.codestates.section4.soloproject.dto.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyTypeDto {

    @NotBlank
    private String name;

    @NotBlank
    private String code;

}