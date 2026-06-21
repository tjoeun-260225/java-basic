package threeday;

/*
tray-catch-finally
자바 프로그램 실행 중 예상치 못한 오류(예외)가 발생하면
프로그램이 비정상 종료된다.
이를 방지하기 위해 try-catch-finally 를 사용

try     - 예외가 발생할 수 있는 코드
catch   - 예외가 발생했을 때 처리하는 코드 (예외 종류별로 여러 개 작성 가능)
finally - 예외 발생 여부와 상관없이 항상 실행

throws, throw
throw   - 예외를 직접 발생시킬 때 사용
throws  - 메서드 선언부에서 이 메서드는 이런 예외를 던질 수 있다고 명시
            호출하는 쪽에서 처리하도록 위임

커스텀 예외 클래스
자바 기본 예외만으로 표현하기 어려운 상황이면 직접 예외 클래스를 만들 수 있다.
보통 RuntimeException 또는 Exception 을 상속받는다.
 */
public class 예외처리 {
    // try-catch-finally 예제 구문 기능
    public void method1() {
        try {
            int result = 10 / 0;
            System.out.println("나누기 한 숫자의 결과 : " + result);
        } catch (ArithmeticException e) {
            System.out.println("0으로는 숫자를 나눌 수 없습니다.");
            System.out.println("문제가 되는 구문 상황 :" + e);
        } finally {
            System.out.println("프로그램을 종료합니다.");

        }





        /*
        0으로 숫자를 나눌 수 없다는 예외 구문 발생
        Exception in thread "main" java.lang.ArithmeticException: / by zero
            at threeday.예외처리.method1(예외처리.java:25)
            at threeday.예외처리.main(예외처리.java:32)
         */
    }


    // catch 순서 규칙 예제 구문 기능
    public void method2(){
        try {
            // 문제가 발생할 구문을 시도할 것이다.
            // 문제가 발생하지 않고, 정상적으로 실행될 경우
            // catch 구문을 무시하게 되며,
            // 만일 아래에 finally 구문이 존재한다면 finally 구문을 실행한 후,
            // try{}catch{}finally{} 를 탈출하게 된다.
        } catch (ArithmeticException e){
            // catch 구문은 try를 작성했으면 반드시 최초 1회는 무조건 존재해야하며,
            // 개수는 무제한적으로 작성할 수 있다.
            // 캐치를 작성할 때 순서 중요
            // 가장 상세한 익셉션 구문부터 가장 광범위한 익셉션 구문 순으로 작성
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            // 개발자가 예기치 못한 문제를 e 변수에 담아
            // 개발자의 log 서버에 기록한 후, 개발자는 예외 상황을 해결하고,
            // 추후 프로젝트 업데이트 기간에 해결한 예외 상황을 포함하여 배포한다.
        } finally {
            // 작성해도 되고, 안해도 되지만
            // 작성할 경우, try-catch 맨 마지막 구문에 위치해야 하며,
            // try 이든 catch 이든 관계없이 실행한 결과 맨 마지막에 무조건 호출해야하는
            // 기능들 작성
            // 프로그램 종료나 자동저장과 같은 기능들을 작성

        }
    }

    // main 실행 구문 - 스프링부트 과정에서는 이렇게 작성할 일이 없으며
    // 실습 예제를 현재 코딩 페이지에서 일시적으로 실행하기 위하여 사용하는 기법
    public static void main(String[] args) {
        예외처리 ex = new 예외처리();
        ex.method1();
    }
}











