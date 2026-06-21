package threeday;

public class Main {
    public static void main(String[] args) {
        Throw t = new Throw(); // t 라는 공간에 Throw 형태로 형성

        try{
            t.checkAge(20);
            t.checkAge(-5);
        } catch (Exception e) {
            // 프로그램을 중지하거나 종료되지 않도록
            // 예외발생으로 메세지를 넘겨 처리
            // 회사에서는 System 구문보다는 log 사용
            // log - 실시간으로 특정 파일에 소비자가 접속~퇴장하는 것 까지
            // 모든 것을 기록할 수 있고, System 구문보다
            // 메모리를 적게 사용하고, 속도가 빠르다.

            // log  = 기록하다
            // blog = Web log = 처음에는 인터넷에서 하는 기록
            // vlog = video log = 비디오로 기록한다.
            // set log = set = 저장 log 기록 요즘 sns 유행하는 기록 어플
            System.out.println("예외 발생 : " + e.getMessage());
        }

        /*
        python의 경우 try-catch-finally 구문에서
        try-finally 를 작성한다면 catch생략가능
        자바는 불가!!!!

        자바는 무조건 try-catch 는 작성해주어야 한다.
        finally {}
         */


    }
}
