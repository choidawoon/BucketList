package com.toy.Backend.service;

import com.toy.Backend.entity.Member;
import com.toy.Backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member getMember(String memerId){

        return memberRepository.findById(memerId).get();

    }
}
