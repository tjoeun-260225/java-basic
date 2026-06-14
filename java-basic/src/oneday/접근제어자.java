package oneday;

/*
자바에서는 class 명칭 을 다수 작성할 수 있다.
한 자바 파일에 class 여러 개 작성은 가능하지만
이 중에서 public class 는 딱 1개만 가능
그게 파일명과 일치해야 한다.
 */
public class 접근제어자 {

    /*
    접근 제어자(Access Modifier)
    클래스, 변수, 메서드에 누가 접근할 수 있는가를 제한하는 키워드
                                  같은 폴더내
    oneday.접근제어자       같은 클래스  같은 패키지  자식 클래스  전체
    public               O             O            O        O
    protected            O             O            O        X
    (default)            O             O            X        X
    private              O             X            X        X


    protected - 다음주 진행
                객체 상속과 관련 이 있다.
                객체, 인스턴스, 메모리, 상속, 오버로딩 오버라이딩
                다음주에 깊히 들어갈 내용

    private   - 캡슐화 및 세부 심화 내용 다음주 진행
                객체와 관련이 있다.

     */


}



// 하나의 자바 파일에서는 public 은 하나의 명칭만 가능하며,
// 명칭은 파일이름.java 와 일치해야 한다.
//public class 이름_1번{
//
//}

// 아래와 같이 public 없는 class 는 여러 개 가능 하지만 권장하지는 않음
/* default */class 이름_2번 { }
// 제어자 'default'은(는) 허용되지 않습니다
// default class 이름_3번 { }
// default 는 기본이라하여 접근제어자에 아무것도 작성하지 않았을 경우
// default 접근제어자로 인식된다.