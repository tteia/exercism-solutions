# Need for Speed

Exercism의 Java 트랙에 있는 Need for Speed에 오신 것을 환영해요.
테스트를 실행하거나 코드를 제출하는 데 도움이 필요하면 `HELP.md`를 확인해 봐요.
연습 문제를 풀다가 막히면 `HINTS.md`를 확인해 봐요. 그래도 먼저 그 내용 없이 풀어보도록 해요 :)

## Introduction

## 생성자

_클래스_의 인스턴스를 만들려면 `new` 연산자로 _생성자_를 호출해요.
생성자는 새로 만들어진 인스턴스를 초기화하는, 특별한 종류의 메서드예요.
생성자는 일반 메서드와 비슷하게 생겼지만, 반환 타입이 없고 이름이 클래스 이름과 같아요.

```java
class Library {
    private int books;

    public Library() {
        // Initialize the books field
        this.books = 10;
    }
}

// This will call the constructor
var library = new Library();
```

일반 메서드처럼 생성자도 매개변수를 가질 수 있어요.
생성자의 매개변수는 보통 나중에 접근할 수 있도록 (private) 필드에 저장하거나, 일회성 계산에 사용해요.
일반 메서드에 인자를 넘기듯이, 생성자에도 인자를 넘길 수 있어요.

```java
class Building {
    private int numberOfStories;
    private int totalHeight;

    public Building(int numberOfStories, double storyHeight) {
        this.numberOfStories = numberOfStories;
        this.totalHeight = numberOfStories * storyHeight;
    }
}

// Call a constructor with two arguments
var largeBuilding = new Building(55, 6.2);
```

## Instructions

이 연습 문제에서는 여러 종류의 무선 조종 자동차 사이의 경주를 구성해요. 각 자동차는 저마다의 속도와 배터리 소모 특성을 가지고 있어요.

자동차는 완충된(100%) 배터리로 시작해요. 리모컨으로 자동차를 운전할 때마다 자동차는 속도에 해당하는 미터만큼 이동하고, 남은 배터리 비율은 배터리 소모량만큼 줄어들어요.

자동차의 배터리가 배터리 소모 비율보다 낮으면 더 이상 자동차를 운전할 수 없어요.

각 경주 트랙은 저마다의 거리를 가지고 있어요. 자동차는 배터리가 다 닳기 전에 트랙을 완주할 수 있는지 확인하는 방식으로 시험해요.

여섯 개의 작업이 있고, 각 작업은 무선 조종 자동차 인스턴스를 다뤄요.

## 1. 무선 조종 자동차 만들기

`NeedForSpeed` 클래스의 생성자를 정의해서 무선 조종 자동차를 만들 수 있게 해요. 이 생성자는 자동차의 속도(미터)와 배터리 소모 비율을 두 개의 매개변수로 받아요(둘 다 `int` 타입이에요):

```java
int speed = 5;
int batteryDrain = 2;
var car = new NeedForSpeed(speed, batteryDrain);
```

## 2. 경주 트랙 만들기

`RaceTrack` 클래스의 생성자를 정의해서 경주 트랙을 만들 수 있게 해요. 이 생성자는 트랙의 거리(미터)를 유일한 매개변수로 받아요(`int` 타입이에요):

```java
int distance = 800;
var raceTrack = new RaceTrack(distance);
```

## 3. 자동차 운전하기

자동차의 속도를 기준으로 주행한 미터 수를 갱신하는 `NeedForSpeed.drive()` 메서드를 구현해요. 또한 자동차가 주행한 미터 수를 반환하는 `NeedForSpeed.distanceDriven()` 메서드도 구현해요:

```java
int speed = 5;
int batteryDrain = 2;
var car = new NeedForSpeed(speed, batteryDrain);
car.drive();

car.distanceDriven();
// => 5
```

## 4. 방전된 배터리 확인하기

자동차의 배터리 소모량을 기준으로 배터리를 소모하도록 `NeedForSpeed.drive()` 메서드를 수정해요. 또한 운전할 수 없을 만큼 배터리가 소모되었는지 알려 주는 `NeedForSpeed.batteryDrained()` 메서드도 구현해요:

```java
int speed = 5;
int batteryDrain = 2;
var car = new NeedForSpeed(speed, batteryDrain);
car.drive();

car.batteryDrained();
// => false
```

## 5. Nitro 무선 조종 자동차 만들기

가장 많이 팔린 무선 조종 자동차는 Nitro로, 배터리 소모가 4%이면서 최고 속도가 무려 50미터에 달해요. 이러한 종류의 자동차를 반환하는 (정적) `NeedForSpeed.nitro()` 메서드를 구현해요:

```java
var car = NeedForSpeed.nitro();
car.drive();
car.distanceDriven();
// => 50
```

## 6. 무선 조종 자동차가 경주를 완주할 수 있는지 확인하기

경주를 완주하려면 자동차가 경주의 거리를 주행할 수 있어야 해요. 즉, 결승선을 통과하기 전에 배터리가 다 닳지 않아야 해요. `NeedForSpeed` 인스턴스를 매개변수로 받아서 자동차가 경주를 완주할 수 있으면 `true`를 반환하고, 그렇지 않으면 `false`를 반환하는 `RaceTrack.canFinishRace()` 메서드를 구현해요:

```java
int speed = 5;
int batteryDrain = 2;
var car = new NeedForSpeed(speed, batteryDrain);

int distance1 = 100;
var race1 = new RaceTrack(distance1);

int distance2 = 300;
var race2 = new RaceTrack(distance2);

race1.canFinishRace(car);
// => true

race2.canFinishRace(car);
// => false
```

## Source

### Created by

- @ystromm

### Contributed to by

- @mirkoperillo