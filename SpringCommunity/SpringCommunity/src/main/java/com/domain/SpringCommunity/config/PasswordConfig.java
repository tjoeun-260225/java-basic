package com.domain.SpringCommunity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
config 폴더
프로젝트에 필요한 세팅 설정을 해주는 폴더

스프링부트 개발자가 만들어놓은 비밀번호 암호화 처리 기능을
사용하기 위하여 세팅
 */
@Configuration
public class PasswordConfig {
    // 매번 비밀번호 암호화할 때 마다
    // new BCryptPasswordEncoder() 객체를 생성하기 번거로우니
    // PasswordConfig 에서 new BCryptPasswordEncoder
    // 객체를 생성하여 사용
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
}
