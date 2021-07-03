package com.example.membership.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.transaction.Transactional;

import lombok.*;
import com.example.membership.entity.*;
import com.example.membership.entity.Membership;
import com.example.membership.entity.MemberJPARepo;
import com.example.membership.entity.Message;
import com.example.membership.service.MembershipService;
import com.example.membership.util.StringUtil;

@RestController
@RequestMapping(value = "/api/v1")
public class MembershipController {
  @Autowired
  private MemberJPARepo memberJPARepo;
  @Autowired
  private MembershipJPARepo membershipJPARepo;
  @Autowired
  private MembershipService membershipService;

  public static final Logger logger = LoggerFactory.getLogger(MembershipController.class);

  // 1. 멤버십 user_id값으로 조회하기 API
  @GetMapping(value = "/membership")
  public Message getMembershipAll(@RequestHeader("X-USER-ID") String userId)
  {
    Message msg = new Message();
    logger.info("[Retrieve] /api/v1/membership/Get:: start");
    try
    { 
      List<Membership> users = membershipService.getMembershipAll();
    
      if(StringUtil.isNullOrEmpty(userId)) // 유저이름의 membership none
      {
        logger.warn("[Retrieve] /api/v1/membership/Get:: none!");      
      }
      else{
        msg.setSuccess(true);
        msg.setError(null);
        msg.setResponse(users);
      }
    }  
    catch(Exception e)
    {
      return msg;
    }  
    return msg;
  }
  //2. 멤버십 등록하기 API
  @PostMapping(value="/membership")
  public Message setMembership(@RequestHeader("X-USER-ID") String userId,@RequestBody Membership membership_tmp)
  {
    logger.warn("[Regist] /api/v1/membership/Get:: start");
    Message msg = new Message();    
    //1. 식별값  none
    if(StringUtil.isNullOrEmpty(userId))
    {
      return msg;
    }   
    Membership membership = Membership.builder()
      .membershipId(membership_tmp.getMembershipId())
      .membershipName(membership_tmp.getMembershipName())
      .point(membership_tmp.getPoint())
      .userId(userId)
      .build();
    membershipJPARepo.save(membership);

    msg.setSuccess(true);
    msg.setError(null);
    msg.setResponse(membership);

    return msg;
  }
  //3. 멤버십 삭제(비활성화)하기 API
  @DeleteMapping(value="/membership/{membershipId}")
  public Message patchMembershipYN(@PathVariable String membershipId,@RequestHeader("X-USER-ID") String userId)
  {
    logger.info("[Patch] /api/v1/membership/{0}::{1}>> start",membershipId,userId);
    Message msg = new Message();  
    boolean isUpdate = membershipService.patchMembershipYN(userId, membershipId);
    //membership 이 없는경우
    //userId가 없는경우
    //membership Id가 없는경우

    if(isUpdate)
    {
      logger.warn("[Delete] /api/v1/membership/{0} Delete:: failure",membershipId);
      return msg;
    }
    msg.setSuccess(true);
    msg.setError(null);
    msg.setResponse(true);
    return msg;
  }
  //4. 멤버십 상세 조회하기 API
  @GetMapping(value = "/membership/{membershipId}")
  public Message getMembershipBymembershipId(@PathVariable String membershipId,@RequestHeader("X-USER-ID") String userId)
  {
    logger.info("[Get] /api/v1/membership/{0}::{1}>> start",membershipId,userId);
    Message msg = new Message();  
    Membership membership = membershipService.getMembershipByMebershipId(userId, membershipId);

    //membership 이 없는경우
    //userId가 없는경우
    //membership Id가 없는경우
    msg.setSuccess(true);
    msg.setError(null);
    msg.setResponse(membership);

    return msg;
  }
  //5. 포인트 적립하기 API
  @PutMapping(value="/membership/point")
  public Message patchMembershipYN(@RequestHeader("X-USER-ID") String userId,@RequestBody Membership membership_tmp)
  {
    logger.info("[Put] /api/v1/membership/point ::{0}>> start",userId);
    Message msg = new Message(); 
    
    boolean isUpdate = membershipService.putMembershipPoint(userId, membership_tmp.getMembershipId(),membership_tmp.getPoint());
    if(isUpdate)
    {
      logger.warn("[Put] /api/v1/membership/point Patch:: failure");
      return msg;
    }
    msg.setSuccess(true);
    msg.setError(null);
    msg.setResponse(true);
    return msg;
  }

}