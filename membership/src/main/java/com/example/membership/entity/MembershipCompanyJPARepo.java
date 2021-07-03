package com.example.membership.entity;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipCompanyJPARepo extends JpaRepository<MembershipCompany,String> {
    
    List<MembershipCompany> findByMembershipId(String membershipId);
    List<MembershipCompany> findByMembershipName(String membershipName);
    
    @Transactional
    MembershipCompany findByMembershipIdAndMembershipName(String membershipId,String membershipName);
}