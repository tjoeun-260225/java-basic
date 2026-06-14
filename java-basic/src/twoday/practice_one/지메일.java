package twoday.practice_one;

public class 지메일 implements 지메일기능 {
    // 메일보내기 구현
    @Override
    public void 메일보내기(String 받는사람, String 내용) {
        System.out.println("받는사람 : " + 받는사람);
        System.out.println("내용 : " + 내용);
        System.out.println("전송완료!");
    }
    // 받은메일확인 구현
    @Override
    public void 받은메일확인() {
        System.out.println("메일을 받았습니다.");
    }
}