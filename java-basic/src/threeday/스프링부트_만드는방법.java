package threeday;

public class 스프링부트_만드는방법 {
    /*
    1. 인텔리제이를 사용하지 않을 때 가장 쉽게 만드는 방법
       start.spring.io 접속
       우리 회사 사양이나, 고객사가 요청한 사양에 맞추어 세팅
       Project
        - Maven           : 레거시 방법
        - Gradle - Groove : 최근 트랜드
      Language
        - Java            : 표준 Springboot 도구에서 많이 지향하는 언어
        - Kotiln or Groovey 와 같은 언어로도 스프링부트 도구를 사용할 수 있다.
      Springboot  도구의 버전 선택

        -           SNAPSHOT            : 업데이트와 버그를 개선하고 있는 버전
                                          좋은 업데이트를 위하여 스프링부트를 사랑하는 개발자들이
                                          적극 참여하길 바라는 버전

        -              M2               : 어느정도 완성 단계가 된 버전
                                           완벽하게 완성되기 직전 버전

        - 아무것도 붙지 않은 숫자 버전  : 업데이트가 모두 끝난 완성된 버전
                                          회사에서 실무적으로 프로젝트를 배포할 때
                                          아무것도 작성되지 않은 단순 숫자만 기입된 버전 사용
      Project Metadata
         Group         : 패키지 구조 보통은 회사 도메인을 거꾸로 작성
         Artifact      : 프로젝트 이름
         Package Name  : Group + Artifact 를 합쳐진 이름으로 자동 완성되나
                        개발자나 회사 니즈에 맞추어 수정가능하지만 그렇게 권장하진 않는다..

      Packaging        프로젝트를 완성한 후 하나의 프로그램 파일로 만들어 배포할 때
                       어떤 확장자로 만들 것인지 선택
        - Jar          : Springboot + Thymeleaf 형태의 템플릿 엔진을 사용할 때 주로 사용
                         자바 자체로 프로그램 만들 때 사용
        - War         : Springboot + jsp 형태의 템플릿 엔진을 사용할 때 주로 사용

       Configuration    환경 설정
        - Properties  : 레거시 방법
        - YAML        : 최근 트랜드

       Java
        - 17          : 안정된 버전
        - 21          : 최근 안정된 버전으로 각광받고 있는 자바 버전
        회사 상황에 맞추어 버전을 사용할 것으로 권장
        단독으로 새로운 사업을 하거나, 프로젝트 파트를 만들었을 때 많이 사용하는 버전
     */
}
