package com.domain.blog_website.model.entity;

import jakarta.persistence.*;

// DB에 테이블을 생성할 때
// CREATE TABLE example_table 과 같은 형태로 테이블이름을 지정해서 사용할 수 있다.
@Table(name = "example_table")
public class 엔티티 {
    /*
    @Id
    이 필드가 테이블의 기본키라고 선언하는 어노테이션
    모든 테이블 클래스에는 기본키가 지정되어 있는 컬럼이 하나씩 있어야 한다.
    기본키 = 각 행(row)을 구분하는 유일한 값 (중복 불가, null 불가 가 자동으로 세팅되므로)
                                              @Column 으로 지정하지 않아도 자동 설정된다.
    @GeneratedValue

    후보키
    - 기본키가 될 수 있는 자격을 가진 후보들
     테이블에서 행을 유일하게 구분할 수 있는 컬럼 조합

     한 테이블에서 기본키는 원칙적으로 1개만 지정

     기본키가 여러 개
     1) 후보 자체는 여러 개일 수 있지만, 그 중 하나만 개발자는 실제 기본키로 선택하여 사용

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        - 이 컬럼의 값을 누가 생성할지 지정하는 어노테이션
        IDENTITY 자동 생성 방식을 지정한다.
        AUTO_INCREMENT 와 동일한 형태로 사용되어 지며,
        만약 INSERT INTO 데이터를 추가할 때 자동 순번 매김이 아니라
        개발자가 지정한 형태의 순번매김의 경우 @GeneratedValue 를 사용하지 않으며,
        개발자가 만들어놓은 형태의 순번 매김을 따로 연결하여 사용해야 한다.
        연결해서 추가하는 방식은 service 로직에서 추가한다.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long 순번; //데이터가 추가될 때 알아서 DB 순번에 따라 번호를 기입한다.
    /*
    아래와 같이 순번_2 를 작성하는데는 문제가 없지만,
    실행할 때는 에러가 발생하며 동작하지 않는다.
    JPA/Hibernate 규칙 위반

    @EmbeddedId 나 @IdClass
    이 두가지를 상황에 따라 사용하면 필드에 @Id를 여러 번 붙이는게 허용
     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long 순번_2;

    // 우리는 데이터베이스에서 테이블을 생성할 때
    // 각 컬럼의    도메인    을 지정할 수 있다.
    // 각 컬럼의 범위/제한영역을 지정할 수 있다.
    /*
    자바에서 entity로 테이블을 생성할 때 각 컬럼의 도메인을 설정하는 방법
    @Column
    필드 위에 붙여서 그 필드가 만들어질 DB 컬럼의 세부 규칙을 정하는 어노테이션

    @Column 내에서 자주 쓰는 속성들
    속성                    의미                     예시
    name             자바에서 사용할 필드 이름과   name="post_title"
                     D  B에서 사용할 필드이름을
                     다르게 지정할 때 사용
    nullable         null 허용 여부(기본값 true)   nullable = false → 데이터 베이스에 속성 추가할 때
                                                   필수로 데이터가 존재해야하는 컬럼
    length           문자열 길이 제한(기본값255)   length = 100
    unique           컬럼 세로 한 줄에서           uniqute = true
                     중복값 허용 안 함
    columnDefinition SQL 타입 직접 지정            columnDefinition = "TEXT"
    updatable        수정 가능 여부                updatable = false

    DB 회사마다 다르게 설정하는가? YES
    위에 작성한 속성명칭을 각 sql 마다 다르게 작성될 일은 없다.
    위에 작성한 속성명칭은 JPA(자바표준)에서 지정하여 만든 속성이기 때문

    개발자 : nullable = false 라고 자바 코드 작성함

    Hibernate : DB 종류를 보고 알아서 SQL 문법에 맞게 번역을 해서 사용

    MySQL          NOT NULL
    Oracle         NOT NULL
    H2             NOT NULL
    PostgreSQL     NOT NULL

    와 같이 대부분의 속성이 같으나 columnDefinition 속성의 경우 DB 마다 다르게 세팅

    MySQL H2 PostgreSQL
    @Column(columnDefinition = "TEXT")    대략 6만 5천자

    Oracle 은 TEXT 타입이 없고, 대신 CLOB 을 사용한다.
    @Column(columnDefinition = "CLOB")

    MySQL 은 큰 텍스트 일 때 LONGTEXT 와 같이 사용하기도 한다.
    @Column(columnDefinition = "LONGTEXT")최대 4GB 42억자 까지 저장 가능

    length
    VARCHAR(100)처럼 번역되나, Oracle 의 경우 내부적으로 VARCHAR2로 바뀜
     */

    // 컬럼이름1번 컬럼의 경우 100자 제한이고, 제목이 비면 DB에 저장 불가
    @Column(nullable = false, length = 100)
    private String 컬럼이름1번;
    // 컬럼이름2번 컬럼의 경우 글자수 는 255로 기본값제한을 두는게 맞지만
    // TEXT 로 지정하는 순간 length = 255의 기본값 제한은 자동으로 해지되며
    // 최대 6만 5천자까지 지정 가능한 범위로 늘어나게 된다.
    // 빈값 금지
    // 컬럼 속성의 경우 TEXT 로 지정
    // 컬럼 속성을 지정하지 않으면, 데이터 타입에 따라 컬럼이 숫자형인지, 문자형인지 지정
    // 보통은 문자열 형태로 속성이 설정된다.
    @Column(nullable = false, columnDefinition = "TEXT")
    private String 컬럼이름2번;

    //  @Column 없을 때 기본값으로 지정되어지는 속성형태
    // 컬럼명 자바에서 설정한 변수이름을 그대로 사용
    // 타입 String 으로 지정되어 있기 때문에 varchar
    // nullable true unique false updatable true
    // 빈 값 허용    중복 허용     수정 가능
    private String 컬럼이름3번;
}
/*
    도메인
    - 상황에 따라 뜻이 조금씩 다르게 쓰이는 단어

    1. 데이터베이스에서의 도메인
     - 어떤 컬럼이 가질 수 있는 값의 범위 / 규칙

     예를 들어
        title   컬럼의 도메인 → 최대 100자인 문자열, 빈 값 허용 불가
        content 컬럼의 도메인 → 글자수가 굉장히 긴 텍스트 빈 값 허용 불가
        email   컬럼의 도메인 → @ .이 들어가야 하며, 중복 불가
        gender  컬럼의 도메인 → Y 또는 N만 들어갈 수 있음
        id      컬럼의 도메인 → 자동으로 순번이 증가하며, 기본키 지정

    2. 인터넷 도메인
     - www.google.com 같은 웹사이트 주소 이름
       IP주소(123,456,789) 대신에 사람이 기억하기 쉬운 이름을 붙인 것

    3. DDD 도메인 주도 설계의 도메인
     - 소프트웨어가 다루는 비즈니스 영역/업무 개념 그 자체
       쇼핑몰 웹사이트 → 주문 상품 결제 회원이 이 회사의 메인 도메인

    어떤 범위/ 영역을 나타낸다는 느낌이 정의되어 있는상태
    금융 도메인 지식이 있다 - 금융 도메인을 잘 안다.
     */