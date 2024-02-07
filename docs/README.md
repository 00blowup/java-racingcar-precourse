# 구현할 기능 목록

## Car 내부에 정의할 메소드
- getPosition: 최종 우승자를 출력하기 전에 Car 리스트를 position 값을 기준으로 정렬해야 함. 이때 position 값을 가져오기 위해 사용할 getter 메소드.
- goOrStop: 이번 시도에서 자신이 전진할지 여부를 Randoms API를 통해 결정한 뒤, position 값을 갱신하는 메소드.
- printMyself: 각 시도가 끝날 때마다 해당 시도의 결과를 출력해야 함. 이를 위해 Car가 자신의 현재 위치를 한 줄로 출력하는 메소드를 정의함.
- printName: 이름만 출력하는 메소드.

## Application.java에 정의할 메소드
- inputCarNames: 사용자로부터 자동차의 이름들을 입력받는 메소드.
- inputNumberOfRounds: 사용자로부터 시도 횟수를 입력받는 메소드.
- excuteRound: 한 번의 시도를 진행하는 메소드.
- printWinner: 모든 시도가 끝난 뒤, 우승자를 출력하는 메소드.