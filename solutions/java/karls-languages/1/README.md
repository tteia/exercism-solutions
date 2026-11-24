# Karl의 언어들

Exercism의 Java 트랙에 있는 Karl의 언어들에 오신 것을 환영해요.
테스트를 실행하거나 코드를 제출하는 데 도움이 필요하면 `HELP.md`를 확인해 봐요.
연습 문제를 풀다가 막히면 `HINTS.md`를 확인해 봐요. 그래도 먼저 그 내용 없이 풀어보도록 해요 :)

## Introduction

## 제네릭 타입

**제네릭 타입**은 타입에 대해 매개변수화된 제네릭 클래스나 인터페이스를 말해요.
덕분에 컴파일러가 클래스나 인터페이스에 타입 안전성을 강제할 수 있어요.

제네릭이 아닌 다음 `Container` 인터페이스를 살펴봐요:

```java
class Container {
    private Object object;

    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
}
```

이 인터페이스는 Object 타입을 받고 반환하기 때문에 기본형이 아닌 모든 타입과 함께 동작해요.
하지만 여기에는 대가가 따라요. 어떤 코드는 `Integer`를 기대하면서 `get`을 호출하는데 다른 코드는 `String`을 추가하면서 `set`을 호출하면, 런타임 예외가 발생할 수 있어요.

**제네릭 클래스**와 **제네릭 인터페이스**는 다음과 같은 형식을 가져요:

```java
class ClassName<T1, T2, ..., Tn> { ... }
interface InterfaceName<T1, T2, ..., Tn> { ... }
```

클래스나 인터페이스 이름 뒤에 오는, 꺾쇠괄호(`<>`)로 구분된 타입 매개변수 부분은 타입 매개변수(타입 변수라고도 해요) `T1`, `T2`, ..., `Tn`을 지정해요.
이 타입 매개변수들을 클래스나 인터페이스의 본문 안에서 사용하면 제네릭 타입 안전성을 얻을 수 있어요.

다음은 `Container`의 제네릭 버전이에요:

```java
class Container<E> {
    private E object;

    public void set(E object) { this.object = object; }
    public E get() { return object; }
}
```

이제 인스턴스를 만들 때 어떤 타입을 담을지 선언해야 하고, 컴파일러가 그 제약을 강제해요:

```java
// empty <> can infer from context
Container<String> stringContainer = new Container<>();
// compiler knows this is a String, so it is allowed
stringContainer.set("Some string");
// no cast needed, compiler knows it is a String
String result = stringContainer.get();
// this causes a compiler error:
stringContainer.set(42);
```

## 리스트

**리스트**는 Java에서 순서가 있는 시퀀스 컬렉션이에요.
배열과 달리 [`List`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html)는 크기를 늘려서 원하는 만큼 항목을 담을 수 있어요.
표준 구현 중 하나는 크기를 조정할 수 있는 배열로 뒷받침되는 `ArrayList`예요.
또 다른 표준 구현은 이중 연결 리스트로 뒷받침되는 `LinkedList` 클래스예요.

`List`는 비어 있을 수도 있고, 중복을 포함해 원하는 만큼 항목을 담을 수도 있어요.
`List`는 어떤 타입의 객체를 담을 수 있는지 나타내는 타입이 지정된 **제네릭 인터페이스**예요.
예를 들어:

```java
List<String> emptyListOfStrings = List.of();
List<Integer> singleInteger = List.of(1);
List<Boolean> threeBooleans = List.of(true, false, true);
List<Object> listWithMultipleTypes = List.of("hello", 1, true);
```

`List`에는 원소를 추가하고, 제거하고, 가져오고, 원소가 있는지 확인하는 다양한 유용한 메서드가 있어요:

```java
List<Character> vowels = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'i', 'e', 'a'));
int startingSize = vowels.size(); // 7
vowels.add('u'); // vowels is now ['a', 'e', 'i', 'o', 'i', 'e', 'a', 'u']
char a = vowels.get(0); // 'a'
boolean hadI = vowels.remove('i'); // true and vowels is now ['a', 'e', 'o', 'i', 'e', 'a', 'u']
boolean hasI = vowels.contains('i'); // true (still have one more left)
```

## Instructions

칼은 Exercism 웹사이트에서 배울 언어 목록을 관리하고 싶어 해요.
칼은 새로운 언어를 추가하고, 기존 언어를 삭제하고, 특정 언어가 목록에 있는지 확인할 수 있어야 해요.
칼이 Java나 Kotlin을 배우고 싶어 한다면 정말 신나는 일이겠죠!

## 1. 언어 목록이 비어 있는지 확인하는 함수 정의하기

칼은 자신의 언어 목록이 언젠가 비게 되면 더 배울 언어를 찾으러 갈 수 있도록, 목록이 비었는지 알아야 해요!
목록에 언어가 하나도 없으면 `true`를 반환하는 `isEmpty`라는 메서드를 정의해요.

```java
if (languageList.isEmpty()) {
    findMoreLanguagesToLearn();
}
```

## 2. 목록에 언어를 추가하는 함수 정의하기

칼은 Kotlin과 Python을 배우기를 기대하고 있어요!
칼이 시작할 수 있도록 도와줘요. 배우고 싶은 언어를 받아 목록에 추가하는 `addLanguage`라는 메서드를 정의해요.

```java
languageList.addLanguage("Kotlin");
languageList.addLanguage("Python");
```

## 3. 목록에서 언어를 삭제하는 함수 정의하기

칼은 지금은 Scala를 배우고 싶지 않다고 결정했어요.
칼이 목록에서 Scala를 삭제할 수 있도록, 삭제하려는 언어를 받아 목록에서 제거하는 `removeLanguage`라는 메서드를 정의해요.

```java
languageList.removeLanguage("Scala");
```

## 4. 목록의 첫 번째 항목을 반환하는 함수 정의하기

칼은 자신이 목록에 추가한 첫 번째 언어(아직 목록에 남아 있는 언어)를 기억하고 싶어 해요.
목록의 첫 번째 언어를 반환하는 `firstLanguage`라는 메서드를 정의해요.

```java
String kotlin = languageList.firstLanguage(); // "Kotlin"
```

## 5. 목록에 언어가 몇 개 있는지 반환하는 함수 정의하기

칼은 자신이 배우려는 언어가 몇 개인지 알아야 해요.
목록에 있는 언어의 개수를 반환하는 `count`라는 메서드를 정의해서 칼이 답을 찾도록 도와줘요.

```java
int two = languageList.count(); // 2
```

## 6. 특정 언어가 목록에 있는지 확인하는 함수 정의하기

칼은 자신이 Python을 배우고 싶었는지 Ruby를 배우고 싶었는지 기억해 내려고 해요.
칼이 알아낼 수 있도록, 물어보는 언어를 받는 `containsLanguage`라는 메서드를 정의해요!

```java
boolean learningPython = languageList.containsLanguage("Python"); // true
boolean learningRuby = languageList.containsLanguage("Ruby"); // false
```

## 7. 목록이 신나는지 확인하는 함수 정의하기

칼이 Java나 Kotlin을 배우고 싶어 한다면, 정말 신나는 일이에요!
칼이 Java나 Kotlin을 배우고 싶어 하면 true를 반환하는 `isExciting`이라는 메서드를 정의해요.

```java
javaLanguageList.isExciting() // true
neitherKotlinNorJavaLanguageList.isExciting() // false
```

## Source

### Created by

- @jmrunkle