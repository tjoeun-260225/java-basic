package com.domain.SpringCommunity.dto;


import lombok.*;

@Data
/*
@Data 란?
아래 Getter ~ AllArgsConstructor 까지 모든 기능을 포함하고 있는 어노테이션
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
 */
public class Member {
    private String id;
    private String name;
    private String password;
    private String email;
    private String profileImage; // 저장된 프로필 이미지 파일이름
}
