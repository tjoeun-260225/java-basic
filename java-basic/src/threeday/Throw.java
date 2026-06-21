package threeday;

public class Throw {
    public void checkAge(int age) throws Exception {
        if(age < 0) {
            // throw : 실제로 예외를 던지는 부분
            throw new Exception("나이는 0 이상이어야 합니다.");
        }
        System.out.println("정상적인 나이입니다 : " + age);
    }
}
