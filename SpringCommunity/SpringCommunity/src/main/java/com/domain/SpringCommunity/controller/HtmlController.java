package com.domain.SpringCommunity.controller;

import com.domain.SpringCommunity.dto.Member;
import com.domain.SpringCommunity.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/*
@Controller 나 @RestController 의 경우
build.gradle 에서 starter 모듈이 있어야지 사용할 수 있는 어노테이션이다.

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter'
 */
@Controller
@RequiredArgsConstructor
public class HtmlController {
    // 반드시 @RequiredArgsConstructor 가 있어야지 사용할 수 있다.
    // @RequiredArgsConstructor = 상황에 따라 필요한 생성자 사용
    //  하는 객체 생성
    // 매번 Service를 호출할 때 마다 new MemberService()
    // 와 같은 형태를 개발자가 작성해야하는 번거로움 해소
    private final MemberService memberService;

    /*
    GetMapping 을 가져오는 경로는 아래 둘 중 하나에서 가져와 사용하게 된다.
    만약 build.gradle 에서 둘 중 하나의 모듈을 나의 프로젝트에 가져와
    세팅해주지 않는 다면 @GetMapping 과 같은 웹 접속 어노테이션을
    사용할 수 없다.
    외부에서 스프링부트 개발자가 spring-boot-starter-web 이라 하는
    모듈을 만들어서 제공하였고, 제공한 모듈을 인터넷이 연결되어 있는 상태로
    최초 1회 스프링부트 웹에서 나의 프로젝트로 다운로드 하여 코딩 작업을
    할 수 있는 상태가 되는 것

    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-webmvc'
     */
    @GetMapping("/")
    public String indexHtml() {
        return "index";
    }

    @GetMapping("/login")
    public String loginHtml() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupHtml() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(Member member,
                         @RequestParam(value = "profileImg", required = false)
                         MultipartFile profileImg) {
        memberService.회원가입기능(member, profileImg);
        return "redirect:/login";    }

    // 오늘은 session 으로만 작업
    // 다음주에 cookies session 으로 작업

    /**
     * 로그인 처리
     * 성공하면 세션에 로그인 정보를 저장하고 메인페이지로 이동
     * 실패하면 로그인 페이지로 다시 이동하면서 에러 메세지 전달
     */
    // import org.springframework.ui.Model;
    @PostMapping("/login")
    // 아래 login 파라미터의 경우 html에서 전달받을 자료형에 해당하는
    // 자리만 만들어서 데이터를 전달받을 수 있는 상태
    //public String login(String id, String password, HttpSession session, Model model) {
    public String login(Member member, HttpSession session, Model model) {
        Member loginMember = memberService.로그인기능(member);

        if (loginMember == null) {
            model.addAttribute("error",
                    "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "login";
        }
        // 아이디 비밀번호가 존재한다면 세션에 로그인한 회원 정보 저장
        // 비밀번호는 굳이 저장하지 않아도 된다.
        session.setAttribute("loginMember", loginMember);
        // 로그인 세션(쿠키)의 유효시간을 30분으로 지정
        // 브라우저에 발급되는 JSESSIONID 쿠키가 30분간 활동 없으면 자동 만료처리
        session.setMaxInactiveInterval(60 * 30);
        return "redirect:/";
    }

    /**
     * 로그아웃 처리
     * 세션을 초기화하고 메인페이지로 이동
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션에 있는 로그인 정보 지우기
        return "redirect:/"; // index.html 로 이동
    }
    // 현재 HttpSession 의 경우 cookie 세션을 대신할 대체로
    // 내용이 심오하여 가볍게 로그인 처리가 되는 것을 보기위한 임시 용도
    /*
    옛날에 쿠키가 위험하다 한 이유
    예전 방식은 쿠키 안에 실제 로그인 정보(아이디, 비밀번호, 혹은 로그인 함 같은
    상태값)을 직접 저장
    cookie: user=gildong; isLogin=true
    이렇게하면
    브라우저 개발자 도구만 열어도 값을 보고 조작할 수 있다
    user 아이디명칭 사용하교 isLogin을 true 로 바꿔서 로그인 우회 가능

    세션 쿠키
    - JSESSIONID	D76B8D3AC2D701C1F194B7735295C070
    - 실제 로그인 정보는 서버에 저장되어 있고,
    - 쿠키는 그 정보를 서버에서 찾아갈 수 있는 사물함 키와 같은 존재
    [브라우저]                          [서버]
    JSESSIONID	D7....5C070  --조회-->  session.store
                                         D7....5C070 → {loginMember: 동글이}

    요즘 쿠키는 누가 값을 봐도 누구인지, 비밀번호인지 전혀 알 수 없음

    Secure 옵션을 넣지 않은 쿠키여서 상대적으로 약한 세션 쿠키일 뿐
    예전 쿠키와는 다른 형태로 회원정보를 조회 입장권팔찌처럼 랜덤 문자열 형태로
    본인임을 저장하고, secure 쿠키는 추가적으로 회사에서 지정한 그날 그날의
    비밀번호 암호화 처리까지 넣어서 로그인 유지

    세션
    - 서버가 어떤 사용자를 기억하기 위해 만드는 임시 저장공간
    - 하나의 탭에서 로그인을 하면 다른 탭에서도 로그인이 될 수 있도록 유지하고,
    로그아웃을 하면 모든 탭에서도 로그아웃 처리


    서    버(세션저장소) 실제 로그인 정보(진짜데이터)
    브라우저(쿠      키) 그 정보를 찾아갈 수 있는 열쇠(세션ID)만 전달
                         세션ID는 로그인할 때 마다 매번 변경되어
                         클라이언트가 로그인 가능한 유효시간에만 사용할 수 있다.

    세션의 경우 보통 기본 일정 시간 30분으로 되어 있고,
    그 동안 로그인에 해당하는 요청이 없으면 자동으로 로그아웃 처리
    팔찌 유효기간이 만료되는 것 다시 로그인해서 새로운 팔찌 착용하여
    사이트를 돌아다녀야 한다.



     */

    /**
     * 마이페이지 - 조회만
     */
    @GetMapping("/mypage")
    public String mypageHtml(HttpSession session) {
        // TODO 1: 세션에서 loginMember 꺼내기
        Member loginMember = (Member) session.getAttribute("loginMember");

        // TODO 2: 로그인 안 되어있으면(null) "/login"으로 리다이렉트
        if (loginMember == null) return "redirect:/login";

        // 로그인 되어있으면 그냥 화면(mypage.html)만 보여주면 됨
        // (세션에 이미 loginMember가 있으니, html에서 ${session.loginMember} 로 바로 접근 가능)
        return "mypage";
    }
}
