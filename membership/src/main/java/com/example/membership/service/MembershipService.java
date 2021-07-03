package com.example.membership.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.membership.entity.Member;
import com.example.membership.entity.Membership;

@Transactional
public interface MembershipService {
    //멤버십전체조회
    @Transactional
    public List<Membership> getMembershipAll() throws Exception;
    //멤버십 update
    @Transactional
    public boolean patchMembershipYN(String userId, String membershipId);

    //멤버십 상세조회
    @Transactional
    public Membership getMembershipByMebershipId(String userId, String membershipId);

    //멤버십 포인트 적립
    @Transactional
    public boolean putMembershipPoint(String userId, String membershipId, int point);
}