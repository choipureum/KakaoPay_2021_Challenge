package com.example.membership.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="memberCompany")
public class MembershipCompany {

    @Id
    @Column(name = "membershipId",unique = true,nullable = false)
    private String membershipId;

    @Column(name = "membershipName",unique = true,nullable = false)
    private String membershipName;

    public MembershipCompany(String membershipId, String membershipName){
        this.membershipId = membershipId;
        this.membershipName = membershipName;
    }
}