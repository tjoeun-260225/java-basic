package com.domain.SpringCommunity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/*
Map<String, String> 인증번호저장소 = new HashMap<>();

Map<String, String> 형태는 서버 전체가 공유하는 메모리 저장소
서버 재시작 시 날아가고 만료 기능이 없다.

여러 서버 인스턴스에서는 동작하지 않으며,
실제 운영 환경에서는 Redis 나 DB에 저장하고,
만료시간(예:3분)도 함께 관리하는 것이 좋다.

Redis : 메모리(Ram)에 데이터를 저장하는 매우 빠른 데이터 저장소
주로 캐시(Cache) 세션 저장소, 실시간 데이터 처리, 메세지 브로커 등 많이 사용

데이터베이스처럼 데이터를 저장할 수 있지만,
데이터를 디스크보다 훨씬 빠른 ㅁ베모리에 저장하기 때문에 속도가 매우 빠름

주요 용도
1. 캐시(Cache)
 - 자주 사용하는 데이터 저장
 - 조회 속도를 크게 향상
2. 세션 저장
 - 로그인 정보를 저장
 - 여러 서버가 같은 로그인 정보를 공유할 수 있다.
3. 실시간 순위표
 - 게임 랭킹
 - 인기 검색어
 - 좋아요 순위
4. 메세지 큐 (Pub/Sub)
 - 채팅
 - 실시간 알림
 - 이벤트 전달
 */
@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;

    // 이메일 : 인증번호를 임시로 저장하는 저장소
    private final Map<String, String> 인증번호저장소 = new HashMap<>();

    // 인증번호 6자리 생성

    public String 인증번호생성() {
        Random random = new Random(); // Random 기능을 random 이라는 명칭에 담아서 사용하기
        /*
        String a = "안"
        String a = "안녕"
        String a = "안녕하"
        String a = "안녕하세"    자바의 가비지 컬렉션으로 사용되지 않는 a 변수들을 제거하면서 생성
        String a = "안녕하세요"


        StringBuilder = 숫자나 글자들을 한 글자씩 이어붙일 문자열 조립용 개체
        String 은 값을 합칠 때마다 새 객체가 생겨서 비효율적이라, 여러 번 이어붙일 땐 StringBuilder 를 사용
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) { // 0에서부터 5까지 반복
            /*
            random.nextInt(10) 0~9 사이의 정수 하나를 무작위로 추출
            무작위로 추출한 숫자를 sb.append 문자열조립기에 이어붙이겠다.
             */
            sb.append(random.nextInt(10));
        }
        return sb.toString(); // 반복이 모두 끝나면 sb에 쌓인 6개의 숫자를 문자열로 변환해서 반환
    }

    // 인증번호를 생성해서 이메일로 발송
    public void 인증번호발송(String email) {
        String 인증번호 = 인증번호생성();
        /*
        message 는 누구에게(To) 제목(Subject) 내용(Text) 만 담고
        누가 보내는지(From)은 JavaMailSender 가 application.yaml 에 작성한
        username, password, host 와 같은 정보를 파악하여 application.yaml 에 작성되어 있는 정보를 파악한 후
        메일 보내기를 시도하는 것
         */
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email); // 누구에게 보낼지 설정하는 코드 회원가입 화면에서 사요앚가 입력한 이메일 주소가 여기에 들어간다.
        message.setSubject("[회사이름] 이메일 인증번호 입니다."); // 메일 제목
        message.setText("인증번호는 [" + 인증번호 + "] 입니다. 회원가입 화면에 입력해주세요."); // 메일 본문
        javaMailSender.send(message);
        인증번호저장소.put(email, 인증번호);
    }

    // 사용자가 입력한 인증번호가 맞는지 확인
    public boolean 인증번호확인(String email, String userInputCode) {
        String 저장된인증번호 = 인증번호저장소.get(email);
        if (저장된인증번호 == null) return false;

        boolean 일치 = 저장된인증번호.equals(userInputCode);
        if (일치) 인증번호저장소.remove(email);
        return 일치;
    }
}
