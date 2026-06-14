package twoday;

/** javaDocs - 클래스나 기능을 설명할 때 사용하는 주석 구문
 * 추상클래스
 * - 추후에 구현해야하는 미완성된 기능이 하나라도 있으면 추상클래스
 * - 뽑을 추  모양 상 : 그럴듯한 형태만 존재하는 코드들
 *                      완벽하게 구현되지 않은 .java 파일
 *
 *  추상클래스 또한 추후에 구현해야할 기능이 존재하기 때문에
 *  private protected 와 같은 접근제어자 사용 불가
 *  public default    만 가능
 */
//     추후
//     구현해야할
//     기능이있는 자바파일
public abstract class 추상클래스 {
    private String 이름;
    private int 나이;
    // 기능1번은 반환해야할 데이터가 없는 완성된 기능
    // 맨 뒤에 {} 가 작성되어 있기 때문에 완성된 기능!
    public void 기능1번(){};

    // 기능2번은 abstract = 추후 구현해야할  기능이다 라는 표기
    public abstract void 기능2번();

    // 맨 뒤에 {} 가 붙어있으며, 자바 입장에서는 맨 뒤에 {} 가 있으면 이미 구현이 끝난
    // 완성된 기능으로 보기 때문에  public 다음에 abstract 를 붙이는 것이 옳지 않다는
    // 빨간 에러 발생
    //public abstract void 기능3번(){};

    // 나중에 기능4번을 구현할 때 반환 자료형으로 String 데이터를 반환하고
    // 매개변수로는 숫자데이터 하나 들어올 수 있게 기능을 구현하거라!
    public abstract String 기능4번(int a);

    // abstract 는 class + interface 혼합으로 상황에 따라 사용
}
/**
 * 자바는 C 와 C++ 영향을 크게 받은 언어
 * 문법 C 에서 객체지향 특성은 C++ 가져왔다.
 *
 * C++ 에서는 다중상속이 가능  상속을 여러 개 받다보니 버그와 복잡성이 생겼다.
 *
 * 1996년 자바 언어를 처음 만들 때부터
 * class interface abstract 가 존재
 * 제임스 고슬링 자바 만든이가 abstract 키워드 없이 순수하게 인터페이스와 클래스만
 * 하는 것이 좋았다. 얘기한 적이 있음
 *
 * class       C++ 에서 그대로 가져온 객체 단위
 * interface   C++ 다중상속 버그를 피하려고 만든 대안
 * abstract    Class 와 interface 중간 단계
 *
 * 보통은 class 와 interface 만 사용해도 충분하다.
 * */











