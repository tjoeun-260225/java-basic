package twoday.practice_one;

public class 구글계정 {
    //필드
    private String 이름;
    private String 이메일;
    private String 비밀번호;
    // 메서드 시작 =================================

    // 파라미터가 없어도 되는 기본 생성자
    public 구글계정() {
    }

    // 파라미터가 필수로 필요로 하는 생성자
    public 구글계정(String 이름, String 이메일, String 비밀번호) {
        this.이름 = 이름;
        this.이메일 = 이메일;
        this.비밀번호 = 비밀번호;
    }
    // 게터 세터 데이터 반환하고 데이터 임시 보관하는 메서드 생성
    public String get이름() {
        return 이름;
    }
    public void set이름(String 이름) {
        this.이름 = 이름;
    }
    public String get이메일() {
        return 이메일;
    }
    public void set이메일(String 이메일) {
        this.이메일 = 이메일;
    }
    public String get비밀번호() {
        return 비밀번호;
    }
    public void set비밀번호(String 비밀번호) {
        this.비밀번호 = 비밀번호;
    }

    //로그인 메서드
    public void 로그인(){
        System.out.println(이름 + "님이 구글에 로그인했습니다.");
    }
}
