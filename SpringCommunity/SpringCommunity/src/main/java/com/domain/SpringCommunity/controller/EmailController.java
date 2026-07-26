package com.domain.SpringCommunity.controller;

import com.domain.SpringCommunity.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController// @Controller + @ResponseBody 를 붙인 백엔드 API 상태로 사용함을 의미
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    /**
     * 인증번호 보내는 기능
     * /email/send 경로로 POST 요청을 보내면 이 메서드가 실행되도록 매핑
     * POST 를 쓰는 이유 : 단순 조회가 아니라 메일을 발송하는 동작이기 때문에
     *                     GET 조회가 아닌 특정 데이터 발송 이기 때문에
     *                     POST가 더 적절
     *
     * @param email     : 소비자가 작성한 본인 이메일을 html → javaScript 로 담아와 email 이라는 파라미터에 그대로 저장
     *                    예를 들어 /email/send?email=abc@email.com 요청 시 email 변수에 abc@email.com 이 담김
     *
     * emailService.인증번호발송(email);
     *                 : 실제 처리(랜덤 인증번호 생성 + 메일 발송 + 저장소에 저장)는
     *                  EmailService 가 담당하므로 컨트롤러는 그 메서드를 호출만 한다.
     *                  컨트롤러는 "누가 무슨 요청을 보냈는지" 만 받아서 서비스에 전달하는 역할만 하고,
     *                  실제 로직은 서비스에 맡기는 구조
     *
     * @return         : @RestController 이기 때문에 이 문자열을 화면 이름이 아니라, 그대로 응답body(데이터)
     *                  로 클라이언트에게 전달되며,
     *                  프론트엔드 자바스크립트(fetch)가 이 문자열을 받아서 alert 으로 보여주는 구조
     */
    @PostMapping("/email/send")
    public String 인증번호발송요청(@RequestParam String email) {
        emailService.인증번호발송(email);
        return "인증번호가 발송되었습니다.";
    }

    /**
     * 소비자가 입력한 인증번호와 자바에서 랜덤으로 보내진 인증번호가 일치하는지 확인하는 기능
     * /email/verify 경로로 오는 POST 요청을 처리하도록 매핑
     *
     * @param email html → javaScript → fetch로 사용자의 이메일과
     *
     * @param code  사용자가 입력한 인증번호 값을 각각 받아온다.
     *              예를 들어 /email/verify?email=abc@email.com&code=431890 와 같이 가져옴
     *
     * boolean result = emailService.인증번호확인(email, code);
     *               : 인증번호확인() 메서드를 호출해서, 저장된 인증번호와 사용자가 입력한 코드가 일치하는지
     *                  true / false 로 판정받는다.
     *
     * @return result ? "인증성공" : "인증실패";
     *          삼항연산자 기법      조건  ?  조건이 true일 경우 실행할 코드 : 조건이 false 일 경우 실행할 코드;
     *          result 가 true  이면 "인증성공"
     *                    false 이면 "인증실패"  를 소비자에게 반환
     *
     * 삼항연산자를 사용하지 않을 경우
     * if (emailService.인증번호확인(email, code)) {
     *     return "인증성공";
     * }
     * else {
     *     return "인증실패";
     * }
     */
    @PostMapping("/email/verify")
    public String 인증번호확인요청(@RequestParam String email, @RequestParam String code) {
        boolean result = emailService.인증번호확인(email, code);
        return result ? "인증성공" : "인증실패";
    }
}
