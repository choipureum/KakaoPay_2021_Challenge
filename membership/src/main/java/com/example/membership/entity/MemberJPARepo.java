package com.example.membership.entity;

import java.util.List;

import javax.transaction.Transactional;

import com.example.membership.entity.Member;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface MemberJPARepo extends JpaRepository<Member,String>{

} 