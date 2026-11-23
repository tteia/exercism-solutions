# 라자냐 만들기

Exercism의 Java 트랙에 있는 라자냐 만들기에 오신 것을 환영해요.
테스트를 실행하거나 코드를 제출하는 데 도움이 필요하면 `HELP.md`를 확인해 봐요.
연습 문제를 풀다가 막히면 `HINTS.md`를 확인해 봐요. 그래도 먼저 그 내용 없이 풀어보도록 해요 :)

## Introduction

## 기초

Java는 정적 타입 언어예요. 즉, 변수의 타입이 컴파일 시점에 정해져요.
이름에 값을 할당하는 것을 변수를 정의한다고 해요.
변수는 타입을 명시적으로 지정해서 정의해요.

```java
int explicitVar = 10;
```

변수의 값은 `=` 연산자로 갱신해요.
여기서 `=`는 수학적인 등호를 뜻하지 않아요.
그냥 변수에 값을 할당할 뿐이에요.
한 번 정의된 변수의 타입은 절대 바뀌지 않아요.

```java
int count = 1; // Assign initial value
count = 2;     // Update to new value

// Compiler error when assigning a different type
// count = false;
```

Java는 [객체 지향 언어][object-oriented-programming]이고, 모든 함수를 _클래스_ 안에 정의해야 해요.
클래스를 정의할 때는 `class` 키워드를 사용해요.

```java
class Calculator {
    // ...
}
```

클래스 안에 있는 함수를 _메서드_라고 해요.
메서드는 매개변수를 하나도 갖지 않거나 여러 개 가질 수 있어요.
모든 매개변수는 타입을 명시해야 하고, 매개변수에는 타입 추론이 없어요.
마찬가지로 반환 타입도 명시해야 해요.
메서드에서 값을 반환할 때는 `return` 키워드를 사용해요.
다른 클래스에서 메서드를 호출할 수 있게 하려면 `public` 접근 제한자를 붙여야 해요.

```java
class Calculator {
    public int add(int x, int y) {
        return x + y;
    }
}
```

메서드를 호출할 때는 클래스와 메서드 이름을 지정하고, 메서드의 각 매개변수에 맞는 인자를 전달해요.

```java
int sum = new Calculator().add(1, 2);  // here the  "add" method has been called to perform the task of addition
```

Java에서 스코프는 `{`와 `}` 문자 사이로 정의돼요.

Java는 두 가지 종류의 주석을 지원해요.
한 줄 주석은 `//`로 시작하고, 여러 줄 주석은 `/*`와 `*/` 사이에 넣어요.

[object-oriented-programming]: https://docs.oracle.com/javase/tutorial/java/javaOO/index.html

## Instructions

이 연습 문제에서는 좋아하는 요리책을 보며 근사한 라자냐를 만들 수 있도록 도와주는 코드를 작성해요.

라자냐를 만드는 데 걸리는 시간과 관련된 네 가지 과제가 있어요.

## 1. 오븐 예상 시간을 분 단위로 정의해요

매개변수를 받지 않고, 라자냐가 오븐에 있어야 하는 시간(분)을 반환하는 `expectedMinutesInOven()` 메서드를 정의해요. 요리책에 따르면 예상 오븐 시간은 40분이에요:

```java
Lasagna lasagna = new Lasagna();
lasagna.expectedMinutesInOven();
// => 40
```

## 2. 남은 오븐 시간을 분 단위로 계산해요

오븐에 실제로 넣어 둔 시간(분)을 매개변수로 받아, 이전 과제에서 구한 예상 오븐 시간을 기준으로 라자냐가 오븐에 더 있어야 하는 시간(분)을 반환하는 `remainingMinutesInOven()` 메서드를 정의해요.

```java
Lasagna lasagna = new Lasagna();
lasagna.remainingMinutesInOven(30);
// => 10
```

## 3. 준비 시간을 분 단위로 계산해요

라자냐에 추가한 층 수를 매개변수로 받아, 각 층을 준비하는 데 2분이 걸린다고 가정할 때 라자냐를 준비하는 데 걸린 시간(분)을 반환하는 `preparationTimeInMinutes()` 메서드를 정의해요.

```java
Lasagna lasagna = new Lasagna();
lasagna.preparationTimeInMinutes(2);
// => 4
```

## 4. 총 작업 시간을 분 단위로 계산해요

두 개의 매개변수를 받는 `totalTimeInMinutes()` 메서드를 정의해요. 첫 번째 매개변수는 라자냐에 추가한 층 수이고, 두 번째 매개변수는 라자냐를 오븐에 넣어 둔 시간(분)이에요. 이 메서드는 라자냐를 만드는 데 총 몇 분을 작업했는지를 반환해야 해요. 이는 준비 시간(분)과 현재까지 라자냐가 오븐에 있던 시간(분)을 더한 값이에요.

```java
Lasagna lasagna = new Lasagna();
lasagna.totalTimeInMinutes(3, 20);
// => 26
```

## Source

### Created by

- @mirkoperillo