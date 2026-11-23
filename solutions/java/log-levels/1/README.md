# 로그 레벨

Exercism의 Java 트랙에 있는 로그 레벨에 오신 것을 환영해요.
테스트를 실행하거나 코드를 제출하는 데 도움이 필요하면 `HELP.md`를 확인해 봐요.
연습 문제를 풀다가 막히면 `HINTS.md`를 확인해 봐요. 그래도 먼저 그 내용 없이 풀어보도록 해요 :)

## Introduction

## 문자열

Java에서 `String`은 불변 텍스트를 유니코드 문자(글자, 숫자, 구두점 등)의 시퀀스로 표현하는 객체예요.
큰따옴표는 `String` 인스턴스를 정의할 때 사용해요:

```java
String fruit = "Apple";
```

문자열을 조작하려면 문자열의 메서드를 호출해요.
문자열이 한 번 생성되면 그 값은 절대 변하지 않아요.
문자열을 수정하는 것처럼 보이는 메서드도 실제로는 새로운 문자열을 반환해요.
`String` 클래스는 문자열을 변환하는 몇 가지 _정적_ 메서드를 제공해요.

## Instructions

이 연습 문제에서는 로그 라인을 처리해요.

각 로그 라인은 다음과 같은 형식의 문자열이에요: `"[<LEVEL>]: <MESSAGE>"`.

로그 레벨은 세 가지예요:

- `INFO`
- `WARNING`
- `ERROR`

세 가지 작업이 있는데, 각 작업은 로그 라인을 하나 받아서 그걸로 무언가를 해보라고 해요.

## 1. 로그 라인에서 메시지 가져오기

로그 라인의 메시지를 반환하는 (_static_) `LogLevels.message()` 메서드를 구현해요:

```java
LogLevels.message("[ERROR]: Invalid operation")
// => "Invalid operation"
```

앞이나 뒤에 붙은 공백은 제거해야 해요:

```java
LogLevels.message("[WARNING]:  Disk almost full\r\n")
// => "Disk almost full"
```

## 2. 로그 라인에서 로그 레벨 가져오기

로그 라인의 로그 레벨을 반환하는 (_static_) `LogLevels.logLevel()` 메서드를 구현해요. 로그 레벨은 소문자로 반환해야 해요:

```java
LogLevels.logLevel("[ERROR]: Invalid operation")
// => "error"
```

## 3. 로그 라인 형식 바꾸기

로그 라인의 형식을 바꾸는 (_static_) `LogLevels.reformat()` 메서드를 구현해요. 메시지를 먼저 두고, 그 뒤에 로그 레벨을 괄호 안에 넣어요:

```java
LogLevels.reformat("[INFO]: Operation completed")
// => "Operation completed (info)"
```

## Source

### Created by

- @mirkoperillo