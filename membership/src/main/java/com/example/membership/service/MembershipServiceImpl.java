package com.example.membership.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.membership.entity.Membership;
import com.example.membership.entity.MembershipCompany;
import com.example.membership.entity.MembershipCompanyJPARepo;
import com.example.membership.entity.MembershipJPARepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MembershipServiceImpl implements MembershipService {
    private static final Logger logger = LoggerFactory.getLogger(MembershipService.class);
    @Autowired
    private MembershipJPARepo membershipJPARepo;
    @Autowired
    private MembershipCompanyJPARepo membershipCompanyJPARepo;

    @Override
    @Transactional

    public List<Membership> getMembershipAll() {
        List<Membership> membershipList = null;
        try {
            membershipList = membershipJPARepo.findAll();

        } catch (Exception e) {
            logger.error(String.format("[error] getMembershipAll Error : %2", e));
        }
        return membershipList;
    }

    @Override
    @Transactional
    public List<Membership> getMembershipAllOnlyY() {
        return membershipJPARepo.findByMembershipStatus('Y');
    }

    @Override
    @Transactional
    public boolean deleteMembershipYN(String userId, String membershipId) {
        try {
            Membership membership = membershipJPARepo.findByUserIdAndMembershipId(userId, membershipId);
            if (membership == null) {
                return false;
            }
            membership.setMembershipStatus('N');
            membershipJPARepo.save(membership);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public Membership getMembershipByMebershipId(String userId, String membershipId) {
        Membership membership = null;
        try {
            membership = membershipJPARepo.findByUserIdAndMembershipId(userId, membershipId);
        } catch (Exception e) {
            logger.error(String.format("[error] getMembershipByMebershipId Error : %2", e));
        }
        return membership;
    }

    @Override
    @Transactional
    public boolean putMembershipPoint(String userId, String membershipId, int point) {
        Membership membership = null;

        try {
            membership = membershipJPARepo.findByUserIdAndMembershipId(userId, membershipId);
            if (membership == null) {
                return false;
            }
            membership.setPoint(membership.getPoint() + point);
            membershipJPARepo.save(membership);
            return true;
        } catch (Exception e) {
            logger.error(String.format("[error] putMembershipPoint Error : %2", e));
            return false;
        }
    }

    @Override
    @Transactional
    public boolean IsMemberCompany(String membershipId, String membershipName) {
        MembershipCompany membershipCompany = null;
        try {
            membershipCompany = membershipCompanyJPARepo.findByMembershipIdAndMembershipName(membershipId,membershipName);
            if (membershipCompany == null) {
                return false;
            }
            membershipCompanyJPARepo.save(membershipCompany);
            return true;

        } catch (Exception e) {
            logger.error(String.format("[error] IsMemberCompany Error : %2", e));
            return false;
        }
    }

    @Override
    @Transactional
    public List<MembershipCompany> getMembershipCompanyAll() {
        List<MembershipCompany> company = null;
        try {             
            company = membershipCompanyJPARepo.findAll();
        } catch (Exception e) {          
            logger.error(String.format("[error] getMembershipCompanyAll Error : %2", e));
        } 
        return company;
    }
    @Override
    @Transactional
    public boolean isUseMembership(String userId, String membershipId) {
        try {  
            Membership membership = membershipJPARepo.findByUserIdAndMembershipId(userId, membershipId);
            if(membership ==null)
            {
                return false;
            }
        }
        catch(Exception e){} 
        return true;       
    }

}