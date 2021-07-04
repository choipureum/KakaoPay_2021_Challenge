package com.example.membership.entity;

import com.example.membership.entity.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberJPARepo extends JpaRepository<Member,String>{
} 