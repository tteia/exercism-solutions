# 새 관찰자

Exercism의 Java 트랙에 있는 새 관찰자에 오신 것을 환영해요.
테스트를 실행하거나 코드를 제출하는 데 도움이 필요하면 `HELP.md`를 확인해 봐요.
연습 문제를 풀다가 막히면 `HINTS.md`를 확인해 봐요. 그래도 먼저 그 내용 없이 풀어보도록 해요 :)

## Introduction

## 배열

Java에서 배열은 같은 타입의 값을 하나의 구조에 여러 개 저장하는 방법이에요.
다른 자료 구조와 달리, 배열은 한 번 생성하면 크기가 고정돼요.
원소는 인덱스를 사용해 배열에 할당하거나 배열에서 가져올 수 있어요.
Java 배열은 0부터 시작하는 인덱싱을 사용해요. 첫 번째 원소의 인덱스는 0, 두 번째 원소의 인덱스는 1인 식이에요.

다음은 배열을 초기화하는 표준 문법이에요.

```java
type[] variableName = new type[size];
```

`type`은 배열에 들어 있는 원소의 타입이에요.
기본형(예: `int`)일 수도 있고 클래스(예: `String`)일 수도 있어요.

`size`는 이 배열이 담을 원소의 개수예요(나중에 바꿀 수 없어요).
배열을 만들면 원소는 기본값으로 초기화돼요(보통 `0`, `false`, `null`).

```java
// Declare array with explicit size (size is 2)
int[] twoInts = new int[2];
```

축약 표기법을 사용하면 배열을 만들면서 동시에 값을 설정할 수도 있어요.

```java
// Two equivalent ways to declare and initialize an array (size is 3)
int[] threeIntsV1 = new int[] { 4, 9, 7 };
int[] threeIntsV2 = { 4, 9, 7 };
```

이제 컴파일러가 배열에 원소가 몇 개 들어갈지 알 수 있으므로 길이는 생략할 수 있어요.

배열 원소는 대괄호 인덱스 표기법으로 할당하고 접근할 수 있어요.

```java
// Assign second element by index
twoInts[1] = 8;

// Retrieve the second element by index and assign to the int element
int secondElement = twoInts[1];
```

배열의 유효한 인덱스 범위를 벗어난 인덱스에 접근하면 `IndexOutOfBoundsException`이 발생해요.

배열은 배열 인스턴스의 메서드나 속성을 호출해서 다룰 수도 있고, `Arrays` 클래스에 정의된 정적 메서드를 사용해서 다룰 수도 있어요(보통 제네릭 코드에서만 사용해요).
`length` 속성은 배열의 길이를 담고 있어요.
다음과 같이 접근할 수 있어요.

```java
int arrayLength = someArray.length;
```

Java는 배열과 관련된 유용한 메서드가 많이 들어 있는 편리한 유틸리티 클래스 [`java.util.Arrays`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html)도 제공해요(예: `Arrays.equals`).

Java는 `int[][] arr = new int[3][4];` 같은 [다차원 배열](https://www.programiz.com/java-programming/multidimensional-array)도 지원하는데, 아주 유용하게 쓰일 수 있어요.

배열은 _컬렉션_이기도 하기 때문에, 인덱스로 값을 접근하는 것 외에도 `for-each`문으로 _모든_ 값 위를 순회할 수 있어요.

```java
char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

for(char vowel: vowels) {
    // Output the vowel
    System.out.print(vowel);
}

// => aeiou
```

어떤 값을 순회할지 더 세밀하게 제어하고 싶다면 `for`문을 사용할 수 있어요.

```java
char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

for (int i = 0; i < 3; i++) {
    // Output the vowel
    System.out.print(vowels[i]);
}

// => aei
```

## Instructions

지난 7일 동안 정원에 새가 몇 마리 찾아왔는지 기록하는, 새 관찰을 무척 좋아하는 사람이에요.

정원을 찾아온 새의 수를 다루는 여섯 가지 과제가 있어요.

## 1. 지난주에 센 새의 수를 확인해요

비교를 위해 지난주에 센 새의 수를 항상 가까이에 적어 두는데, 그 값은 0, 2, 5, 3, 7, 8, 4예요. 지난주에 센 새의 수를 반환하는 `BirdWatcher.getLastWeek()` 메서드를 구현해요:

```java
BirdWatcher.getLastWeek();
// => [0, 2, 5, 3, 7, 8, 4]
```

## 2. 오늘 방문한 새가 몇 마리인지 확인해요

오늘 정원을 찾아온 새가 몇 마리인지 반환하는 `BirdWatcher.getToday()` 메서드를 구현해요. 새의 수는 날짜 순으로 정렬되어 있고, 첫 번째 원소는 가장 오래된 날의 새 수이며, 마지막 원소는 오늘의 새 수예요.

```java
int[] birdsPerDay = { 2, 5, 0, 7, 4, 1 };
BirdWatcher birdCount = new BirdWatcher(birdsPerDay);
birdCount.getToday();
// => 1
```

## 3. 오늘의 새 수를 증가시켜요

오늘의 새 수를 증가시키는 `BirdWatcher.incrementTodaysCount()` 메서드를 구현해요:

```java
int[] birdsPerDay = { 2, 5, 0, 7, 4, 1 };
BirdWatcher birdCount = new BirdWatcher(birdsPerDay);
birdCount.incrementTodaysCount();
birdCount.getToday();
// => 2
```

## 4. 새가 한 마리도 방문하지 않은 날이 있었는지 확인해요

정원에 새가 한 마리도 찾아오지 않은 날이 있었다면 `true`를 반환하고, 그렇지 않으면 `false`를 반환하는 `BirdWatcher.hasDayWithoutBirds()` 메서드를 구현해요:

```java
int[] birdsPerDay = { 2, 5, 0, 7, 4, 1 };
BirdWatcher birdCount = new BirdWatcher(birdsPerDay);
birdCount.hasDayWithoutBirds();
// => true
```

## 5. 처음 며칠 동안 방문한 새의 수를 계산해요

이번 주 시작부터 정원을 찾아온 새의 수를 반환하되, 이때 주 시작부터 지정된 일수까지만 세도록 제한하는 `BirdWatcher.getCountForFirstDays()` 메서드를 구현해요.

```java
int[] birdsPerDay = { 2, 5, 0, 7, 4, 1 };
BirdWatcher birdCount = new BirdWatcher(birdsPerDay);
birdCount.getCountForFirstDays(4);
// => 14
```

## 6. 바쁜 날의 수를 계산해요

어떤 날은 다른 날보다 더 바빠요. 바쁜 날이란 정원에 다섯 마리 이상의 새가 찾아온 날이에요.
바쁜 날의 수를 반환하는 `BirdWatcher.getBusyDays()` 메서드를 구현해요:

```java
int[] birdsPerDay = { 2, 5, 0, 7, 4, 1 };
BirdWatcher birdCount = new BirdWatcher(birdsPerDay);
birdCount.getBusyDays();
// => 2
```

## Source

### Created by

- @samuelteixeiras
- @ystromm

### Contributed to by

- @jagdish-15