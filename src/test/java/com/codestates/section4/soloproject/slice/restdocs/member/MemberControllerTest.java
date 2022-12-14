package com.codestates.section4.soloproject.slice.restdocs.member;

import com.codestates.section4.soloproject.controller.MemberController;
import com.codestates.section4.soloproject.dto.member.CompanyLocationDto;
import com.codestates.section4.soloproject.dto.member.CompanyTypeDto;
import com.codestates.section4.soloproject.dto.member.MemberPostDto;
import com.codestates.section4.soloproject.dto.member.MemberResponseDto;
import com.codestates.section4.soloproject.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

@ExtendWith(MockitoExtension.class)
@AutoConfigureRestDocs
@WebMvcTest(MemberController.class)
public class MemberControllerTest {

    @MockBean
    private MemberService memberService;

    @Autowired
    private MockMvc mockMvc;

    private final String url = "/member";

    @DisplayName("MemberController.postItem()")
    @Test
    public void givenMemberPostDto_whenPostRequest_thenResponseDtoReturn() throws Exception {
        //given

        //request
        CompanyTypeDto companyTypeDto =
                CompanyTypeDto.builder()
                        .name("???????????????")
                        .code("SNACK")
                        .build();

        CompanyLocationDto companyLocationDto =
                CompanyLocationDto.builder()
                        .name("??????")
                        .build();

        MemberPostDto requestDto =
                MemberPostDto.builder()
                        .businessRegistrationNumber("1112223334")
                        .name("?????????")
                        .companyName("?????????")
                        .password("12341234")
                        .sex("male")
                        .nickname("kim dutch")
                        .companyType(companyTypeDto)
                        .companyLocation(companyLocationDto)
                        .build();

        // serialization
        String request = new ObjectMapper().writeValueAsString(requestDto);

        // response
        MemberResponseDto responseDto =
                MemberResponseDto.builder()
                        .name(requestDto.getName())
                        .companyName(requestDto.getCompanyName())
                        .sex(requestDto.getSex())
                        .nickname(requestDto.getNickname())
                        .companyType(requestDto.getCompanyType())
                        .companyLocation(requestDto.getCompanyLocation())
                        .build();

        org.mockito.BDDMockito.given(memberService.postMember(Mockito.any(MemberPostDto.class))).willReturn(responseDto);

        //when
        ResultActions resultActions = mockMvc.perform(
                post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request)
                );

        //then
        resultActions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.response.name").value(responseDto.getName()))
                .andExpect(jsonPath("$.response.companyName").value(responseDto.getCompanyName()))
                .andExpect(jsonPath("$.response.sex").value(responseDto.getSex()))
                .andExpect(jsonPath("$.response.nickname").value(responseDto.getNickname()))
                .andExpect(jsonPath("$.response.companyType.name").value(responseDto.getCompanyType().getName()))
                .andExpect(jsonPath("$.response.companyType.code").value(requestDto.getCompanyType().getCode()))
                .andExpect(jsonPath("$.response.companyLocation.name").value(requestDto.getCompanyLocation().getName()));

        // documentation
        resultActions
                .andDo(document(
                        "post-member",
                        Preprocessors.preprocessRequest(Preprocessors.prettyPrint()),
                        Preprocessors.preprocessResponse(Preprocessors.prettyPrint()),
                        requestFields(List.of(
                                fieldWithPath("businessRegistrationNumber").type(JsonFieldType.STRING).description("????????? ?????? ??????"),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("????????? ??????"),
                                fieldWithPath("companyName").type(JsonFieldType.STRING).description("?????????"),
                                fieldWithPath("password").type(JsonFieldType.STRING).description("????????????"),
                                fieldWithPath("sex").type(JsonFieldType.STRING).description("??????"),
                                fieldWithPath("nickname").type(JsonFieldType.STRING).description("??????"),
                                fieldWithPath("companyType").type(JsonFieldType.OBJECT).description("?????? ??????"),
                                fieldWithPath("companyType.name").type(JsonFieldType.STRING).description("?????????"),
                                fieldWithPath("companyType.code").type(JsonFieldType.STRING).description("?????? ??????"),
                                fieldWithPath("companyLocation").type(JsonFieldType.OBJECT).description("????????? ??????"),
                                fieldWithPath("companyLocation.name").type(JsonFieldType.STRING).description("?????????")
                        )),
                        responseFields(List.of(
                                fieldWithPath("response.name").type(JsonFieldType.STRING).description("????????? ??????"),
                                fieldWithPath("response.companyName").type(JsonFieldType.STRING).description("?????????"),
                                fieldWithPath("response.sex").type(JsonFieldType.STRING).description("??????"),
                                fieldWithPath("response.nickname").type(JsonFieldType.STRING).description("??????"),
                                fieldWithPath("response.companyType").type(JsonFieldType.OBJECT).description("?????? ??????"),
                                fieldWithPath("response.companyType.name").type(JsonFieldType.STRING).description("?????????"),
                                fieldWithPath("response.companyType.code").type(JsonFieldType.STRING).description("?????? ??????"),
                                fieldWithPath("response.companyLocation").type(JsonFieldType.OBJECT).description("????????? ??????"),
                                fieldWithPath("response.companyLocation.name").type(JsonFieldType.STRING).description("?????????")
                        ))
                ));
    }
}
