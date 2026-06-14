package twoday.practice_one;

public class 실행하기 {
    public static void main(String[] args) {
        구글계정 계정1번 = new 구글계정("김철수","kimc@gamil.com","1234");
        계정1번.로그인();
        System.out.println("-".repeat(30)); // - 모양을 30개 만들기 수행
        유튜브 유튜브앱 = new 유튜브();
        유튜브앱.영상검색("자바 강의");
        유튜브앱.영상시청("자바 기초 1강");
        유튜브앱.좋아요();

        System.out.println("-".repeat(30));
        지메일 지메일앱 = new 지메일();
        지메일앱.메일보내기("su@gmail.com","안녕하세요");
        지메일앱.받은메일확인();
    }
}
