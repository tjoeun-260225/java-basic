package oneday;

public class 기본문법_연산자 {
    // main 엔터 인텔리제이에서 자동으로 메인 기능 만들어줌
    public static void main(String[] args) {

        // 산술 연산자
        int a = 10;
        int b = 3;
        // ctrl + alt + l = 자동 줄 정렬 코드 가독성좋게 다듬기
        System.out.println(a + b);  // 더하기
        System.out.println(a - b);  // 빼기
        System.out.println(a * b);  // 곱하기
        System.out.println(a / b);  // 나누기에서 몫 정수만 살려두고 소수점 아래 모두 버리기
        System.out.println(a % b);  // 나누기에서 몫 정수를 제거하고 소수점 숫자들만 표기

        // 증감연산자
        int x = 5;
        x++; // x = x + 1 과 동일 x = 6
        int y = 5;
        ++y; // y에 y + 1 과 동일 y = 6

        int s = 5;
        int c = s++;
        // 1번 아! c 에게 s에 담겨져 있는 5를 줘야겠다.
        // 2번 이제 s = 5 에다가 +1을 해야겠다.

        // 순서 : 일단 c에 s 를 담는다. 그 다음에 s 에 +1 을 한다.
        // 결과 : c = 5 , s = 6


        int t = 5;
        int d = ++t;
        // 1번 오~~ t 에게 +1 해야지~! t는 이제 6이야!
        // 2번 6이 된 t를 d 에 담아 줘야겠다.

        // 순서 : 우선 t에 +1 을 진행한다. 그 다음에 d 에다가 +1이 된 t의 값을 제공한다.
        // 결과 : t = 6, d = 6

        // 증감 연산자
        int z = 10;
        z--;  // z 값에 -1 을 한 것과 같다.
        --z;  // z 값에 -1 을 한 것과 같다.
        z++;  // z 값에 +1 을 한 것과 같다.
        ++z;  // z 값에 +1 을 한 것과 같다.
        // 단독으로 작성할 때는 상관 없으나 +1 또는 -1 이 된 데이터를 가지고
        // 다른 변수에 데이터를 추가하여 무언가를 작업할 때는 전위 후위에 따른
        // 결과가 달라짐이 발생한다.

        // 비교 연산자(결과는 항상 boolean 형태로 제공)
        /*
        int a = 10;
        int b = 3;
         */
        System.out.println(a > b); // a에 들어있는 숫자가 b보다 큰 것이 맞으므로 true
        System.out.println(a < b); // a에 들어있는 숫자가 b보다 작은 것이 아니므로 false
        System.out.println(a >= 10); // a에 들어있는 숫자가 10보다 크거나 같은게 맞으므로 true
        System.out.println(a <= 9); // a에 들어있는 숫자가 10보다 작거나 같은게 아니므로 false
        System.out.println(a == 10); // a에 들어있는 숫자가 10과 같은게 맞다면 true
        System.out.println(a != 8); // a에 들어있는 숫자가 10과 다른게 사실이라면 true

        // = 는 대입  == 는 비교
        // = 영어로 이퀄 equal  == 영어로 이퀄즈 equals

        // 논리 연산자
        boolean t_2 = true;
        boolean f_2 = false;
        //         t_2              &&              f_2
        //       여기도 true    양쪽모두        여기도 true   일 때 결과가 true이다.
        System.out.println(t_2 && f_2); // 양쪽모두 결과 true 이어야지 true
        // 만 20살이 넘었고, 남자이면 입영통지서를 발송한다.
        System.out.println(t_2 || f_2); // 둘 중 하나만 true 여도 ok
        // 전자신분증이 있거나 여권이 있으면 본인확인 true
        System.out.println(!t_2);
        // true 를 false 로 변경해버리는 표기법
    }


}
