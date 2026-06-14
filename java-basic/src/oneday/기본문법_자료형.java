package oneday;

public class 기본문법_자료형 {
    /*
    public static void main(String[] args){
       1      2    3     4     5       6

    1. public - oneday.접근제어자
        누구나 이 기능을 호출할 수 있게 공개 모드
        JVM(자바 실행기)이 외부에서 프로그램을 시작할 때 main 이라고 적혀있는
        기능을 찾아서 호출한다.
        main 기능이 private(비공개모드) 로 되어 있으면 JVM이 찾을 수 없다.
        그래서 나 이코드들 실행하겠어요~ 하는 코드들은 모두
        main 에 작성해주는 것이 좋다.

    2. static - 객체 없이 실행 가능 (= 어떠한 호출 도움 없이 항시 실행가능)
        자바는 어디에서 어떻게 실행하겠다 와 같은 형태로 코드 작성
        static 으로 되어 있는 변수공간의 명칭이나 기능명칭은
        new 를 생성하지 않아도 항시 사용할 수 있는 형태로 존재

    3. void - 반환값 없음
        자바는 내가 이 기능을 실행하고 나서 어떻게 결과를 만들어 내겠다.
        와 같이 처음에 기능을 만들고 작성할 때 결과 유무를 표기해야한다.

        void / 자료형으로 결과를 표기할 수 있는데,
        void 같은 경우 이 기능을 수행한 다음에 데이터를 반환할 것이 없음 표기

    4. main - 메서드 이름 (메서드 = 기능 = 함수)
        단순히 메인기능 과 같이 기능의 명칭일 뿐
        Java JVM 팀에서 main 이라는 이름이 작성되어 있는 기능은
        프로젝트 전체에서 코드를 수행하는 공간의 명칭으로 공식 지정
        프로젝트를 실행하는 기능의 명칭은 main 설정

    5. String[] args - 실행 시 외부에 넘겨주는 값
        처음에는 보통 거의 빈 배열로 실행하며,
        개발 상황에 따라 값을 추가해주기는 하나 관례상 String[] args 형태로 작성

    6. args - arguments (인자)의 줄임말
       특정 데이터를 주고 받음이 필요할 때 사용

     */

    // 단순히 자바 코딩을 공부할 때는 반드시
    // 아래 public static void main(String[] args){ }
    // 코드 내에 작성해야 하며, 반드시 중괄호 내부에 코드 기입
    public static void main(String[] args) {
        // 정수형  코드는 정수를 0부터 셂
        // 0 ~ 127 = 총 128개
        byte b = 127;        // -128 ~ 127
        short s = 32767;    // -32.768 ~ 32.767
        int i = 21000000;           // 약 -21억 ~ 21 억(가장 많이 사용 됨)
        long l = 999999L;           // 매우 큰 수, 끝에 L 붙임 큰 수가 들어감 표기
        // 실수형
        float f = 3.14f;           // 끝에 f 붙임, 정밀도 낮음 그렇게까지 큰 실수를 작성할
                                   // 일이 없음을 데이터로서 표기
        double d = 3.14159265;     // 정밀도 높음 (가장 많이 사용)
        // 문자형
        char c_1 = 'A';            // 홀따옴표, 글자 딱 1개만
        // char c_2 = "A";         // char 자리에 " 쌍따옴표 작성하면 에러
        // 논리형
        boolean isAdult = true;    // true / false 만 가능
        // 문자열 (참조형)
        // int 와 double 같은 형태는 크기를 지정해놓은 예약어 기본형 → 소문자
        // String 의 경우 글자 수가 제각각이기 때문에 기본형으로 두기는 그렇고
        // 클래스로 만든 대문자 형태로 사용하자!
        // 보통 자바에서 대문자 시작 = 클래스 (누가 만들어놓은 코딩 자바 파일)
        // String 자바 개발팀이 만든 클래스다. 표기

        // int byt short double float boolean char 의 경우
        // primitive 값 자체를 저장하는 기본형

        // String    의 경우
        // reference 데이터 위치 주소를 저장하는 참조형

        // String 은 자바 개발자만의 창조 사상이 담겨져 있다...

        String name = "홍길동";    // 쌍따옴표, 여러 글자 가능

        // sout 와 같은 단축키는 인텔리제이에서 만든다음 개발자에게 제공
        System.out.println("byte : " + b);
        System.out.println("int : " + i);
        System.out.println("double : " + d);
        System.out.println("char : " + c_1);
        System.out.println("boolean : " + isAdult);
        System.out.println("String : " + name);
        /*
        byte : 127
        int : 21000000
        double : 3.14159265
        char : A
        boolean : true
        String : 홍길동
         */
        // 200 이라는 숫자가 이상하게 변질되어도 좋으니 굳이 b_2 안에 넣겠다.

        byte b_2 = (byte) 200;  // byte 127까지만 담을 수 있는 데이터 공간에
                          // 그 이상의 숫자를 넣을 때 발생하는 문제

        // 이런식으로 값을 이상하게 변형하면서 코딩을 할 일은 거의 없다.
        /*
        리터럴(Literal)
        - 코드에 직접 쓴 값 그 자체

        앞에다가 byte 를 작성하든 short 를 작성하든 long 을 작성하든
        리터럴 숫자는 보통 int 가 기본값

        앞에다가 float 을 작성하든 double 을 작성하든
        실수 리터럴 숫자는 보통 long 으로 기본값 세팅되어 있다.


         */
    }
}
