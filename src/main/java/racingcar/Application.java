package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static final Comparator<Car> CAR_COMPARATOR = new Comparator<Car>() {
        @Override
        public int compare(Car car1, Car car2) {
            if (car1.getPosition() < car2.getPosition()) return 1;
            return -1;
        }
    };

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
        System.out.println();
        System.out.println("실행 결과");
        for (int i=0; i<repeat; i++) {
            executeRound(cars);
        }

        // 우승자 출력
        printWinner(cars);

    }

    // 자동차 이름을 입력받는 메소드
    static String[] inputCarNames () {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] nameList = {};

        while(true) {
            nameList = Console.readLine().split(",");

            boolean validCheck = true;
            for(String name: nameList) {
                if(name.length()>5) {
                    System.out.println("[ERROR] 이름은 5자 이하여야 합니다.");
                    validCheck = false;
                }
            }
            if(validCheck) break;
        }

        return nameList;
    }

    static int inputNumberOfRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        int repeat = 0;
        while(true) {
            String input = Console.readLine();

            try {
                repeat = Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
                continue;
            } catch (Exception e) {
                System.out.println("[ERROR] " + e.getMessage());
                continue;
            }
            if(repeat<=0) {
                System.out.println("[ERROR] 시도 횟수는 1 이상의 정수여야 한다.");
                continue;
            }
            break;
        }
        return repeat;
    }

    static void executeRound(ArrayList<Car> cars) {
        for (Car car: cars) {
            car.goOrStop();
            car.printMyself();
        }
        System.out.println();
    }

    static void printWinner(ArrayList<Car> cars) {
        // position을 기준으로 내림차순 정렬
        cars.sort(CAR_COMPARATOR);

        System.out.print("최종 우승자 : ");
        // 1위 중 첫 순서로 정렬된 자동차의 이름 출력
        int highScore = cars.get(0).getPosition();  // 1위의 position
        cars.get(0).printName();
        // 나머지 공동 1위의 이름 출력
        for(int i=1; i<cars.size(); i++) {
            Car thisCar = cars.get(i);
            if(thisCar.getPosition() != highScore) break;
            System.out.print(", ");
            thisCar.printName();
        }
    }


}
