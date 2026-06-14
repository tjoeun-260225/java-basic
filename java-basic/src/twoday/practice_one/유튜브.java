package twoday.practice_one;

/*
클래스 '유튜브'은(는) abstract로 선언되거나
'유튜브기능'에서 추상 메서드 '영상검색(String)'을(를) 구현해야 합니다.

 */
// 유튜브 클래스는 유튜브기능 을 implements 코드 구해야한다.
public class 유튜브 implements 유튜브기능 {
    /*
    @Override : 어디서 물려받거나 작성되어 있는 명칭의 기능을 재정의하겠다 표기법
                작성하지 않아도 동작은 잘하나
                다른데에서 작성되어 있는 기능명칭을 현재 유튜브 자바 파일에서
                내부 {} 코드를 재구현한 것이다 표기하는 개발자들 간의 관례 표기법
     */
    @Override
    // interface 유튜브기능.java 에서 영상검색 기능 명칭이 존재하고 현재 파일에서 내부기능 다시 작성
    public void 영상검색(String 검색어) {
        System.out.println(검색어 + "를 검색합니다.");

    }

    @Override
    public void 영상시청(String 영상제목) {
        System.out.println(영상제목 + "를 시청합니다.");
    }

    @Override
    public void 좋아요() {
        System.out.println("좋아요를 눌렀습니다.");

    }
}
