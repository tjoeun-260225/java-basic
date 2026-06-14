package oneday;

public class Variable_변수 {
    // 변수 = 데이터를 담는 공간의 명칭
    /*
    변수 종류
    분류        타입                  예시
    정수        byte,short,int,long   각 정수별로 작성할 수 있는 숫자 범위가 다르다.
                                      가장 많이 사용하는 타입 int long
    실수        float, double         3.14f, 3.14
                                      float 에 비하여 double 더 많은 실수 담을 수 있다.
    문자        char                  'A'  '' 안에 글자 하나씩만 들어갈 수 있다.
    논리        boolean               true, false
    (참조)      String                "안녕하세요"  자바에서는 "" 내에 글자들을 작성할 수 있다.
     */

    int age = 25; // 자바는 한 줄 코드 작성을 종료할 때 마다 ; 을 마침표처럼 맨 뒤에 붙여주어야 한다.
    double height = 175.5;
    String name = "홍길동";
    boolean isStudent = true;
    //    System.out.println()

    public static void main(String[] args) {
        int age = 25; // 자바는 한 줄 코드 작성을 종료할 때 마다 ; 을 마침표처럼 맨 뒤에 붙여주어야 한다.
        double height = 175.5;
        String name = "홍길동";
        boolean isStudent = true;
        // ctrl + d = 한 줄 복제
        System.out.println("나이 : " + age);
        System.out.println("키 : " + height);
        System.out.println("이름 : " + name);
        System.out.println("학생여부 : " + isStudent);
    }


}
