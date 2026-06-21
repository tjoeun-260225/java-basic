package threeday;

import java.util.HashMap;
import java.util.Map;

/*
Map(HashMap) - 키-값 쌍 저장
List Set 은 값 하나만 저장하지만,
Map 은 이름표(Key) 내용(Value) 를 한 쌍으로 저장

자바에서 List, Set, Map 은 데이터베이스 개념과 거의 1:1 로 매칭된다.
Map의 Key = 데이터베이스의 Primary Key(기본키)

보통은 db에서 데이터를 꺼내와 변수내에 존재하는 데이터를 클라이언트에게
전달할 때 많이 사용하는 기법 중 하나
 */
public class 맵 {
    public static void main(String[] args) {
        // 1. Map 생성
        // 보통 Key 명칭은 String 형태로 되어 있다.
        // Key 데이터의 형태는 Integer, Float, String, Long 등
        //     다양한 형태로 존재할 수 있다.
        // Controller 에서 프론트엔드로 상태 전달할 때 많이 사용
        // 소비자가 로그인에 성공했다. 실패했다 와 같은 전달도 사용하기도 한다.
        Map<String, Integer> 점수 = new HashMap<>();

        // 2. 데이터 추가
        점수.put("이름",0); // 데이터베이스에서 가져올 데이터 명칭과 데이터를 작성

        // 나중에 특정인의 점수가 궁금하다 할 떄
        점수.get("이름"); // 특정인의 점수를 가져올 때 어떤식으로 가져올 것인지? 설정
        // 지금은 Map 형태로 get 데이터를 가져오겠다.

        // Map 의 경우 키-값 이라는 형태를 python javascript 이외 다수 언어에서
        // 사용하는 형태 표기법으로 Map 키-값 형태임을 인지해준 상태로 코딩을 하는 것이 좋다.
    }
}
