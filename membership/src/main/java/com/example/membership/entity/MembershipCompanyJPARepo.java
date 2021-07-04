package com.example.membership.entity;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipCompanyJPARepo extends JpaRepository<MembershipCompany,String> {
    
    /**
     * SELECT * FROM membershipCompany WHERE  membershipID = @param membershipId;
     * @param membershipId
     * @return
     */
    @Transactional
    List<MembershipCompany> findByMembershipId(String membershipId);
    /**
     * SELECT * FROM membershipCompany WHERE  membershipNAME = @param membershipName;
     * @param membershipName
     * @return
     */
    @Transactional
    List<MembershipCompany> findByMembershipName(String membershipName);
    
    /**
     * SELECT * FROM membershipCompany WHERE  membershipID = @param membershipID AND  membershipNAME = @param membershipName;
     * @param membershipId
     * @param membershipName
     * @return
     */
    @Transactional
    MembershipCompany findByMembershipIdAndMembershipName(String membershipId,String membershipName);
}