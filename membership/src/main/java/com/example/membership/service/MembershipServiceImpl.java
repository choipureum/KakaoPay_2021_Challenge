package com.example.membership.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.membership.entity.Member;
import com.example.membership.entity.MemberJPARepo;
import com.example.membership.entity.Membership;
import com.example.membership.entity.MembershipJPARepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MembershipServiceImpl implements MembershipService
{
    @Autowired
    private  MemberJPARepo memberJPARepo;
    @Autowired
    private MembershipJPARepo membershipJPARepo;

    @Override
    @Transactional
    public List<Membership> getMembershipAll() {
        List<Membership> membershipList = membershipJPARepo.findByMembershipStatus('Y');
        return membershipList;
    }
    @Override 
    @Transactional
    public boolean patchMembershipYN(String userId, String membershipId)
    {
        try
        {
            Membership membership = membershipJPARepo.findByUserIdAndMembershipId(userId,membershipId);
            membership.setMembershipStatus('N');
            membershipJPARepo.save(membership);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    @Override
    @Transactional
    public Membership getMembershipByMebershipId(String userId, String membershipId) {
        Membership membership = membershipJPARepo.findByUserIdAndMembershipId(userId,membershipId);
        return membership;
    }
    @Override
    @Transactional
    public boolean putMembershipPoint(String userId, String membershipId, int point) {
        try
        {
            Membership membership = membershipJPARepo.findByUserIdAndMembershipId(userId,membershipId);
            membership.setPoint(membership.getPoint()+point);
            membershipJPARepo.save(membership);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

}