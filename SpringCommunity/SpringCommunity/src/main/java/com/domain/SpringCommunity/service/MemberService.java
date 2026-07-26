package com.domain.SpringCommunity.service;

import com.domain.SpringCommunity.dto.Member;
import com.domain.SpringCommunity.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    // application.yaml에 file.upload_dir 값을 그대로 사용
    @Value("${file.upload-dir}")
    private String uploadDir; // application.yaml에 작성한 폴더 경로를 uploadDir 저장

    public void 회원가입기능(Member member, MultipartFile profileImg) {
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

        // 사용자가 프로필 이미지를 첨부한 경우에만 이미지 업로드 처리
        if (profileImg != null && !profileImg.isEmpty()) {
            String 저장된파일이름 = 프로필이미지저장(profileImg);
            member.setProfileImage(저장된파일이름);
        }
        // sql에 최종적으로 저장한다.
        memberMapper.insertMember(member);
    }

    private String 프로필이미지저장(MultipartFile file) {
        // 여러 사용자가 같은 이름으로 이미지를 올려도 겹치지 않도록
        // UUID 무작위 고유값을 파일이름에 붙여서 새 파일이름으로 생성하고 저장
        String 원본파일이름 = file.getOriginalFilename();
        String 저장파일이름 = UUID.randomUUID() + "-" + 원본파일이름;

        try {
            // 절대 경로 형태의 기준으로 이미지 저장하도록 세팅
            File 저장폴더 = new File(uploadDir).getAbsoluteFile();
            // 저장폴더가 없으면 새로 생성
            if (!저장폴더.exists()) 저장폴더.mkdirs();
            File 저장파일 = new File(저장폴더, 저장파일이름);
            file.transferTo(저장파일); // 업로드 된 파일을 실제 서버 디스크에 저장
        } catch (IOException e) {
            throw new RuntimeException("프로필 이미지 업로드 중 오류가 발생했습니다.", e);
        }
        return 저장파일이름;
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
        if (!비밀번호일치) return null;
        // 아이디에 존재하는 비밀번호가 맞다면
        return db멤버;
    }
}
