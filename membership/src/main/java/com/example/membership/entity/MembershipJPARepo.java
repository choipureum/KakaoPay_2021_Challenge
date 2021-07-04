package com.example.membership.entity;

import java.util.List;

import javax.transaction.Transactional;

import com.example.membership.entity.Membership;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipJPARepo extends JpaRepository<Membership,Long>{

    /**
     * SELECT * FROM memberShip WHERE userId = @param userId AND membershipId = @param membershipId;
     * @param userId
     * @param membershipId
     * @return
     */
    @Transactional
    Membership findByUserIdAndMembershipId(String userId,String membershipId);

    /**
     * SELECT * FROM memberShip WHERE membershipStatus = 'Y';
     */
    @Transactional
	List<Membership> findByMembershipStatus(char status);   
} 