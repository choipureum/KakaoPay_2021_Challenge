package com.example.membership.entity;

import java.util.Date;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "membership")
public class Membership {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "seq")
  private Integer seq;

  @Column(nullable=false,length=30)
  private String membershipId;
  
  @Column(nullable=false,length=30)
  private String userId;

  @Column(nullable=false,length=30)
  private String membershipName;
   
  @Temporal(TemporalType.TIMESTAMP)
  private Date startDate = new Date();
  
  @Column(nullable=false)
  private Character membershipStatus;

  @Column(name ="point", nullable=true)
   private Integer point; 

  @Builder
  public Membership(String membershipId, String membershipName, int point, String userId) {
      Assert.hasText(userId, "userId must not be empty");
      Assert.hasText(membershipId, "membershipId must not be empty");
      Assert.hasText(membershipName, "membershipName must not be empty");
        
      this.membershipId = membershipId;
      this.membershipName = membershipName;       
      this.point = point; 
      this.membershipStatus = 'Y';   
      this.userId = userId;
  }
}
