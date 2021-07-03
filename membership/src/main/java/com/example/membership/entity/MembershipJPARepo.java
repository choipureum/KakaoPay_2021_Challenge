package com.example.membership.entity;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.membership.entity.Membership;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface MembershipJPARepo extends JpaRepository<Membership,Long>{
    //Membership find by userId
    Membership findByUserIdAndMembershipId(String userId,String membershipId);

    //status='Y' 만 전체검색
	List<Membership> findByMembershipStatus(char c);   
} 