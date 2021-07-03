package com.example.membership.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.membership.entity.Membership;
import com.example.membership.entity.MembershipCompany;
import com.example.membership.entity.MembershipCompanyJPARepo;
import com.example.membership.entity.MembershipJPARepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MembershipServiceImpl implements MembershipService
{
    @Autowired
    private MembershipJPARepo membershipJPARepo;
    @Autowired
    private MembershipCompanyJPARepo membershipCompanyJPARepo;

    @Override
    @Transactional
    public List<Membership> getMembershipAll() {
        List<Membership> membershipList = membershipJPARepo.findAll();
        return membershipList;
    }

    @Override
    @Transactional
    public List<Membership> getMembershipAllOnlyY() {
        List<Membership> membershipList = membershipJPARepo.findByMembershipStatus('Y');
        return membershipList;
    }
    @Override 
    @Transactional
    public boolean deleteMembershipYN(String userId, String membershipId)
    {
        try
        {
            Membership membership = membershipJPARepo.findByUserIdAndMembershipId(userId,membershipId);
            if(membership ==null)
            {
                return false;
            }
            membership.setMembershipStatus('N');
            membershipJPARepo.save(membership);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
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

            if(membership ==null)
            {
                return false;
            }
            membership.setPoint(membership.getPoint()+point);
            membershipJPARepo.save(membership);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    @Override
    @Transactional
    public boolean IsMemberCompany(String membershipId, String membershipName) {
        try
        {
            MembershipCompany membershipCompany = membershipCompanyJPARepo.findByMembershipIdAndMembershipName(membershipId, membershipName);   
            if(membershipCompany==null)
            {
                return false;
            }     
            membershipCompanyJPARepo.save(membershipCompany);
            return true;  
            
        }
        catch(Exception e)
        {
            return false;
        }
    }
    @Override
    @Transactional
    public List<MembershipCompany> getMembershipCompanyAll() {
        List<MembershipCompany> company = membershipCompanyJPARepo.findAll();
        return company;
    }

}