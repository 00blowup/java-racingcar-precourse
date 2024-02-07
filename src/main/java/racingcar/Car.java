package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    // 필드
    private final String name;
    private int position = 0;

    // 생성자
    public Car(String name) {
        this.name = name;
    }

    /*
    이 아래로는 메소드
     */

    // position 값을 리턴하는 메소드
    public int getPosition() {
        return position;
    }

    // 전진 여부를 결정한 뒤 위치 값을 갱신하는 메소드
    public void goOrStop() {
        if(Randoms.pickNumberInRange(0,9)>=4) position++;
    }

    // 본인의 현재 위치를 "name : ---"와 같은 형태로 출력하는 메소드
    public void printMyself() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" : ");
        for(int i=0; i<position; i++) sb.append("-");
        System.out.println(sb);
    }

    // name 값을 출력하는 메소드
    public void printName() {
        System.out.print(name);
    }
}
