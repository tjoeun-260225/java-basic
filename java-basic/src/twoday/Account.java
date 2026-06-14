package twoday;
/**
 * 계좌 클래스
 * 추후 DB와 Java를 연결할 변수 명칭을 작성하는 클래스
 * */
public class Account {
    // 속성 (값) - DB 컬럼명칭과 맞추어 상호작용하여 데이터를 주고 받을 명칭
    // [캡슐화]
    // - 객체의 속성(필드) 직접 접근을 제한하는 것이 원칙
    // private = 현재 객체만 접근 가능한, 사적인, 개인적인)
    // 속성에 직접 접근을 할 수 없으므로 대신 간접 접근을 할 수 있는 기능을 작성해야 함
    private String name;                      // 이름(예금주)
    private String accountNumber;                //계좌번호
    private long balance;                // 잔액
    private String password;             // 비밀번호

    // private 으로 설정된 변수 명칭 = 속성 = 데이터가 저장되어 있는 공간의 명칭
    // class Account 를 탈출하는 순간 다른 자바 파일에서 직접적으로
    // 접근할 수 없는 명칭의 상태가 된다.

    // db에 저장되어 있는 이름-계좌번호-잔액-비밀번호
    // 를 가져오고, 저장하기 위해서는 어떻게 해야하는가?
    // 생성자와 게터 세터를 이용해서 접근

    // 현재는 우리가 생성자, 게터 세터를 직접적으로 작성하지만
    // 추후 스프링부트를 들어가게 되면 @생성자 @게터 @세터
    // 와 같이 어노테이션으로 자동 생성을 만들 것이기 때문에
    // 현재만 생성자와 게터세터들을 직접적으로 개발자가 코드 작성


    // 메서드 - 생성자
    // (기능) - 생성자 - 기본
    //          생성자 - 파라미터 요구하는 생성자
    // 인텔리제이에서 생성자 만드는 단축키 Alt _ Insert 를 키보드로 누르면
    // 자동 완성 해주는 목록들이 존재

    // 속성 = 변수 이름 이외에 모든 것 메서드(=기능)
    /*
    함수(=기능)
    함수 안에는 메서드 용어가 들어있다.

    함수 - 어떠한 클래스나 구현체 없이 단독으로 기능의 명칭을 사용할 때 쓰는 표기법

    메서드 - 어떠한 클래스나 구현체에 포함되어 있는 기능의 명칭을 사용할 때 쓰는 표기법

    자바에서는 거의 메서드 형태의 기능을 사용할 것

    - 이 두 차이점은 뒤에서 자바스크립트 설명할 때 뚜렷하게 보여질 것

    함수 사용
    기능이름()

    메서드 사용
    클래스이름.기능이름()

     */
    /*
    생성자 - Constructor
    객체를 생성 시 필드(=속성) 초기화 + 특정 기능 수행하는 일종의 메서드

    작성 규칙
    반환형 없음
    생성자 이름은 클래스이름과 반드시 동일

    기본 생성자 NoArgConstructor
    - 매개변수가 없는 형태
    - 생성자가 하나도 작성되지 않는 경우 자바에서 자동으로 생성
    - 매개변수가 존재하는 생성자가 존재하고
      기본 생성자가 존재하지 않은 경우 자동으로 기본생성자를 자바는 만들어주지 않는다.

    매개변수 생성자 AllArgConstructor
    - 매개변수가 모두 있는 형태
    - 자바에서 자동으로 생성하지 않는다.
    - 보통은 모든 변수를 참고하여 사용

    기본생성자이든.. 매개변수 생성자이든 개발자가 선택한 변수만 들어있는 매개변수 생성자이든
    개발자가 원하는 개발 방향으로 알아서 선택하여 사용하게 되어있다.
    모두다 사용하는 일은 거의 없다.
     */

    // 기본 생성자 - 처음에 생성할 때 아무런 값 없이 생성 가능
    public Account() {
    }

    // 일부 매개변수 생성자 - 처음에 생성할 때 무조건 클라이언트의 이름을 보유한 채로
    // 생성해야 한다.
    public Account(String name) {
        this.name = name;
    }

    /*
    소괄호 안에 작성하는 자료형과 변수이름을 매개변수 = 파라미터 라는 명칭을 사용
    매개변수  = 파라미터
    중  매 매
    개입할 개
    변  할 변
    셀     수
    중간에 개입한 데이터로 인하여 결과가 다르게 나타나는 것
     */


    // 매개변수 생성자 - 처음에 생성할 때 이름, 계좌번호, 잔액, 비밀번호를 모두 보유한 채로
    // 생성해야 한다.
    public Account(String name, String accountNumber, long balance, String password) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.password = password;
    }

    // 메서드 - 게터 세터
    // setter = DB에 데이터를 전달하기 전에 자바에서 일시적으로 데이터를 보유하고 있는
    //          기능                           데이터 저장 기능

    // getter = DB 나 클라이언트에게 전달받은 데이터를 어딘가에 전달하기 위하여
    //          반환할 데이터를 보유하는 기능  데이터 반환 기능


    // 책에서는 setter 를 가르칠 때
    // setter 내부에 if 문을 사용해서 가르침
    // setter 내부는 건들지 않는다.
    // 나중에는 lombok 이라는 회사에서 만든 @setter 를 이용해서 처리하기 때문에
    // set변수이름 으로 시작하는 코드 내부를 건들일 없다.
    // Alt + Insert 한 채로 그대로 유지할 것
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public long getBalance() {
        return balance;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
