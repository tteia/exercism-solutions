# 반짝반짝 깨끗이

Exercism의 Java 트랙에 있는 반짝반짝 깨끗이에 오신 것을 환영해요.
테스트를 실행하거나 코드를 제출하는 데 도움이 필요하면 `HELP.md`를 확인해 봐요.
연습 문제를 풀다가 막히면 `HINTS.md`를 확인해 봐요. 그래도 먼저 그 내용 없이 풀어보도록 해요 :)

## Introduction

## 문자

### `char`

Java의 `char` 원시 타입은 문자 하나를 16비트로 표현한 타입이에요.
여러 개의 `char`가 `"word"`처럼 문자열을 이룰 수도 있고, 각각의 `char`를 따로 처리할 수도 있어요.
`char` 리터럴은 작은따옴표로 감싸요 (예: `'A'`).

```java
char lowerA = 'a';
char upperB = 'B';
```

### `String`에서 `char` 가져오기

`String.toCharArray` 메서드는 문자열의 문자들을 배열로 반환해요.
배열에서 설명했듯이, `for`문을 사용해 배열을 순회할 수 있어요.

```java
String text = "Hello";
char[] asArray = text.toCharArray();

for (char ch: asArray) {
    System.out.println(ch);
}

// Outputs:
// H
// e
// l
// l
// o
```

### Character 클래스

`char`를 검사하고 조작하는 내장 라이브러리 메서드가 많이 있어요.
이런 메서드들은 `java.lang.Character` 클래스의 정적 메서드로 제공돼요.
몇 가지 예를 볼까요:

```java
Character.isWhitespace(' ');    // true
Character.isWhitespace('#');    // false

Character.isLetter('a');        // true
Character.isLetter('3');        // false

Character.isDigit('6');         // true
Character.isDigit('?');         // false
```

### `String`에 `char` 더하기

`+` 연산자로 `String`에 `char`를 더할 수 있어요.

```java
'a' + " banana"     // => "a banana"
"banana " + 'a'     // => "banana a"
```

~~~~exercism/caution
`+`를 사용해 두 `char`를 이어 붙여 `String`을 만들면 _안_ 돼요!
이렇게 두 `char`를 더하면 `String`이 아니라 `int`가 나와요!
예를 들어:

```java
'b' + 'c';
// => 197 (not the String "bc")
```

Java가 `char`를 `int`로 승격하기 때문이에요 ([Java 언어 명세][jls-main]의 [4.2 원시 타입과 값][jls-primitives]을 참고하세요).

[jls-main]: https://docs.oracle.com/javase/specs/jls/se21/html/
[jls-primitives]: https://docs.oracle.com/javase/specs/jls/se21/html/jls-4.html#jls-4.2
~~~~

하지만 더할 문자가 많을 때는 `StringBuilder`를 사용하는 편이 더 효율적일 수 있어요:

```java
StringBuilder builder = new StringBuilder();
builder.append('a');
builder.append('b');
builder.append('c');

String builtString = builder.toString();
// => abc
```

## Instructions

이 연습 문제에서는 개발자가 SqueakyClean 이름을 정리하는 데 도움이 되는 유틸리티 루틴의 일부를 구현해요.

4개의 과제를 통해 `clean` 메서드를 점진적으로 완성해 나가요.
올바른 SqueakyClean 이름은 0개 이상의 문자와 밑줄로 이루어져 있어요.

모든 경우에 입력 문자열이 null이 아님이 보장돼요. `clean` 메서드는 빈 문자열도 유효한 값으로 취급해야 한다는 점에 유의해요.

## 1. 만나게 되는 모든 공백을 밑줄로 바꾸기

(_static_) `SqueakyClean.clean()` 메서드를 구현해서 모든 공백을 밑줄로 바꿔요. 문자열 맨 앞과 맨 뒤의 공백에도 똑같이 적용돼요.

```java
SqueakyClean.clean("my   Id");
// => "my___Id"
```

## 2. 케밥 케이스를 카멜 케이스로 바꾸기

(_static_) `SqueakyClean.clean()` 메서드를 수정해서 케밥 케이스를 카멜 케이스로 바꿔요.

```java
SqueakyClean.clean("a-bc");
// => "aBc"
```

## 3. 리트를 일반 텍스트로 바꾸기

(_static_) `SqueakyClean.clean()` 메서드를 수정해서 [리트][leet-speak]를 일반 텍스트로 바꿔요.

간단하게 하기 위해 `4`, `3`, `0`, `1`, `7`만 각각 `a`, `e`, `o`, `l`, `t`로 바꿔요.

```java
SqueakyClean.clean("H3ll0 W0rld");
// => "Hello_World"
SqueakyClean.clean("4 73s7");
// => "a_test"
```

## 4. 알파벳이 아닌 문자는 제외하기

(_static_) `SqueakyClean.clean()` 메서드를 수정해서 문자 중 알파벳이 아닌 것은 제외해요.

```java
SqueakyClean.clean("a$#.b");
// => "ab"
```

[leet-speak]: https://en.wikipedia.org/wiki/Leet

## Source

### Created by

- @ystromm

### Contributed to by

- @jagdish-15
- @kahgoh
- @manumafe98
- @mrDonoghue
- @sanderploegsma