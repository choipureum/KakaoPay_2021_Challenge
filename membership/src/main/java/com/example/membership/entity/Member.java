package com.example.membership.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.util.Assert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="member")
public class Member{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userNo;

    @Column(name = "uId",unique = true,nullable = false)
    private String uid;

    @OneToMany 
    private List<Membership> membership = new ArrayList<Membership>();

    @Builder
    public Member(String userId) {
        Assert.hasText(userId, "membershipId must not be empty");       
        this.uid = userId;        
    }

    
}