package com.example.membership.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.membership.entity.Membership;
import com.example.membership.entity.MembershipCompany;

@Transactional
public interface MembershipService {
    //멤버십전체조회(삭제포함)
    @Transactional
    public List<Membership> getMembershipAll() throws Exception;

    //멤버십전체조회(삭제미포함)
    @Transactional
    public List<Membership> getMembershipAllOnlyY() throws Exception;
    //멤버십 삭제(membershipStatus: Y => N)
    @Transactional
    public boolean deleteMembershipYN(String userId, String membershipId);

    //멤버십 상세조회
    @Transactional
    public Membership getMembershipByMebershipId(String userId, String membershipId);

    //멤버십 포인트 적립
    @Transactional
    public boolean putMembershipPoint(String userId, String membershipId, int point);
 
    //멤버쉽 제휴사 존재 여부(true,false)
    @Transactional
    public boolean IsMemberCompany(String membershipId, String membershipName);

    //멤버쉽 제휴사 전체 조회
    @Transactional
    public List<MembershipCompany> getMembershipCompanyAll();
}