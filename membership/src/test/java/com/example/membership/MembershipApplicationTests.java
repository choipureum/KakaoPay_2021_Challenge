package com.example.membership;

import com.example.membership.entity.MemberJPARepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MembershipApplicationTests {

	@Autowired
	MemberJPARepo membershipJpaRepo;

	@Test
	void contextLoads() {
	}

}
