package twoday;

public class AccountRun {
    // .java 파일에서 어느 코드를 실행할 것인지 표기하는 구문법
    // 자바는 아래와 같은 명칭으로 되어 있는 기능을 기준으로 실행
    public static void main(String[] args) {
        // ========================================================
        // 1. 기본 생성자 - 아무것도 없이 생성
        // ========================================================
        Account 국민은행 = new Account(); // ; 한 줄 코드 끝났다 마침표 기능
        System.out.println("=== 기본 생성자 ===");
        // 국민은행이라는 공간에 존재하는 이름과 잔액 확인하겠다.
        System.out.println(국민은행.getName());     // null
        System.out.println(국민은행.getBalance()); // 0

        // ========================================================
        // 2. setter 로 국민은행 내부에 값 추가하기
        //    나중에 html 프론트엔드에서 클라이언트가 작성한 데이터는
        //    setter 를 이용해서 java 코드 내부에 임시 보관을 한 후,
        //    DB에 넣기 전에 커스텀할 데이터가 존재한다면 커스텀을 진행하여
        //    DB에 추가할 것이다.
        //    set고객비밀번호() -> 암호화처리 -> db 저장
        // ========================================================
        국민은행.setName("홍길동");
        국민은행.setAccountNumber("110-1234-5678");
        국민은행.setBalance(100000);
        국민은행.setPassword("1234");
        // 국민은행이라는 공간 내부에 이름 계좌번호 잔액 비밀번호 추가한 상태
        System.out.println("=== setter로 값 넣은 후 ===");
        System.out.println(국민은행.getName());   // 홍길동
        System.out.println(국민은행.getAccountNumber()); // 110-1234-5678
        System.out.println(국민은행.getBalance()); // 100000
        System.out.println(국민은행.getPassword()); // 1234
        // ========================================================
        // 3. 일부 매개변수 생성자 - 이름만 넣고 생성
        // ========================================================
        // 농협은행 이라는 공간을 생성할 때
        // Account.java 에 존재하는 필드 메서드 기준으로 공간을 생성하고
        // new = 새롭게 만들겠다.
        // Account("김철수") 농협은행 이라는 공간을 만들 때 김철수 라는 명칭은 보유한 채로
        // 공간을 반드시 생성할 때 사용
        // 회원가입을 할 때 이름 생년월일 휴대폰번호 이메일은 반드시 포함해야 하지만
        // 배송지주소 나 기념일 의 경우 선택사항으로 포함할 경우에는
        // 아래와 같이 부분적으로 데이터가 필요한 공간을 설정
        /*
        농협은행이라는 데이터 공간은 아래 name 매개변수 생성자를 이용하여 만들어진 공간
        public Account(String name) {this.name = name;}
         */
        Account 농협은행 = new Account("김철수");
        System.out.println("=== 일부 매개변수가 존재하는 생성자 ===");
        System.out.println(농협은행.getName());   // 김철수 는 농협은행 생성할 때 부터 넣어준
        // 데이터
        System.out.println(농협은행.getBalance()); // 넣은 데이터가 없으므로 0
        // 숫자관련 데이터의 변수에 데이터가 없다면 0으로 표기
        // 숫자 이외 데이터의 변수에 데이터가 없다면 null =  없음으로 표기
        // 우리 은행은 비주류 은행이기 때문에 우선 이름으로 가입시키고,
        // 나머지 데이터는 가입시킨 후에 전달받자
        // 나머지는 setter 로 나중에 채우기
        농협은행.setAccountNumber("222-9999-0000");
        농협은행.setBalance(50000);
        농협은행.setPassword("5678");

        System.out.println(농협은행.getName());
        System.out.println(농협은행.getAccountNumber());
        System.out.println(농협은행.getBalance());
        System.out.println(농협은행.getPassword());
        // ========================================================
        // 4. All 매개변수 생성자 - Account 에 작성한 모든 필드 데이터를 추가한 상태에서
        //    데이터 공간 생성
        // ========================================================
        /*
        public Account(String name, String accountNumber, long balance, String password) {
            this.name = name;
            this.accountNumber = accountNumber;
            this.balance = balance;
            this.password = password;
        }
         */
        Account 신한은행 = new Account("이영희",
                "333-7777-1111",
                200000,
                "9999");

        System.out.println("=== 전체 매개변수 데이터를 포함하는 생성자 ===");
        System.out.println(신한은행.getName());         // 신한은행을 생성하며
        System.out.println(신한은행.getAccountNumber());// 넣어준 데이터를
        System.out.println(신한은행.getBalance());      // 조회할 수 있다.
        System.out.println(신한은행.getPassword());





    } // main() 닫는용 중괄호
} // AccountRun.java 닫는용 중괄호
