package threeday;

import java.util.HashSet;
import java.util.Set;

/*
List 와 비슷하게 값을 모아두지만 중복 불가
같은 값을 넣으면 무시
Lotte 번호 생성과 같은 로직에서 주로 사용
같은 데이터가 해당 공간 내에 존재하는지 확인하고,
중복 없이 데이터를 존재하게 만들 때 주로 사용
데이터 순서가 없다.
데이터를 사과 먼저넣고 바나나 넣고 딸기를 넣어도
바나나 가 먼저 나오고 딸기나오고 사과가 나올 수 있다.

보통 - 프론트엔드에서 중복처리와 같은 코드 작업을 진행하고, 데이터가 들어오는 경우도 있기
       때문에 상황에 따라 Set 사용
       setter 의 set 과는 다른 것
       setter 의 set = 임시 저장
       Set = 중복없이 데이터 순서 무작위하게 저장
 */
public class 셋 {
    public static void main(String[] args) {
        Set<String> 과일바구니 = new HashSet<>();

        과일바구니.add("사과");
        과일바구니.add("바나나");
        과일바구니.add("사과");

        System.out.println(과일바구니); // [사과, 바나나]
    }
}
