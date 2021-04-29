# 2장. 객체지향 프로그래밍

# 1. 영화예매 시스템

## 요구사항 살펴보기

사용자는 영화 예매 시스템을 이용해 쉽고 빠르게 보고 싶은 영화를 예매할 수 있다.

- `영화`는 영화에 대한 기본 정보를 표현한다.
    - 제목, 상영시간, 가격 정보와 같이 영화가 가지고 있는 기본적인 정보를 가리킨다.
- `상영`은 실제로 관객들이 영화를 관람하는 사건을 표현한다.
    - 상영 일자, 시간, 순번 등을 가리킨다.

하나의 영화는 하루 중 다양한 시간대에 걸쳐 한 번 이상 상영될 수 있다.

사용자가 실제로 예매하는 대상은 영화가 아니라 상영이다.

특정한 조건을 만족하는 예매자는 요금을 할인받을 수 있다.

- `할인 조건(discount condition)`은 가격의 할인 여부를 결정한다.
    - 순서 조건 : 상영 순번을 이용해 할인 여부를 결정하는 규칙이다.
    - 기간 조건 : 영화 상영 시작 시간을 이용해 할인 여부를 결정한다.
- `할인 정책(discount policy)`은 할인 요금을 결정한다.
    - 금액 할인 정책(amount) : 예매 요금에서 일정 금액을 할인 해주는 방식
    - 비율 할인 정책(percent) : 정가에서 일정 비율의 요금을 할인 해주는 방식

영화별로 하나의 할인 정책만 할당할 수 있다.

할인 정책을 지정하지 않는 것도 가능하다.

할인 조건은 다수의 할인 조건을 함께 지정할 수 있으며, 순서 조건과 기간 조건을 섞는 것도 가능하다.

할인을 적용하기 위해서는 할인 조건과 할인 정책을 함께 조합해서 사용한다.

먼저 사용자의 예매 정보가 할인 조건 중 하나라도 만족하는지 검사한다.

→ 할인 조건을 만족할 경우 할인 정책을 이용해 할인 요금을 계산한다.

사용자가 예매를 완료하면 예매 정보를 생성한다.

- 제목
- 상영정보
- 인원
- 정가
- 결제 금액

# 2. 객체지향 프로그래밍을 향해

## 협력, 객체, 클래스

- 어떤 클래스가 필요한지 고민한다.
- 클래스에 어떤 속성과 어떤 메소드가 필요한지 고민한다.

→ 객체지향의 본질과는 거리가 멀다.

진정한 객체지향 패러다임으로의 전환은 클래스가 아닌 객체에 초점을 맞출 때에만 얻을 수 있다.

1. 어떤 클래스가 필요한지를 고민하기 전에 어떤 `객체`들이 필요한지 고민하라.
2. `객체`를 독립적인 존재가 아니라 기능을 구현하기 위해 `협력`하는 `공동체`의 일원으로 봐야 한다.
- `객체`는 홀로 존재하는 것이 아니다.
- 다른 객체에게 도움을 주거나 의존하면서 살아가는 `협력`적인 존재다.
- `객체`를 `협력`하는 공동체의 일원으로 바라보는 것은 설계를 유연하고 확장 가능하게 만든다.
3. 객체들의 모양과 윤곽이 잡히면 공통된 특성과 상태를 가진 객체들을 타입으로 분류하고 이 타입을 기반으로 클래스를 구현하라.
- 훌륭한 `협력`이 훌륭한 객체를 낳고 훌륭한 `객체`가 훌륭한 클래스를 낳는다.

## 도메인의 구조를 따르는 프로그램 구조

문제를 해결하기 위해 사용자가 프로그램을 사용하는 분야를 `도메인`이라 부른다.


일반적으로 클래스의 이름은 대응되는 도메인 개념의 이름과 동일하거나 적어도 유사하게 지어야 한다.

클래스 사이의 관계도 최대한 도메인 개념 사이에 맺어진 관계와 유사하게 만들어 프로그램의 구조를 이해하고 예상하기 쉽게 만들어야 한다.

도메인의 개념과 관계를 반영하도록 프로그램을 구조화 해야한다.

## 클래스 구현하기

`Screening` 클래스는 사용자들이 예매하는 대상인 `상영`을 구현한다.

인스턴스 변수의 가시성은 private이고 메소드의 가시성은 public이다.

훌륭한 클래스를 설계하기 위한 핵심은 어떤 부분을 외부에 공개하고 어떤 부분을 감출지를 결정하는 것이다.

외부에서는 객체의 속성에 직접 접근할 수 없도록 막고 적절한 public 메소드를 통해서만 내부 상태를 변경할 수 있게 해야 한다.

경계의 명확성이 객체의 자율성을 보장한다.

### 자율적인 객체

- `객체`는 `상태(state)`와 `행동(behavior)`을 함께 가지는 복합적인 존재다.
- `객체`는 스스로 판단하고 행동하는 `자율적인 존재`다.

데이터와 기능을 객체 내부로 함께 묶는 것을 `캡슐화`라고 부른다.

한 걸음 더 나아가 외부에서의 접근을 통제할 수 있는 `접근 제어(access control)` 메커니즘도 함께 제공한다.

public, protected, private과 같은 `접근 수정자(access modifier)`를 제공한다.

객체 내부에 대한 접근을 통제하는 이유는 객체를 자율적인 존재로 만들기 위해서다.

객체지향의 핵심은 스스로 상태를 관리하고, 판단하고, 행동하는 자율적인 객체들의 공동체를 구성하는 것이다.

객체가 자율적인 존재로 우뚝 서기 위해서는 외부의 간섭을 최소화해야 한다.

- `퍼블릭 인터페이스(public interface)` : 외부에서 접근 가능한 부분
- `구현(implementation)` : 외부에서 접근 불가능하고 오직 내부에서만 접근 가능한 부분

`인터페이스와 구현의 분리 원칙`은 훌륭한 객체지향 프로그램을 만들기 위해 따라야 하는 핵심 원칙이다.

### 프로그래머의 자유

- `클래스 작성자(class creator)` : 새로운 데이터 타입을 프로그램에 추가
    - 클라이언트 프로그래머에게 필요한 부분만 공개하고 나머지는 꽁꽁 숨겨야 한다.
- `클라이언트 프로그래머(client programmer)` : 클래스 작성자가 추가한 데이터 타입을 사용
    - 필요한 클래스들을 엮어서 애플리케이션을 엮어서 애플리케이션을 빠르고 안정적으로 구축

`구현 은닉(implementation hiding)` : 클라이언트 프로그래머가 숨겨 놓은 부분에 마음대로 접근할 수 없도록 방지함으로써 클라이언트 프로그래머에 대한 영향을 걱정하지 않고도 내부 구현을 마음대로 변경할 수 있다.

설계가 필요한 이유는 변경을 관리하기 위해서라는 것을 기억하라.

객체의 변경을 관리할 수 있는 기법 중에서 가장 대표적인 것이 `접근 제어`다.

변경될 가능성이 있는 세부적인 구현 내용을 `private` 영역 안에 감춤으로써 변경으로 인한 혼란을 최소화할 수 있다.

## 협력하는 객체들의 공동체

영화를 예매하기 위해 Screening, Movie, Reservation 인스턴스들은 서로의 메소드를 호출하며 상호작용한다.

시스템의 어떤 기능을 구현하기 위해 객체들 사이에 이뤄지는 상호작용을 `협력(Collaboration)`이라고 부른다.


객체지향 프로그램을 작성할 때는 먼저 협력의 관점에서 어떤 객체가 필요한지를 결정하고, 객체들의 공통 상태와 행위를 구현하기 위해 클래스를 작성한다.

## 협력에 관한 짧은 이야기

객체의 내부 상태는 외부에서 접근하지 못하도록 감춰야 한다. 대신 외부에 공개하는 퍼블릭 인터페이스를 통해 내부 상태에 접근할 수 있도록 허용한다.

객체는 다른 객체의 인터페이스에 공개된 행동을 수행하도록 요청(request)할 수 있다.

요청을 받은 객체는 자율적인 방법에 따라 요청을 처리한 후 응답(response)한다.

객체가 다른 객체와 상호작용 할 수 있는 유일한 방법은 메시지를 전송(send a message)하는 것 뿐이다.

다른 객체에게 요청이 도착할 때 해당 객체가 메시지를 수신(receive a message)했다고 이야기한다.

메시지를 수신한 객체는 스스로의 결정에 따라 자율적으로 메시지를 처리할 방법을 결정한다.

수신된 메시지를 처리하기 위한 자신만의 방법을 메소드(method)라고 부른다.

메시지와 메소드를 구분하는 것은 매우 중요하다. 메시지와 메서드의 구분에서부터 `다형성(polymorphism)`의 개념이 출발한다.

# 3. 할인 요금 구하기

## 할인 요금 계산을 위한 협력 시작하기

```java
package com.pennynd1me.study._02_movie;

import lombok.AllArgsConstructor;

import java.time.Duration;

/** 영화를 표현하는 클래스 */
@AllArgsConstructor
public class Movie {
    /** 영화 제목 */
    private String title;
    /** 상영 시간 */
    private Duration runningTime;
    /** 금액 */
    private Money fee;
    /** 할인 정책 */
    private DiscountPolicy discountPolicy;

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
```

영화 예매 시스템에는 두 가지 종류의 할인 정책이 존재한다. 하지만 코드 어디에도 할인 정책을 판단하는 코드는 존재하지 않는다. 단지 discountPolicy에게 `메시지`를 전송할 뿐이다.

- 상속(inheritance)
- 다형성(polymorphism)

그 기반에는 `추상화(abstraction)`라는 원리가 숨겨져 있다.

## 할인 정책과 할인 조건

할인 정책

- 금액 할인 정책 (AmountDiscountPolicy)
- 비율 할인 정책 (PercentDiscountPolicy)

두 클래스는 대부분의 코드가 유사하고 할인 요금을 계산하는 방식만 조금 다르다. 두 클래스 사이의 중복 코드를 제거하기 위해 공통 코드를 보관할 장소가 필요하다.

부모 클래스에 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를 자식 클래스에게 위임하는 디자인 패턴을 `TEMPLATE METHOD` 패턴이라고 부른다.

- `오버라이딩` : 부모 클래스에 정의된 같은 이름, 같은 파라미터 목록을 가진 메소드를 자식 클래스에서 재정의
    - 자식 클래스의 메소드는 오버라이딩한 부모 클래스의 메소드를 가리기 때문에 외부에서 부모 클래스의 메소드가 보이지 않음
- `오버로딩` : 메소드의 이름은 같지만 제공되는 파라미터의 목록이 다르다.
    - 오버로딩한 메소드는 원래의 메소드를 가리지 않기 때문에 사이 좋게 공존한다.

## 할인 정책 구성하기

할인 정책으로 금액 할인 정책이 적용되고, 두 개의 순서 조건과 두 개의 기간 조건을 이용해 할인 여부를 판단한다.

```java
Movie avater = new Movie("아바타",
		Duration.ofMinutes(120),
		Money.wons(10000),
		new AmountDiscountPolicy(Money.wons(800),
				new SequenceCondition(1),
				new SequenceCondition(10),
				new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
				new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));
```

10% 비율 할인 정책이 적용되고 두 개의 기간 조건과 한 개의 순서 조건을 이용해 할인 여부를 판단한다.

```java
Movie titanic = new Movie("타이타닉",
		Duration.ofMinutes(180),
		Money.wons(11000),
		new PercentDiscountPolicy(0.1,
				new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
				new SequenceCondition(2),
				new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))));
```

# 4. 상속과 다형성

Movie 클래스 어디에도 할인 정책이 금액 할인 정책인지, 비율 할인 정책인지를 판단하지 않는다.

Movie 내부에 할인 정책을 결정하는 조건문이 없는데도 불구하고 어떻게 영화 요금을 계산할 때 할인 정책과 비율 할인 정책을 선택할 수 있을까?

의존성의 개념을 살펴보고 상속과 다형성을 이용해 특정한 조건을 선택적으로 실행하는 방법을 알아보자.

## 컴파일 시간 의존성과 실행 시간 의존성

Movie의 생성자에서 DiscountPolicy 타입의 객체를 인자로 받았다.

Movie의 인스턴스를 생성할 때 인자로 DiscountPolicy 타입을 상속받는 (Amount, Percent)DiscountPolicy의 인스턴스를 전달하면 (금액, 비율)할인 정책을 적용할 수 있다.

코드 상에서는 Movie는 DiscountPolicy에 의존한다. 그러나 실행 시점에는 AmountDiscountPolicy나 PercentDiscountPolicy의 인스턴스에 의존하게 된다.

- 코드의 의존성과 실행 시점의 의존성이 서로 다를 수 있다.
- 클래스 사이의 의존성과 객체 사이의 의존성은 동일하지 않을 수 있다.
- 확장 가능한 객체지향 설계가 가지는 특징은 코드의 의존성과 실행 시점의 의존성이 다르다.

- 코드의 의존성과 실행 시점의 의존성이 다르면 다를수록 코드를 이해하기 어려워진다.
- 코드의 의존성과 실행 시점의 의존성이 다르면 다를수록 코드는 더 유연해지고 확장 가능해진다.

이와 같은 의존성의 양면성은 설계가 트레이드오프의 산물이라는 사실을 잘 보여준다.

## 차이에 의한 프로그래밍

상속은 객체지향에서 코드를 재사용하기 위해 가장 널리 사용되는 방법이다.

상속을 이용하면 클래스 사이에 관계를 설정하는 것만으로 기존 클래스가 가지고 있는 모든 속성과 행동을 새로운 클래스에 포함시킬 수 있다.

상속은 기존 클래스를 기반으로 새로운 클래스를 쉽고 빠르게 추가할 수 있는 간편한 방법을 제공한다.

또한 상속을 이용하면 부모 클래스의 구현은 공유하면서도 행동이 다른 자식 클래스를 쉽게 추가할 수 있다.

이처럼 부모 클래스와 다른 부분만을 추가해서 새로운 클래스를 쉽고 빠르게 만드는 방법을 `차이에 의한 프로그래밍(Programming by difference)`이라고 부른다.

- 슈퍼클래스(superclass), 부모 클래스(parent class), 부모, 직계 조상, 직접적인 조상
- 서브클래스(subclass), 자식 클래스(child class), 자식, 직계 자손, 직접적인 자손

상속 계층에서 특정 클래스보다 상위에 위치한 모든 클래스를 조상(ancestors)라고 부르고, 하위에 위치한 모든 클래스를 자손(descendants)이라고 부른다.

클래스 관계는 상대적이다. 어떤 클래스를 기준으로 하느냐에 따라 상속 관계에 참여하는 클래스의 역할이 달라진다.

C++에는 기반 클래스(base class), 파생 클래스(derived class)라는 새로운 용어를 도입하기도 했다.

## 상속과 인터페이스

상속이 가치 있는 이유는 부모 클래스가 제공하는 모든 인터페이스를 자식 클래스가 물려받을 수 있기 때문이다.

단순히 메소드나 인스턴스 변수를 재사용하는 것과는 거리가 있다.

자식 클래스는 상속을 통해 부모 클래스의 인터페이스를 물려받기 때문에 부모 클래스 대신 사용될 수 있다.

컴파일러는 코드 상에서 부모 클래스가 나오는 모든 장소에서 자식 클래스를 사용하는 것을 허용한다.

이처럼 자식 클래스가 부모 클래스를 대신하는 것을 `업캐스팅(upcasting)`이라고 부른다. 아래에 위치한 자식 클래스가 위에 위치한 부모 클래스를 자동적으로 타입 캐스팅되는 것 처럼 보이기 때문에 업캐스팅이라는 용어를 사용한다.

## 다형성

메시지와 메서드는 다른 개념이다.

메시지를 수신하고 실행되는 메소드는 상호작용하기 위해 연결된 객체의 클래스가 무엇인가에 따라 달라진다.

협력하는 객체가 상속받는 자식클래스라면 자식클래스에서 오버라이딩한 메소드가 실행된다.

이를 `다형성`이라고 부른다.

다형성은 객체지향 프로그램의 컴파일 시간 의존성과 실행 시간 의존성이 다를 수 있다는 사실을 기반으로 한다.

다형성은 컴파일 시간 의존성과 실행 시간 의존성을 다르게 만들 수 있는 객체지향의 특성을 이용해 서로 다른 메소드를 실행할 수 있게 한다.

다형성이란 동일한 메시지를 수신했을 때 객체의 타입에 따라 다르게 응답할 수 있는 능력을 의미한다.

다형적인 협력에 참여하는 객체들은 모두 같은 메시지를 이해할 수 있어야 한다. 인터페이스가 동일해야 한다.

AmountDiscountPolicy와 PercentDiscountPolicy의 인터페이스를 통일하기 위해 사용한 구현 방법이 DiscountPolicy를 상속받는 구현 방법이다.

다형성을 구현하는 방법은 매우 다양하지만 메시지에 응답하기 위해 실행될 메소드를 컴파일 시점이 아닌 실행 시점에 결정한다는 공통점이 있다. 메시지와 메소드를 실행 시점에 바인딩한다.

이를 `지연 바인딩(lazy binding)` 또는 `동적 바인딩(dynamic binding)`이라고 부른다.

그에 반해 전통적인 함수 호출처럼 컴파일 시점에 실행될 함수나 프로시저를 결정하는 것을 `초기 바인딩(early binding)` 또는 `정적 바인딩(static binding)`이라고 부른다.

객체 지향이 컴파일 시점의 의존성과 실행 시점의 의존성을 분리하고, 하나의 메시지를 선택적으로 다른 메소드에 연결할 수 있는 이유가 바로 지연 바인딩이라는 메커니즘을 사용하기 때문이다.

다형성이란 추상적인 개념이고 이를 구현할 수 있는 방법이 꽤나 다양하다는 사실을 배워보자. (not only 상속)

### 구현 상속과 인터페이스 상속

- `구현 상속(implementation inheritance)` : 서브클래싱(subclassing)
    - 순수하게 코드를 재사용하기 위한 목적으로 상속을 사용하는 것
- `인터페이스 상속(interface inheritance)` : 서브타이핑(subtyping)
    - 다형적인 협력을 위해 부모 클래스와 자식 클래스가 인터페이스를 공유할 수 있도록 상속을 이용

인터페이스를 재사용할 목적이 아니라 구현을 재사용할 목적으로 상속을 사용하면 변경에 취약한 코드를 낳게 될 확률이 높다.

## 인터페이스와 다형성

종종 구현은 공유할 필요가 없고 순수하게 인터페이스만 공유하고 싶을 때 C#과 자바에서는 인터페이스라는 프로그래밍 요소를 제공한다.

구현에 대한 고려 없이 다형적인 협력에 참여하는 클래스들이 공유 가능한 외부 인터페이스를 정의한 것이다.

C++의 경우 추상 기반 클래스(Absract Base Class)를 통해 자바의 인터페이스 개념을 구현할 수 있다.

# 5. 추상화와 유연성

## 추상화의 힘

할인 정책은 구체적인 금액 할인 정책과 비율 할인 정책을 포괄하는 추상적인 개념이다.

할인 조건 역시 더 구체적인 순번 조건과 기간 조건을 포괄하는 추상적인 개념이다.

둘 다 같은 계층에 속하는 클래스들이 공통으로 가질 수 있는 인터페이스를 정의하며 구현의 일부(추상 클래스인 경우) 또는 전체(자바 인터페이스인 경우)를 자식 클래스가 결정할 수 있도록 결정권을 위임한다.

- 추상화의 계층만 따로 떼어 놓고 살펴보면 요구사항의 정책을 높은 수준에서 서술할 수 있다.
- 추상화를 이용하면 설계가 좀 더 유연해진다.

영화 예매 요금은 최대 하나의 '할인 정책'과 다수의 '할인 조건'을 이용해 계산할 수 있다.

추상화를 사용하면 세부적인 내용을 무시한 채 상위 정책을 쉽고 간단하게 표현할 수 있다.

세부사항에 억눌리지 않고 상위 개념만으로도 도메인의 중요한 개념을 설명할 수 있게 한다.

추상화를 이용한 설계는 필요에 따라 표현의 수준을 조정하는 것을 가능하게 해준다.

추상화를 이용해 상위 정책을 기술한다는 것은 기본적인 애플리케이션의 협력 흐름을 기술한다는 것을 의미한다.

재사용 가능한 설계의 기본을 이루는 `디자인 패턴(desgin pattern)`이나 `프레임워크(framework)` 모두 추상화를 이용해 상위 정책을 정의하는 객체지향의 메커니즘을 활용하고 있다.

## 유연한 설계

기존의 할인 정책의 경우에는 할인할 금액을 계산하는 책임이 DiscountPolicy의 자식 클래스에 있었지만 할인 정책이 없는 경우 책임을 Movie에서 조건문을 사용하는 것은 좋지 않은 선택이다.

책임의 위치를 결정하기 위해 조건문을 사용하는 것은 협력의 설계 측면에서 대부분의 경우 좋지 않은 선택이다.

항상 예외 케이스를 최소하고 일관성을 유지할 수 있는 방법을 선택하라.

0원이라는 할인 요금을 계산할 책임을 그대로 DiscountPolicy 계층에 유지시키는 방법을 선택하자.

기존의 Movie와 DiscountPolicy는 수정하지 않고 NoneDiscountPolicy라는 새로운 클래스를 추가하는 것만으로 애플리케이션의 기능을 확장했다.

이처럼 추상화를 중심으로 코드의 구조를 설계하면 유연하고 확장 가능한 설계를 만들 수 있다.

추상화는 설계가 구체적인 상황에 결합되는 것을 방지하기 때문에 유연한 설계를 가능하게 한다.

8장의 `컨텍스트 독립성(context independency)`이라고 불리는 이 개념은 프레임워크와 같은 유연한 설계가 필수적인 분야에서 그 진가를 발휘한다.

결론은 간단하다. 유연성이 필요한 곳에 추상화를 사용하라.

## 추상 클래스와 인터페이스 트레이드 오프

구현과 관련된 모든 것들이 트레이드 오프의 대상이 될 수 있다.

내가 작성하는 모든 코드에는 합당한 이유가 있어야 한다. 비록 아주 사소한 결정이더라도 트레이드오프를 통해 얻어진 결론과 그렇지 않은 결론 사이의 차이는 크다.

고민하고 트레이드오프하라.

## 코드 재사용

상속`(Is-a)`은 코드를 재사용하기 위해 널리 사용되는 방법이다.

코드 재사용을 위해서는 상속보다는 다른 객체의 인스턴스를 자신의 인스턴스 변수로 포함해서 재사용하는 방법인 `합성(composition)`이 더 좋은 방법일 수 있다.

Movie가 DiscountPolicy의 코드를 재사용하는 방법이 바로 합성이다. `(has-a)`

```java
package com.pennynd1me.study._02_movie;

import lombok.AllArgsConstructor;

import java.time.Duration;

/** 영화를 표현하는 클래스 */
@AllArgsConstructor
public class Movie {
    /** 영화 제목 */
    private String title;
    /** 상영 시간 */
    private Duration runningTime;
    /** 금액 */
    private Money fee;
    /** 할인 정책 */
    private DefaultDiscountPolicy discountPolicy;

    public Money getFee() {
        return fee;
    }

    /**
     * 영화의 금액을 계산하는 메소드
     * @param screening 상영
     * @return 할인 정책이 없다면 금액; 할인 정책이 있다면 금액에서 그 금액만큼 차감해서 (금액-할인 정책);
     */
    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
```

## 상속

- 상속은 캡슐화를 위반한다.
    - 상속을 이용하기 위해서는 부모 클래스의 내부 구조를 잘 알고 있어야 한다.
    - 부모 클래스의 구현이 자식 클래스에게 노출되기 때문에 캡슐화가 약화된다.
    - 자식 클래스가 부모 클래스에 강하게 결합되도록 만든다.
- 설계를 유연하지 못하게 만든다.
    - 상속은 부모 클래스와 자식 클래스 사이의 관계를 컴파일 시점에 결정한다.
    - 실행 시점에 객체의 종류를 변경하는 것이 불가능하다.

상속보다 인스턴스 변수로 관계를 연결한 원래의 설계가 더 유연하다.

## 합성

상속이 부모 클래스의 코드와 자식 클래스의 코드를 컴파일 시점에 하나의 단위로 강하게 결합하는데 비해 DiscountPolicy의 인터페이스를 통해 약하게 결합된다.

인터페이스에 정의된 메시지를 통해서만 코드를 재사용하는 방법을 `합성(composition)`이라고 부른다.

합성은 상속이 가지는 두 가지 문제점을 모두 해결한다.

인터페이스에 정의된 메시지를 통해서만 재사용이 가능하기 때문에 구현을 효과적으로 캡슐화 할 수 있다.

의존하는 인스턴스를 교체하는 것이 비교적 쉽기 때문에 설계를 유연하게 만든다.

- 상속은 클래스를 통해 강하게 결합된다.
- 합성은 메시지를 통해 느슨하게 결합된다.

객체 지향 패러다임의 중심에는 객체가 위치한다.

객체지향에서 가장 중요한 것은 애플리케이션의 기능을 구현하기 위해 협력에 참여하는 객체들 사이의 상호작용이다.

객체들은 협력에 참여하기 위해 역할을 부여받고 역할에 적합한 책임을 수행한다.

객체지향 설계의 핵심은 적절한 협력을 식별하고 협력에 필요한 역할을 정의한 후에 역할을 수행할 수 있는 적절한 객체에게 적절한 책임을 할당하는 것이다.