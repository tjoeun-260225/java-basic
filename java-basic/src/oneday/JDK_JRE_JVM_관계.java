package oneday;

/*
JDK / JRE / JVM
- 자바를 실행 / 개발하는 도구 구조
- JDK  : Java Development Kit = 자바 개발 도구함
         JVM 과 JRE 전체를 포함하면서 개발도구까지 추가된 것

- JRE  : JVM + Java Class Library + Utilities 합친 것
         자바로 만들어진 프로그램을 실행만 할 때 필요

- JVM  : 자바 코드를 실제로 실행하는 가상 머신
         윈도우, 맥, 리눅스 등 JVM 이 중간에서 컴퓨터에 맞도록
         코드 실행을 도와주기 때문에 운영체제에 상관 없이 자바 코드 실행

개발자 PC : JDK 설치
            코드를 직접 짜는 개발자는 JDK 설치
            javac로 컴파일하고, 인텔리제이나 vscode, 이클립스 같은 IDE도
            JDK를 바라보고 동작
            자바 언어 안에 있는 도구를 이용해서 코딩 개발 시작

서버(운영 서버) : JRE만 설치
            실제 서비스가 돌아가는 AWS, 카페24 같은 서버에서는 JRE만 설치
            서버는 코드를 새로 짜는게 아니라 이미 만들어진 자바 프로그램만
            실행하면 되기 때문에 한결 가벼운 JRE만 설치하기도 하나,
            요즘에는 서버에도 JDK를 통째로 올려서 사용하는 경우 존재
            클라우드 환경에서는 용량 차이가 크게 문제되지 않는 세상이
            되었기 때문
            Docker / 배포 환경 - JRE 나 JDK 이미지

일반 사용자 PC : JRE
                회사 내부에서 자바로 만든 프로그램(공인인증서 시스템, 사내 ERP)을
                직원들이 사용할 때 JRE 정도만 설치시킴
                개발 하지 않고 실행만 할 경우

우리는 거의 JDK 환경을 설치한다 보는것이 바람직하다.

SE / EE / ME
- 어떤 용도의 자바인가
Java SE (Standard Edition)
- 가장 기본이 되는 자바 JDK21 을 설치했다 하면 SE 버전 설치

Java EE (Enterprise Edition)
- SE를 기반으로 기업용 대규모 서버 개발에 필요한 기능을 추가한 버전
- 지금은 이름이 Jakarta EE 로 변경되었다.
- 나중에 배울 SpringBoot 는 이 위에서 다수 작동한다.

Java ME (Micro Edition)
- SE  기능을 축소한 경량 버전
- 스마트 워치, IoT기기, 구형 피처폰 같은 메모리가 적은 소형 기기 사용
- 요즘에는 거의 사용 안함

개발자는
JDK 와 SE 또는 EE 를 설치하는데 대부분
JDK SE 면 어지간한 웹프로젝트 가능
 */
public class JDK_JRE_JVM_관계 {
}
