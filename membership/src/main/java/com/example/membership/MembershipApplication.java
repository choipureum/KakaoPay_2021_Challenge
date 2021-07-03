package com.example.membership;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.example.membership.entity.Member;
import com.example.membership.entity.Membership;
import com.example.membership.entity.MembershipCompany;
import com.example.membership.entity.MembershipCompanyJPARepo;
import com.example.membership.entity.MembershipJPARepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@Transactional
public class MembershipApplication {

	@Autowired
	private MembershipJPARepo membershipJPARepo;
    @Autowired
	private MembershipCompanyJPARepo membershipCompanyJPARepo;
    @Autowired
    @PersistenceContext
    private EntityManager em;
    //h2 초기 더미데이터 테스트
	@Bean
    @Transactional
    public ApplicationRunner appRunner() {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                //시드 데이타
                Member member = Member.builder().userId("test1").build();
                
                Membership m1 = Membership.builder().membershipId("spc").membershipName("happypoint").userId("test1").point(120).build(); 
                Membership m2 = Membership.builder().membershipId("shinsegae").membershipName("shinsegaepoint").userId("test1").point(3500).build(); 
                Membership m3 = Membership.builder().membershipId("cj").membershipName("cjone").userId("test1").point(1029).build();
                List<Membership> mList = new ArrayList<>();
                mList.add(m1);mList.add(m2);mList.add(m3);                                          
                member.setMembership(mList);

                membershipJPARepo.save(m1);    
                membershipJPARepo.save(m2); 
                membershipJPARepo.save(m3); 

                //company 제휴사 데이타 셋팅(안들어갈시)

                membershipCompanyJPARepo.save(new MembershipCompany("spc", "happypoint"));
                membershipCompanyJPARepo.save(new MembershipCompany("shinsegae", "shinsegaepoint"));
                membershipCompanyJPARepo.save(new MembershipCompany("cj", "cjone"));
                
            }
        };
    }
	public static void main(String[] args) {
		SpringApplication.run(MembershipApplication.class, args);
	}

}
