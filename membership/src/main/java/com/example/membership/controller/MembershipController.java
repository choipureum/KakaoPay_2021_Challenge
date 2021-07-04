package com.example.membership.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

import com.example.membership.entity.ErrorMsg;
import com.example.membership.entity.Membership;
import com.example.membership.entity.MembershipCompany;
import com.example.membership.entity.MembershipJPARepo;
import com.example.membership.entity.Message;
import com.example.membership.service.MembershipService;
import com.example.membership.util.StringUtil;

@RestController
@RequestMapping(value = "/api/v1")
public class MembershipController {
  @Autowired
  private MembershipJPARepo membershipJPARepo;
  @Autowired
  private MembershipService membershipService;


  public static final Logger logger = LoggerFactory.getLogger(MembershipController.class);

  /**
   * 1. 멤버십 user_id값으로 조회하기 API
   * @param userId
   * @return
   */
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

  /**
   * 2. 멤버십 등록하기 API
   * @param userId
   * @param membership_tmp
   * @return
   */
  @PostMapping(value="/membership")
  public Message setMembership(@RequestHeader("X-USER-ID") String userId,@RequestBody Membership membership_tmp)
  {
    logger.info("[Regist] /api/v1/membership/Get:: start");
    Message msg = new Message(); 
       
    //1. 식별값(X-USER-ID) : NONE
    if(StringUtil.isNullOrEmpty(userId))
    {
      return msg;
    }   
    //2. membership value 체크 
      //2-1 membershipId 값 체크 (spc,shindegae,cj)
      //2-2 membershipName 값 체크: (happypoint,shinsegae,cjone)
      //2-3 point num 체크
    String membershipId = membership_tmp.getMembershipId();
    String membershipName = membership_tmp.getMembershipName();
    int point = membership_tmp.getPoint() == null ? 0 : membership_tmp.getPoint();
    
    boolean isOurCompanyYN = membershipService.IsMemberCompany(membershipId, membershipName);
    boolean isUseCompanyById = membershipService.isUseMembership(userId,membershipId);
    //제휴사 아님
    if(!isOurCompanyYN )
    {
       msg.setError(new ErrorMsg("membership Info",400));
      
    }
    //이미 등록된 멤버십일경우 
    //기존 포인트에 플러스 point적립
    else if(isUseCompanyById)
    {
      membershipService.putMembershipPoint(userId, membershipId, point);
      msg.setSuccess(true);
      msg.setError(null);
      msg.setResponse(null);

      return msg;
    }
    //success : 제휴사일때
    else
    {
      Membership membership = Membership.builder()
      .membershipId(membershipId)
      .membershipName(membershipName)
      .point(point)
      .userId(userId)
      .build();
      membershipJPARepo.save(membership);

      msg.setSuccess(true);
      msg.setError(null);
      msg.setResponse(membership);
    }
    return msg;
  }
  /**
   * 3. 멤버십 삭제(비활성화)하기 API
   * @param membershipId
   * @param userId
   * @return
   */
  @DeleteMapping(value="/membership/{membershipId}")
  public Message patchMembershipYN(@PathVariable String membershipId,@RequestHeader("X-USER-ID") String userId)
  {
    logger.info(String.format("[Delete] /api/v1/membership/%s::%s>> start",membershipId,userId));
    Message msg = new Message();  
    //membership 이 없는경우
    //userId가 없는경우
    //membership Id가 없는경우
    boolean isUpdate = membershipService.deleteMembershipYN(userId, membershipId);

    if(StringUtil.isNullOrEmpty(userId)) // 유저이름의 membership none
    {
      logger.warn("[Retrieve] /api/v1/membership/Get:: none!");      
    }
    else if(!isUpdate)
    {
      logger.warn(String.format("[Delete] /api/v1/membership/%s Delete:: failure",membershipId));
      msg.setError(new ErrorMsg("Membership Not Found By userId"));
    }
    else
    {
      msg.setSuccess(true);
      msg.setError(null);
      msg.setResponse(true);
    }
    
    return msg;
  }

  /**
   * 4. 멤버십 상세 조회하기 API
   * @param membershipId
   * @param userId
   * @return
   */
  @GetMapping(value = "/membership/{membershipId}")
  public Message getMembershipBymembershipId(@PathVariable String membershipId,@RequestHeader("X-USER-ID") String userId)
  {
    logger.info(String.format("[Get] /api/v1/membership/%s::%s>> start",membershipId,userId));
    Message msg = new Message();  
    Membership membership = membershipService.getMembershipByMebershipId(userId, membershipId);

    if(StringUtil.isNullOrEmpty(userId)) // 유저이름의 membership none
    {
      logger.warn(String.format("[Get] /api/v1/membership/%2 :: none!",membershipId));      
    }
    //membership : NONE
    else if(membership == null)
    {
      logger.warn(String.format("[GET] /api/v1/membership/%s Get:: failure",membershipId));
      msg.setError(new ErrorMsg("Membership Not Found By userId"));
    }
    else
    {
      msg.setSuccess(true);
      msg.setError(null);
      msg.setResponse(membership);
    }
   
    return msg;
  }

  /**
   * 5. 포인트 적립하기 API
   * @param userId
   * @param param
   * @return
   */
  @PutMapping(value="/membership/point")
  public Message patchMembershipYN(@RequestHeader("X-USER-ID") String userId, @RequestBody Map<String,Object> param)
  {
    logger.info(String.format("[Put] /api/v1/membership/point ::%s>> start",userId));
    Message msg = new Message(); 
    
    if(StringUtil.isNullOrEmpty(userId)) // 유저이름의 membership none
    {
      logger.warn(String.format("[Get] /api/v1/membership/Get by $s:: none!",userId));      
    }
    String membershipId = param.get("membershipId").toString();

    //포인트 적립
    //  사용금액(1%)
    int amount = StringUtil.isNum(param.get("amount").toString())?(int)param.get("amount"):0;

    int point = (int) Math.floor(amount / 100);

    boolean isUpdate = membershipService.putMembershipPoint(userId,membershipId,point);
    
    if(!isUpdate)
    {
      logger.warn(String.format("[Put] /api/v1/membership/point::$s::$s failure",membershipId,userId));
      msg.setError(new ErrorMsg("Membership Not Found By userId"));
      return msg;
    }
    else
    {
      msg.setSuccess(true);
      msg.setError(null);
      msg.setResponse(true);
    }
    return msg;
  }

  /**
   * 6. 전체 제휴사 조회 API(for test)
   * @return
   */
  @GetMapping(value="/membership/company")
  public Object getMembershipCompany()
  {
    logger.info("[Get] /api/v1/membership/company ::>> start");
    List<MembershipCompany> company = membershipService.getMembershipCompanyAll();
    return company;
  }

}