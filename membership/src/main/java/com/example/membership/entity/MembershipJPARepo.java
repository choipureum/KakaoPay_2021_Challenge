package com.example.membership.entity;

import java.util.List;

import javax.transaction.Transactional;

import com.example.membership.entity.Membership;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipJPARepo extends JpaRepository<Membership,Long>{

    //Membership find by userId
    @Transactional
    Membership findByUserIdAndMembershipId(String userId,String membershipId);

    //status='Y' 만 전체검색
    @Transactional
	List<Membership> findByMembershipStatus(char c);   
} 