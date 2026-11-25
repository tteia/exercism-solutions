# 원격 조종 대회

Exercism의 Java 트랙에 있는 원격 조종 대회에 오신 것을 환영해요.
테스트를 실행하거나 코드를 제출하는 데 도움이 필요하면 `HELP.md`를 확인해 봐요.
연습 문제를 풀다가 막히면 `HINTS.md`를 확인해 봐요. 그래도 먼저 그 내용 없이 풀어보도록 해요 :)

## Introduction

## 인터페이스

인터페이스는 관련된 기능들을 정의하는 멤버들을 담고 있는 타입이에요.
인터페이스는 클래스를 사용하는 쪽과 구현을 분리해서, 서로 다른 여러 구현을 허용하거나 서식, 비교, 변환 같은 일반적인 동작을 지원할 수 있게 해줘요.

인터페이스의 문법은 클래스와 비슷하지만, 메서드가 시그니처로만 나타나고 본문은 제공되지 않아요.

```java
public interface Language {
    String getLanguageName();
    String speak();
}

public class ItalianTraveller implements Language, Cloneable {

    // from Language interface
    public String getLanguageName() {
        return "Italiano";
    }

    // from Language interface
    public String speak() {
        return "Ciao mondo";
    }

    // from Cloneable interface
    public Object clone() {
        ItalianTraveller it = new ItalianTraveller();
        return it;
    }
}
```

인터페이스에 정의된 모든 연산은 그 인터페이스를 구현하는 클래스가 반드시 구현해야 해요.

인터페이스는 보통 인스턴스 메서드를 담고 있어요.

자바 클래스 라이브러리에서 찾을 수 있는 인터페이스의 예로는, 위에서 살펴본 `Cloneable` 외에도 `Comparable<T>`가 있어요.
`Comparable<T>` 인터페이스는 컬렉션에서 기본적인 제네릭 정렬 순서가 필요할 때 구현할 수 있어요.

## Instructions

이 연습 문제에서는 무선 조종 자동차에 대한 작업을 좀 더 해볼 거예요.

실험용 자동차가 개발되었고, 시험 트랙이 양산형과 실험용 모델을 모두 다룰 수 있도록 수정되어야 해요.
두 종류의 자동차는 이미 만들어졌으니, 시험 트랙에서 두 자동차를 모두 처리할 방법을 찾아야 해요.

게다가 양산형 자동차가 이제 성과를 내기 시작했어요.
팀장은 양산형 자동차의 순위를 공개해서 경쟁심을 유지하고 싶어 해요.

## 1. 인터페이스 구현하기

`RemoteControlCar` 인터페이스에 두 개의 메서드를 추가해 주세요:

- 아무것도 반환하지 않는 `drive()`
- `int`를 반환하는 `getDistanceTravelled()`

그다음 `ProductionRemoteControlCar`와 `ExperimentalRemoteControlCar`가 `RemoteControlCar` 인터페이스를 구현하도록 해요.
여기에는 인터페이스가 요구하는 모든 메서드를 구현하는 것도 포함돼요.

## 2. 주행

`.drive()`를 호출할 때마다 자동차가 일정 거리를 이동해야 해요:

- `ProductionRemoteControlCar`는 10단위만큼 이동해요.
- `ExperimentalRemoteControlCar`는 20단위만큼 이동해요.

`.getDistanceTravelled()` 메서드는 자동차가 지금까지 이동한 총 거리를 단위 수로 반환해야 해요.

```java
ProductionRemoteControlCar prod = new ProductionRemoteControlCar();
prod.drive();
prod.getDistanceTravelled();
// => 10
        
ExperimentalRemoteControlCar exp = new ExperimentalRemoteControlCar();
exp.drive();
exp.getDistanceTravelled();
// => 20
```

## 3. 경주

`car`들이 `drive()`를 하도록 하는 `TestTrack.race(RemoteControlCar car)` 메서드를 구현해요.

```java
TestTrack.race(new ProductionRemoteControlCar());
TestTrack.race(new ExperimentalRemoteControlCar());
// this should execute without an exception being thrown
```

## 4. 양산형 자동차를 정렬할 수 있게 만들기

`ProductionRemoteControlCar` 클래스에 `Comparable<T>` 인터페이스를 구현해 주세요.
자동차의 기본 정렬 순서는 승리 횟수의 내림차순이어야 해요.

전달받은 자동차들을 승리 횟수 내림차순으로 정렬해서 반환하도록 정적 메서드 `TestTrack.getRankedCars()`를 구현해요.

```java
ProductionRemoteControlCar prc1 = new ProductionRemoteControlCar();
ProductionRemoteControlCar prc2 = new ProductionRemoteControlCar();
prc1.setNumberOfVictories(2);
prc2.setNumberOfVictories(3);
List<ProductionRemoteControlCar> unsortedCars = new ArrayList<>();
unsortedCars.add(prc1);
unsortedCars.add(prc2);
List<ProductionRemoteControlCar> rankings = TestTrack.getRankedCars(unsortedCars);
// => rankings.get(0) == prc2
// => rankings.get(1) == prc1
```

## Source

### Created by

- @mikedamay