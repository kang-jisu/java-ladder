# 사다리 게임

## 기능 요구사항

- 사다리 입력
    - 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다.
    - 사람 이름은 쉼표(,)를 기준으로 구분한다.
    - 최대 사다리 높이를 입력 받는다.
    - 실행 결과를 입력 받는다. (결과는 쉼표(,)로 구분한다.)
        ex) 꽝,5000,꽝,3000

- 사다리 생성
    - 사람 입력 수 만큼, 라인(Line)이 생성된다.
    - 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
        - |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
    - 라인의 좌표 값에 선이 있는지 유무를 판단한다.
        - 라인의 좌표 값에 선이 있는 경우 추가로 선을 생성할 수 없다. (겹치지 않도록 한다.)
        - 라인의 좌표 값에 선이 없는 경우 추가로 선을 생성할 수도 있고, 생성하지 않을 수도 있다. (랜덤)
    - 사다리 높이 만큼 라인들(Lines)이 생성되며 서로 다른 라인들에 대한 제약은 없다.
    
- 사다리 결과
    - 한줄에 대한 위치 구하기
        - 1) 가장 왼쪽인 경우 왼쪽으로 이동 못함
        - 2) 가장 오른쪽인 경우 오른쪽으로 이동 못함
        - 3) 현재 상태가 false 이고 오른쪽의 결과가 true 인 경우 한칸 오른쪽으로 이동
        - 4) 현재 상태가 true 이고 왼쪽의 결과가 false 인 경우 한칸 왼쪽으로 이동
        - 5) 그 외에는 제자리

- 사다리 출력
    - 사다리를 출력할 때 사람 이름도 같이 출력한다.
    - 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
    - 사다리 실행 결과를 출력한다.
        - 개인별 이름을 입력하면 개인별 결과를 출력
        - all을 입력하면 전체 참여자의 실행 결과를 출력

## 기능 목록

- LadderApplication : 사다리 게임 수행
- ui
    - InputView
        - 참여할 사람 이름 입력
        - 실행 결과 입력
        - 최대 사다리 높이 갯수 입력
        - 결과를 보고 싶은 사람 입력
    - ResultView
        - 사다리 결과 출력
        - 사람에 대한 결과 출력
- controller : 사다리 애플리케이션 컨트롤러
    - 사다리 생성
    - 사다리 결과 반환
- service : 사다리 결과 수행
- domain
    - Line : 사다리 한줄의 결과 (Point의 일급컬렉션)
    - Ladder : 사다리 전체의 결과 (Line의 일급컬렉션)
    - People : 참가자들 (Person의 일급컬렉션)
    - ExecutionResults : 션사다리 전체 결과 (ExecutionResult 일급컬렉)
    - LadderResults : 참가자와 사다리 결과 맵핑

    - value(VO)
        - Direction : 사다리 방향 규칙
        - Person : 게임 참가자
        - Point : 사다리 지점
        - ExecutionResult : 사다리 결과
- strategy
    - 사다리 생성 전략 (현재는 랜덤만 있음)
