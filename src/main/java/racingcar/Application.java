package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        // 자동차 이름 입력받기
        String[] nameList = inputCarNames();

        // 시도할 횟수 입력받기
        int repeat = inputNumberOfRounds();

        // 객체 생성
        ArrayList<Car> cars = new ArrayList<>();
        for(String name: nameList) {
            cars.add(new Car(name));
        }

        // 경기 진행 & 각 시도별 결과 출력
        System.out.println("실행 결과");
        for (int i=0; i<repeat; i++) {
            executeRound(cars);
        }

        // 우승자 출력
        printWinner(cars);

    }



}
