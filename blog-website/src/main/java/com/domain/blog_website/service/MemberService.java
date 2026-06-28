package com.domain.blog_website.service;

import com.domain.blog_website.model.entity.Member;
import com.domain.blog_website.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    // 전체회원목록을 가져오는 기능을 사용하면
    // List<Member> 형태로 멤버들의 목록을
    // sql에서 가져와 반환처리 하겠다.
    public List<Member> 전체회원목록(){
        return memberRepository.findAll();
    }

    public void 회원가입(Member member){
        // 이메일 인증 과 같은 로직을 따로 기능으로 만들어 작성
        // 나중에 비밀번호 암호화 처리와 같은 로직 작성
        memberRepository.save(member);
    }

}
