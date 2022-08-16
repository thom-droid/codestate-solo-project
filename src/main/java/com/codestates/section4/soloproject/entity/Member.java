package com.codestates.section4.soloproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

    @Column(nullable = false, updatable = false, unique = true)
    private String businessRegistrationNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private String nickname;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Status status = Status.NORMAL;

    @ManyToOne
    @JoinColumn(name ="COMPANY_TYPE_ID")
    private CompanyType companyType;

    @ManyToOne
    @JoinColumn(name = "COMPANY_LOCATION_ID")
    private CompanyLocation companyLocation;

    @Getter
    @AllArgsConstructor
    public enum Role {

        USER("ROLE_USER"),
        ADMIN("ROLE_ADMIN"),
        ;

        private final String desc;
    }

    @Getter
    @AllArgsConstructor
    public enum Status {

        NORMAL(1, "이상없음"),
        BANNED(2, "밴당함"),
        DELETED(3, "탈퇴함");

        private final int code;
        private final String desc;

    }

    public void addCompanyLocation(CompanyLocation location) {
        if (!location.getMembers().contains(this)) {
            location.getMembers().add(this);
        }

        this.companyLocation = location;
    }

    public void addCompanyType(CompanyType type) {
        if (!type.getMembers().contains(this)) {
            type.getMembers().add(this);
        }

        this.companyType = type;
    }

}