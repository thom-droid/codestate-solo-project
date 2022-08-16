package com.codestates.section4.soloproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CompanyLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyLocationId;

    @Column(nullable = false)
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "companyLocation")
    private List<Member> members = new ArrayList<>();
}