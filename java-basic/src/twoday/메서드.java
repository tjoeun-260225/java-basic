package twoday;

public class 메서드 {
    // 필드 = 멤버 변수 = 속성 = 변수 = 인스턴스 변수
    private String name;
    private int age;

    // 이외 대부분은 전부다 메서드(= 함수 = 기능 안에 있는 일부 기능 표현법)
    // 생성자 - 특수 메서드
    // 게터세터 - 메서드
    // 개발자가 만든 모든 기능 - 메서드

    // 매개변수를 사용하지 않는 생성자
    public 메서드() {
    }

    // 메서드.java 안에 존재하는 모~든 필드에 데이터가 존재 해야하는 생성자
    // 소괄호 내부에 있는 변수 명칭은 private 으로 작성한 변수 명칭으로 맞출 필요는 없으나
    // 필드 명칭이 많으면 관리하기 힘들기 때문에 관례적으로
    // 위에서 선언한 필드이름 = 매개변수이름 을 맞추어 작성한다.
    public 메서드(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 필드 내에 내장되어 있는 데이터를 반환하여 전달하거나 사용하기 위한 기능
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    // 클라이언트가 작성한 데이터나 개발자가 커스텀한 데이터를 임시 보관하기 위한 기능
    // 데이터를 보관하기 위한 용도로 반환을 해야할 이유가 없기 때문에
    // void = 반환할 데이터 없음 처리를 해준다.
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    // 반환 데이터가 없는 void 메서드
    // void = return으로 전달할 데이터가 없으며, 실행을 하기 위한 기능
    public void 이메일중복확인기능(String 전달받은이메일) {
        // {} 내부에 중복확인기능에 해당하는 코드를 모두다 작성
        System.out.println("데이터베이스에 존재하는 이메일에서");
        System.out.println("클라이언트가 전달한 이메일이 존재하는지 확인");
        System.out.println("확인만 할 뿐 전달할 것이 없다.");
        // void를 사용하고 안하고 의 유무
    }

    public String 이메일중복확인결과(String 전달받은이메일){
        System.out.println("데이터베이스에 존재하는 이메일에서");
        System.out.println("클라이언트가 전달한 이메일이 존재하는지 확인");

        if(전달받은이메일.equals("db에 동일한 이메일 존재")){
            System.out.println("");
        } else {

        }
        return "동일한 이메일이 없습니다. 회원가입 가능합니다.";
    }











}
