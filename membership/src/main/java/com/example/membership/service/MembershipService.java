package com.example.membership.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.membership.entity.Membership;
import com.example.membership.entity.MembershipCompany;

@Transactional
public interface MembershipService {
    /**
     * 멤버십전체조회(삭제포함)
     * @return
     * @throws Exception
     */
    @Transactional
    public List<Membership> getMembershipAll() throws Exception;
    
    /**
     * 멤버십전체조회(삭제미포함)
     * @return
     * @throws Exception
     */
    @Transactional
    public List<Membership> getMembershipAllOnlyY() throws Exception;
    /**
     * 멤버십 삭제(membershipStatus: Y => N)
     * @param userId
     * @param membershipId
     * @return
     */
    @Transactional
    public boolean deleteMembershipYN(String userId, String membershipId);

    /**
     * 멤버십 상세조회
     * @param userId
     * @param membershipId
     * @return
     */
    @Transactional
    public Membership getMembershipByMebershipId(String userId, String membershipId);

    /**
     * 멤버십 포인트 적립
     * @param userId
     * @param membershipId
     * @param point
     * @return
     */
    @Transactional
    public boolean putMembershipPoint(String userId, String membershipId, int point);
 
    /**
     * 멤버쉽 제휴사 존재 여부(true,false)
     * @param membershipId
     * @param membershipName
     * @return
     */
    @Transactional
    public boolean IsMemberCompany(String membershipId, String membershipName);

    /**
     * 멤버쉽 제휴사 전체 조회
     * @return
     */
    @Transactional
    public List<MembershipCompany> getMembershipCompanyAll();

    /**
     * 멤버쉽 존재여부 by 회원, 멤버쉽ID
     * @param userId
     * @param membershipId
     * @return
     */
    @Transactional
	public boolean isUseMembership(String userId, String membershipId);
}