package com.codestates.section4.soloproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COMPANY_TYPE")
@Entity
public class CompanyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyTypeId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    @Builder.Default
    @OneToMany(mappedBy = "companyType")
    private List<Member> members = new ArrayList<>();

}
