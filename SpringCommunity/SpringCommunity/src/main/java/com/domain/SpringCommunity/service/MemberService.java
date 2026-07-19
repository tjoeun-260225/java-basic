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

        // 암호화처리된 비밀번호는
        // 복구하여 사람의 글자로 변경할 수 없다.

        // $2a$10$VwruTMVBTyR.dfeKX6ta.e8P/kyMoYFNYNDQYwglIi6BfUZDmRr3m
        // 비밀번호 5회 이상 틀릴 경우 계정 잠기거나 일시정지되어
        // 몇 초 후 다시 비밀번호 입력하세요.
        // BCrypto 암호화가 생성되며
        // 비밀번호 찾기를 할 경우 예전에는
        // 고객이 입력한 비밀번호를 DB에서 가져올 수 있었지만
        // 암호화된 비밀번호를 복구할 수 없기 때문에
        // 새 비밀번호를 입력해야하는 현상 발생
        String 암호화완료 = passwordEncoder.encode(member.getPassword());
        // 암호화 처리 완료된 변수로 비밀번호 변경한 후
        member.setPassword(암호화완료);

        // sql에 최종적으로 저장한다.
        memberMapper.insertMember(member);
    }

    /**
     * 로그인기능
     * 아이디로 회원을 조회한 뒤,
     * 사용자가 입력한 비밀번호와 DB에 암호화되어 저장된 비밀번호 비교
     * 일치하면 회원 정보를 반환하고, 일치하지 않으면 null 반환
     */
    public Member 로그인기능(Member member) {
        // 클라이언트가 작성한 id로 유저가 존재하는지 sql 조회
        Member db멤버 = memberMapper.findById(member.getId());
        // 아이디가 존재하지않는 경우
        // if else for 문 구문에서 {} 내부에 존재하는 코드가 한 줄일 경우
        // {} 를 생략해서 작성할 수 있다.
        if (db멤버 == null) return null;
        // 아이디가 존재하고 입력한 비밀번호와 암호화된 비밀번호 비교
        // matches(클라이언트가 작성한 비밀번호, DB에 저장된 암호화된 비밀번호)
        // 클라이언트가 작성한 비밀번호를 암호화 처리하여 DB에 저장된 비밀번호와
        // 일치하는지 확인하고, 확인결과를 비밀번호일치 라는 변수에 담아서 저장
        boolean 비밀번호일치 = passwordEncoder.matches(
                member.getPassword(),   // 클라이언트가 작성한 비밀번호 가져오기
                db멤버.getPassword()    // DB에 저장되어 있는 암호화 비밀번호 가져오기
        );
        // 비밀번호가 다르다면
        if (!비밀번호일치) return  null;
        // 아이디에 존재하는 비밀번호가 맞다면
        return db멤버;
    }
}
