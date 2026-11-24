# Jedlik의 장난감 자동차

Exercism의 Java 트랙에 있는 Jedlik의 장난감 자동차에 오신 것을 환영해요.
테스트를 실행하거나 코드를 제출하는 데 도움이 필요하면 `HELP.md`를 확인해 봐요.
연습 문제를 풀다가 막히면 `HINTS.md`를 확인해 봐요. 그래도 먼저 그 내용 없이 풀어보도록 해요 :)

## Introduction

## 클래스

Java의 주요 객체 지향 구성 요소는 _클래스_로, 데이터(_필드_)와 동작(_메서드_)의 결합이에요.
클래스의 필드와 메서드를 _멤버_라고 해요.

멤버에 대한 접근은 접근 제어자로 제어할 수 있는데, 가장 흔히 쓰이는 두 가지는 다음과 같아요:

- `public`: 어떤 코드든 접근할 수 있어요 (제한 없음).
- `private`: 같은 클래스 안의 코드만 접근할 수 있어요.

클래스는 그 클래스의 인스턴스를 만들기 위한 템플릿이라고 생각하면 돼요.
클래스의 인스턴스(또는 _객체_)를 만들려면 `new` 키워드를 사용해요:

```java
class Car {
}

// Create two car instances
Car myCar = new Car();
Car yourCar = new Car();
```

필드에는 타입과 이름(카멜 케이스로 정의)이 있고, 클래스 안 어디에나 정의할 수 있어요 (관례상 파스칼 케이스로 표기해요):

```java
class Car {
    // Accessible by anyone
    public int weight;

    // Only accessible by code in this class
    private String color;
}
```

필드에는 선택적으로 초깃값을 지정할 수 있어요.
필드에 초깃값을 지정하지 _않으면_, 해당 타입의 기본값으로 설정돼요.
인스턴스의 필드 값은 점 표기법으로 접근하고 갱신할 수 있어요.

```java
class Car {
    // Will be set to specified value
    public int weight = 2500;

    // Will be set to default value (0)
    public int year;
}

Car newCar = new Car();
newCar.weight; // => 2500
newCar.year;   // => 0

// Update value of the field
newCar.year = 2018;
```

private 필드는 보통 메서드를 호출하는 부수 효과로 갱신돼요.
이런 메서드는 보통 아무 값도 반환하지 않는데, 이 경우 반환 타입은 `void`여야 해요:

```java
class CarImporter {
    private int carsImported;

    public void importCars(int numberOfCars)
    {
        // Update private field from public method
        carsImported = carsImported + numberOfCars;
    }
}
```

## Instructions

이 연습 문제에서는 돈을 모아서 드디어 장만하게 된 무선 조종 자동차를 가지고 놀아 봐요.

자동차는 처음에 배터리가 가득 찬(100%) 상태로 시작해요. 리모컨으로 자동차를 운전할 때마다 자동차는 20미터를 이동하고 배터리가 1퍼센트씩 줄어들어요.

무선 조종 자동차에는 두 가지 정보를 보여 주는 멋진 LED 디스플레이가 있어요:

- 주행한 총 거리는 `"Driven <METERS> meters"` 형식으로 표시돼요.
- 남은 배터리 잔량은 `"Battery at <PERCENTAGE>%"` 형식으로 표시돼요.

배터리가 0%가 되면 더 이상 자동차를 운전할 수 없고, 배터리 표시에는 `"Battery empty"`라는 문구가 나타나요.

여섯 개의 과제가 있는데, 각 과제에서는 무선 조종 자동차 인스턴스를 다뤄요.

## 1. 새 무선 조종 자동차 구입하기

새 무선 조종 자동차 인스턴스를 반환하는 (_static_) `JedliksToyCar.buy()` 메서드를 구현해요:

```java
JedliksToyCar car = JedliksToyCar.buy();
```

## 2. 주행 거리 표시하기

LED 디스플레이에 표시되는 대로 거리를 반환하는 `JedliksToyCar.distanceDisplay()` 메서드를 구현해요:

```java
JedliksToyCar car = JedliksToyCar.buy();
car.distanceDisplay();
// => "Driven 0 meters"
```

## 3. 배터리 잔량 표시하기

LED 디스플레이에 표시되는 대로 배터리 잔량을 반환하는 `JedliksToyCar.batteryDisplay()` 메서드를 구현해요:

```java
JedliksToyCar car = JedliksToyCar.buy();
car.batteryDisplay();
// => "Battery at 100%"
```

## 4. 운전할 때 주행 거리 갱신하기

주행 거리를 갱신하는 `JedliksToyCar.drive()` 메서드를 구현해요:

```java
JedliksToyCar car = JedliksToyCar.buy();
car.drive();
car.drive();
car.distanceDisplay();
// => "Driven 40 meters"
```

## 5. 운전할 때 배터리 잔량 갱신하기

배터리 잔량을 갱신하도록 `JedliksToyCar.drive()` 메서드를 수정해요:

```java
JedliksToyCar car = JedliksToyCar.buy();
car.drive();
car.drive();
car.batteryDisplay();
// => "Battery at 98%"
```

## 6. 배터리가 방전되면 운전하지 못하게 하기

배터리가 방전되었을 때(0%)에는 주행 거리도 늘리지 않고 배터리 잔량도 줄이지 않도록 `JedliksToyCar.drive()` 메서드를 수정해요:

```java
JedliksToyCar car = JedliksToyCar.buy();

// Drain the battery
// ...

car.distanceDisplay();
// => "Driven 2000 meters"

car.batteryDisplay();
// => "Battery empty"
```

## Source

### Created by

- @mikedamay

### Contributed to by

- @mirkoperillo