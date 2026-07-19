package com.domain.SpringCommunity.service;

import com.domain.SpringCommunity.dto.Member;
import com.domain.SpringCommunity.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    public  void 회원가입기능(Member member){
        // 클라이언트가 작성한 비밀번호를 암호화해서
        //  sql 에 저장할 수 있도록 암호화 처리 작업

        //  암호화완료라는       암호화작업하여   소비자가 작성한 비밀번호를 가져와서
        //  변수에임시저장한다.
        String 암호화완료 = passwordEncoder.encode(member.getPassword());
        // 암호화 처리 완료된 변수로 비밀번호 변경한 후
        member.setPassword(암호화완료);

        // sql에 최종적으로 저장한다.
        memberMapper.insertMember(member);
    }
}
