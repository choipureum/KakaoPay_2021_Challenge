package com.example.membership;

import com.example.membership.entity.Membership;
import com.example.membership.entity.MembershipCompany;
import com.example.membership.entity.MembershipJPARepo;
import com.example.membership.service.MembershipService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@ExtendWith(MockitoExtension.class)
@DataJpaTest
class MembershipUnitTest{
	
	@Mock
	MembershipJPARepo membershipJpaRepo;
	@Mock	
	MembershipCompany memberhsipCompany;
	@InjectMocks
	MembershipService membershipService;

	Membership membershipTest;		
	Membership savedMembershipTest;

	private Membership createMembershipData(){
		membershipTest = Membership.builder().membershipId("spc").membershipName("happypoint").userId("test2").point(120).build(); 
		return membershipTest;
	}
	private Membership createMembershipTestData(){		
		savedMembershipTest = new Membership();
		savedMembershipTest.setMembershipId("spc");
		savedMembershipTest.setMembershipName("happypoint");
		savedMembershipTest.setUserId("test2");
		savedMembershipTest.setPoint(120);
		savedMembershipTest.setMembershipStatus('Y');
		savedMembershipTest.setStartDate(membershipTest.getStartDate());
		return savedMembershipTest;
	}
	

	@Test
	@DisplayName("Membership getAll Test")
	void get_Membership_well_test() throws Exception
	{
		membershipTest = createMembershipData();
		savedMembershipTest = createMembershipTestData();
		//given		
		Assertions.assertEquals(membershipTest.getUserId(), savedMembershipTest.getUserId(),"saved UserId Test");
        Assertions.assertEquals(membershipTest.getMembershipId(), savedMembershipTest.getMembershipId(),"saved MembershipId Test");
		Assertions.assertEquals(membershipTest.getMembershipName(), savedMembershipTest.getMembershipName(),"saved MembershipName Test");
	}
	@Test
	@DisplayName("Membership get By Id")
	void get_Membership_fail_test()
	{
		membershipTest = createMembershipData();
		savedMembershipTest = createMembershipTestData();
		//given	
		Assertions.assertEquals(membershipTest.getUserId(), "none exist userId","saved UserId fail Test");
        Assertions.assertEquals(membershipTest.getMembershipId(),"none exist membershipid","saved MembershipId fail Test");
		Assertions.assertEquals(membershipTest.getMembershipName(), "none exist membershipName","saved MembershipName fail Test");
	}
}
