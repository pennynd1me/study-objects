# 3장. 역할, 책임, 협력

객체지향 패러다임의 관점에서 핵심은 `역할(role)`, `책임(responsibility)`, `협력(collaboration)`이다.

클래스, 상속, 지연 바인딩은 구현 측면에 치우쳐 있기 때문에 객체지향 패러다임의 본질과는 거리가 멀다.

객체지향의 본질은 협력하는 객체들의 공동체를 창조하는 것이다. 객체지향 설계의 핵심은 협력을 구성하기 위해 적절한 객체를 찾고 적절한 책임을 할당하는 과정에서 드러난다.

클래스와 상속은 객체들의 책임과 협력이 어느 정도 자리를 잡은 후에 사용할 수 있는 구현 메커니즘일 뿐이다.

애플리케이션의 기능을 구현하기 위해 어떤 협력이 필요하고 협력을 위해 어떤 역할과 책임이 필요한지를 고민하지 않은 채 너무 이른 시기에 구현에 초점을 맞추는 것은 변경하기 어렵고 유연하지 못한 코드를 낳는 원인이 된다.

역할, 책임, 협력이 제자리를 찾지 못한 상태라면 응집도 높은 클래스와 중복 없는 상속 계층을 구현한다고 하더라도 애플리케이션이 침몰하는 것을 구원하지 못할 것이다.

# 1. 협력

## 영화 예매 시스템 돌아보기

객체지향 원칙을 따르는 애플리케이션의 제어 흐름은 어떤 하나의 객체에 의해 통제되지 않고 다양한 객체들 사이에 균형 있게 분배되는 것이 일반적이다.

객체들은 요청의 흐름을 따라 자신에게 분배된 로직을 실행하면서 애플리케이션의 전체 기능을 완성한다.

- 객체들이 애플리케이션의 기능을 구현하기 위해 수행하는 상호작용을 `협력`이라고 한다.
- 객체가 협력에 참여하기 위해 수행하는 로직은 `책임`이라고 부른다.
- 객체들이 협력 안에서 수행하는 책임들이 모여 객체가 수행하는 `역할`을 구성한다.

## 협력

객체는 고립된 존재가 아니라 시스템의 기능이라는 더 큰 목표를 달성하기 위해 다른 객체와 협력하는 사회적인 존재다.

협력은 객체지향의 세계에서 기능을 구현할 수 있는 유일한 방법이다.

두 객체 사이의 협력은 하나의 객체가 다른 객체에게 도움을 요청할 때 시작된다.

`메시지 전송(message sending)`은 객체 사이의 협력을 위해 사용할 수 있는 유일한 커뮤니케이션 수단이다.

객체는 다른 객체의 상세한 내부 구현에 직접 접근할 수 없기 때문에 오직 메시지 전송을 통해서만 자신의 요청을 전송할 수 있다.

> 객체 사이의 협력을 설계할 때는 객체를 서로 분리된 인스턴스가 아닌 협력하는 파트너로 인식해야 한다.

메시지를 수신한 객체는 메시지를 처리할 방법을 스스로 선택해 메소드를 실행해 요청에 응답한다.

외부의 객체는 오직 메시지만 전송할 수 있을 뿐이며 메시지를 어떻게 처리할지는 메시지를 수신한 객체가 직접 결정한다. 객체는 자신의 일을 스스로 처리할 수 있는 자율적인 존재라는 것이다.

Screening이 Movie에게 처리를 위임하는 이유는 요금을 계산하는 데 필요한 기본 요금과 할인 정책을 가장 잘 알고 있는 객체가 Movie이기 때문이다.

요금을 계산하는 작업을 Screening이 수행한다면 Movie의 인스턴스 변수인 fee와 discountPolicy에 직접 접근해야만 할 것이다. 이 경우 Screening은 Movie의 내부 구현에 결합된다.

가장 큰 문제점은 Movie의 자율성이 훼손된다는 것이다.

자율적인 객체란 자신의 상태를 직접 관리하고 스스로의 결정에 따라 행동하는 객체다.

객체의 자율성을 보장하기 위해서는 필요한 정보와 정보에 기반한 행동을 같은 객체 안에 모아놓아야 한다.

자신이 할 수 없는 일을 다른 객체에게 위임하면 협력에 참여하는 객체들의 전체적인 자율성을 향상시킬 수 있다.

객체를 자율적으로 만드는 가장 기본적인 방법은 내부 구현을 `캡슐화` 하는것이다.

캡슐화를 통해 변경에 대한 파급효과를 제한할 수 있기 때문에 자율적인 객체는 변경하기도 쉬워진다.

자율적인 객체는 자신에게 할당된 책임을 수행하던 중에 필요한 정보를 알지 못하거나 외부의 도움이 필요한 경우 적절한 객체에게 메시지를 전송해서 협력을 요청한다.

메시지를 수신한 객체 역시 메시지를 처리하던 중에 직접 처리할 수 없는 정보나 행동이 필요한 경우 또 다른 객체에게 도움을 요청한다.

이처럼 객체들 사이의 협력을 구성하는 일련의 요청과 응답의 흐름을 통해 애플리케이션의 기능이 구현된다.

## 협력이 설계를 위한 문맥을 결정한다.

객체란 상태와 행동을 함께 캡슐화하는 실행 단위다.

객체가 가질 수 있는 상태와 행동을 어떤 기준으로 결정해야 할까?

객체를 설계할 때 어떤 행동과 상태를 할당했다면 그 이유는 무엇인가?

애플리케이션 안에 어떤 객체가 필요하다면 그 객체가 어떤 협력에 참여하고 있기 때문이어야한다.

객체가 협력에 참여할 수 있는 이유는 협력에 필요한 적절한 행동을 보유하고 있기 때문이다.

협력이 바뀌면 객체가 제공해야 하는 행동 역시 바뀌어야 한다.

`협력`은 객체가 필요한 이유와 객체가 수행하는 행동의 동기를 제공한다.

객체는 자신의 상태를 스스로 결정하고 관리하는 자율적인 존재이기 때문에 객체가 수행하는 `행동`에 필요한 `상태`도 함께 가지고 있어야 한다.

`상태`는 객체가 행동하는 데 필요한 정보에 의해 결정되고 `행동`은 협력 안에서 객체가 처리할 메시지로 결정된다.

결과적으로 객체가 참여하는 협력이 객체를 구성하는 행동과 상태 모두를 결정한다.

따라서 협력은 객체를 설계하는 데 필요한 일종의 `문맥(context)`을 제공한다.

# 2. 책임

## 책임이란 무엇인가

협력에 참여하기 위해 객체가 수행하는 행동을 `책임`이라고 부른다.

책임이란 객체에 의해 정의되는 응집도 있는 행위의 집합으로, 객체가 유지해야 하는 정보와 수행 할 수 있는 행동에 대해 개략적으로 서술한 문장이다.

- `하는 것(doing)` - 객체가 '무엇을 할 수 있는가'
    - 객체를 생성하거나 계산을 수행하는 등의 스스로 하는 것
    - 다른 객체의 행동을 시작시키는 것
    - 다른 객체의 활동을 제어하고 조절하는 것
- `아는 것(knowing)` - 객체가 '무엇을 알고 있는가'
    - 사적인 정보에 관해 아는 것
    - 관련된 객체에 관해 아는 것
    - 자신이 유도하거나 계산할 수 있는 것에 관해 아는 것

영화 예매 시스템에서 `Screening`의 책임

- 영화를 예매 하는 것
- 자신이 상영할 영화를 알고 있는 것

영화 예매 시스템에서 `Movie`의 책임

- 요금을 계산 하는 것
- 가격과 어떤 할인 정책이 적용되었는지 알고 있는 것

협력 안에서 객체에게 할당한 책임이 외부의 인터페이스와 내부의 속성을 결정한다.

책임과 메시지의 크기는 다르다.

책임은 객체가 수행할 수 있는 행동을 종합적이고 간략하게 서술하기 때문에 메시지보다 추상적이고 개념적으로도 더 크다.

처음에는 단순한 책임이라고 생각했던 것이 여러 개의 메시지로 분할되기도 하고 하나의 객체가 수행할 수 있다고 생각했던 책임이 나중에는 여러 객체들이 협력해야만 하는 커다란 책임으로 자라는 것이 일반적이다.

책임의 관점에서 `아는 것`과 `하는 것`이 밀접하게 연관되어 있다.

`책임`은 객체지향 설계의 핵심이다.

`협력`이 중요한 이유는 객체에게 할당할 책임을 결정할 수 있는 문맥을 제공하기 때문이다.

적절한 협력이 적절한 책임을 제공하고, 적절한 책임을 적절한 객체에게 할당해야만 단순하고 유연한 설계를 창조할 수 있다.

객체에게 얼마나 적절한 `책임`을 할당하느냐가 설계의 전체적인 `품질`을 결정한다.

객체의 구현 방법은 상대적으로 책임보다는 덜 중요하며 책임을 결정한 다음에 고민해도 늦지 않다.

### CRC 카드

역할을 식별하고, 책임을 할당하며, 협력을 명시적으로 표현하는 구체적이면서도 실용적인 설계 기법

- `후보(Candidate)` : 역할, 객체, 클래스 어떤 것이라도 될 수 있다.
    - 목적: 후보가 외부에 제공해야 하는 서비스를 하나의 문장으로 표현한 것
- `책임(Responsibility)`
    - 목적을 좀 더 세분화해서 무엇을 알고 무엇을 해야하는지에 대한 책임
- `협력자(Collaborator)` : 후보가 자신의 책임을 완수하기 위해 정보나 기능을 요청할 대상 후보
    - 책임을 수행하면서 함께 협력할 협력자

## 책임 할당

책임 할당을 위한 `INFORMATION EXPERT (정보 전문가)` 패턴

- 협력에 필요한 지식과 방법을 가장 잘 알고 있는 객체에게 도움을 요청한다.

요청에 응답하기 위해 필요한 이 행동이 객체가 수행할 책임으로 이어 진다.

따라서 객체에게 책임을 할당하기 위해서는 먼저 협력이라는 문맥을 정의해야 한다.

협력을 설계하는 출발점은 시스템이 사용자에게 제공하는 기능을 시스템이 담당할 하나의 책임으로 바라보는 것이다.

객체지향 설계는 시스템의 책임을 완료하는 데 필요한 더 작은 책임을 찾아내고 이를 객체들에게 할당하는 반복적인 과정을 통해 모양을 갖춰간다.

- 영화 예매 시스템을 예로 들어 정보 전문가에게 책임을 할당하는 방법
    - 시스템이 사용자에게 제공해야 할 기능은 영화를 예매하는 것이다. → 시스템이 제공할 책임
    - 객체가 책임을 수행하게 하는 유일한 방법은 메시지를 전송하는 것이므로 책임을 할당한다는 것은 메시지의 이름을 결정하는 것과 같다.

  1: 예매하라 → `:Screening` → 2: 가격을 계산하라 → `:Movie` → 3: 할인 요금을 계산하라 →

  메시지를 처리할 적절한 객체를 선택해야 한다. 영화를 예매하는 책임을 어떤 객체에 할당해야 할까?

  정보 전문가(영화 예매와 관련된 정보를 가장 많이 알고 있는 객체)에게 책임을 할당하는 것이 바람직하다.

협력을 설계하면서 객체의 책임을 식별해 나가는 과정에서 최종적으로 얻게 되는 결과물은 시스템을 구성하는 객체들의 인터페이스와 오퍼레이션의 목록이다.

어떤 경우에는 응집도와 결합도의 관점에서 정보 전문가가 아닌 다른 객체에게 책임을 할당하는 것이 더 적절한 경우도 있다. 하지만 기본적인 전략은 책임을 수행할 정보 전문가를 찾는 것이다.

정보 전문가에게 책임을 할당하는 것만으로도 상태와 행동을 함께 가지는 자율적인 객체를 만들 가능성이 높아지기 때문이다.

## 책임 주도 설계

협력을 설계하기 위해서는 책임에 초점을 맞춰야 한다.

어떤 책임을 선택하느냐가 전체적인 설계의 방향과 흐름을 결정한다.

이처럼 책임을 찾고 책임을 수행할 적절한 객체를 찾아 책임을 할당하는 방식으로 협력을 설계하는 방법을 `책임 주도 설계(Responsibility-Driven Design, RDD)`라고 부른다.

- 시스템이 사용자에게 제공해야 하는 기능인 시스템 책임을 파악한다.
- 시스템 책임을 더 작은 책임으로 분할한다.
- 분할된 책임을 수행할 수 있는 적절한 객체 또는 역할을 찾아 책임을 할당한다.
- 객체가 책임을 수행하는 도중 다른 객체의 도움이 필요한 경우 이를 책임질 적절한 객체 또는 역할을 찾는다.
- 해당 객체 또는 역할에게 책임을 할당함으로써 두 객체가 협력하게 한다.

협력은 객체를 설계하기 위한 구체적인 문맥을 제공한다.

협력이 책임을 이끌어내고 책임이 협력에 참여할 객체를 결정한다.

책임 주도 설계는 자연스럽게 객체의 구현이 아닌 책임에 집중할 수 있게 한다.

유연하고 견고한 객체지향 시스템을 위해 가장 중요한 재료가 바로 책임이다.

## 메시지가 객체를 결정한다.

객체에게 책임을 할당하는데 필요한 메시지를 먼저 식별하고 메시지를 처리할 객체를 나중에 선택했다.

객체가 메시지를 선택하는 것이 아니라 메시지가 객체를 선택하게 했다.

- 객체가 최소한의 `인터페이스(minimal interface)`를 가질 수 있게 된다.
    - 필요한 메시지가 식별될 때까지 객체의 퍼블릭 인터페이스에는 어떤 것도 추가하지 않는다.
    - 객체는 애플리케이션에 크지도, 작지도 않은 꼭 필요한 크기의 퍼블릭 인터페이스를 가질 수 있다.
- 객체는 충분히 `추상적인 인터페이스(abstract interface)`를 가질 수 있게 된다.
    - 객체의 인터페이스는 `무엇`을 하는지는 표현해야 하지만 `어떻게` 수행하는지를 노출해서는 안된다.
    - 메시지는 외부의 객체가 요청하는 무언가를 의미하기 때문에 메시지를 먼저 식별하면 무엇을 수행할지에 초점을 맞추는 인터페이스를 얻을 수 있다.

결과적으로 협력을 구성하는 객체들의 인터페이스는 충분히 추상적인 동시에 최소한의 크기를 유지할 수 있었다.

## 행동이 상태를 결정한다.

객체가 존재하는 이유는 협력에 참여하기 위해서다. 객체는 협력에 필요한 `행동`을 제공해야 한다.

객체를 객체답게 만드는 것은 객체의 상태가 아니라 객체가 다른 객체에게 제공하는 `행동`이다.

객체의 `행동`은 객체가 협력에 참여할 수 있는 유일한 방법이다.

객체가 협력에 적합한지를 결정하는 것은 그 객체의 상태가 아니라 `행동`이다.

얼마나 적절한 객체를 창조했느냐는 얼마나 적절한 책임을 할당했느냐에 달려있고, 책임이 얼마나 적절한지는 협력에 얼마나 적절한가에 달려있다.

캡슐화를 위반하지 않도록 구현에 대한 결정을 뒤로 미루면서 객체의 행위를 고려하기 위해서는 항상 협력이라는 문맥 안에서 객체를 생각해야 한다.

개별 객체의 상태와 행동이 아닌 시스템의 기능을 구현하기 위한 협력에 초점을 맞춰야만 응집도가 높고 결합도가 낮은 객체들을 창조할 수 있다.

상태는 단지 객체가 행동을 정상적으로 수행하기 위해 필요한 재료일 뿐이다.

객체가 가질 수 있는 상태는 행동을 결정하고 나서야 비로소 결정할 수 있다.

협력이 객체의 `행동`을 결정하고 행동이 상태를 결정한다.

그 행동이 바로 객체의 `책임`이 된다.

# 3. 역할

## 역할과 협력

객체는 협력이라는 주어진 문맥 안에서 특정한 목적을 갖게 된다.

객체가 어떤 특정한 협력 안에서 수행하는 책임의 집합을 `역할`이라고 부른다.

협력을 모델링할 때는 특정한 객체가 아니라 역할에게 책임을 할당한다고 생각하는 게 좋다.

## 유연하고 재사용 가능한 협력

역할이 중요한 이유는 역할을 통해 유연하고 재사용 가능한 `협력`을 얻을 수 있기 때문이다.

객체가 아닌 책임에 초점을 맞춰야 한다.

역할이 두 종류의 구체적인 객체를 포괄하는 `추상화`라는 점에 주목해야 한다.

동일한 책임을 수행하는 역할을 기반으로 두 개의 협력을 하나로 통합할 수 있다.

따라서 역할을 이용하면 불필요한 중복 코드를 제거할 수 있다. 협력이 더 유연해졌다.

### 역할의 구현

역할을 구성하는 가장 일반적인 방법은 추상 클래스와 인터페이스를 사용하는 것이다.

협력의 관점에서 추상 클래스와 인터페이스는 구체 클래스들이 따라야 하는 책임의 집합을 서술한 것이다.

- `추상 클래스` - 책임의 일부를 구현
- `인터페이스` -  일체의 구현 없이 책임의 집합만을 나열

협력의 관점에서는 둘 모두 역할을 정의할 수 있는 구현 방법이라는 공통점을 공유한다.

동일한 책임을 수행하는 다양한 종류의 클래스들을 협력에 참여시킬 수 있는 확장 포인트를 제공한다.

동일한 책임을 수행할 수 있는 객체들을 협력 안에 수용할 수 있는 슬롯 같은 역할이다.

역할은 구체적인 객체들의 타입을 캡슐화 하는 추상화다.

`협력` 안에서 역할이 어떤 책임을 수행해야 하는지를 결정하는 것이 중요하다.

역할을 구현하는 것은 그 다음 문제다. 객체에게 중요한 것은 `행동`이며, 역할은 객체를 추상화해서 객체 자체가 아닌 협력에 초점을 맞출 수 있게 한다.

## 객체 대 역할

역할은 객체가 참여할 수 있는 일종의 슬롯이다.

협력에 참여하는 후보가 여러 종류의 객체에 의해 수행될 필요가 있다면 그 후보는 역할이 되지만 단지 한 종류의 객체만이 협력에 참여할 필요가 있다면 후보는 객체가 된다.

협력은 역할들의 상호작용으로 구성되고, 협력을 구성하기 위해 역할에 적합한 객체가 선택되며, 객체는 클래스를 이용해 구현되고 생성된다.

`협력`  → reference → `역할` → select from → `객체` → instance of→ `클래스`

설계 초반에는 적절한 책임과 협력의 큰 그림을 탐색하는 것이 가장 중요한 목표여야 하고 역할과 객체를 명확하게 구분하는 것은 그렇게 중요하지는 않다.

협력을 구체적인 객체가 아니라 추상적인 역할의 관점에서 설계하면 협력이 유연하고 재사용 가능해진다.

`역할`의 가장 큰 장점은 설계의 구성 요소를 추상화 할 수 있다는 것이다.

## 역할과 추상화

역할은 공통의 책임을 바탕으로 객체의 종류를 숨기기 때문에 이런 관점에서 역할을 객체의 추상화로 볼 수 있다.

- 세부 사항에 억눌리지 않고도 상위 수준의 정책을 쉽고 간단하게 표현할 수 있다.
- 불필요한 세부 사항을 생략하고 핵심적인 개념을 강조할 수 있다.

협력이라는 관점에서는 세부적인 사항을 무시하고 추상화에 집중하는 것이 유용하다.

상위 수준에서 협력을 설명하면 구체적인 객체들이 가지는 복잡성을 제거하고 단순화해서 표현할 수 있다.

객체에게 중요한 것은 행동이라는 사실을 기억하라.

역할이 중요한 이유는 동일한 협력을 수행하는 객체들을 추상화 할 수 있기 때문이다.

협력 안에서 동일한 책임을 수행하는 객체들은 동일한 역할을 수행하기 때문에 서로 대체 가능하다.

역할은 다양한 환경에서 다양한 객체들을 수용할 수 있게 해주므로 협력을 유연하게 만든다.

프레임워크나 디자인 패턴과 같이 재사용 가능한 코드나 설계 아이디어를 구성하는 핵심적인 요소가 바로 역할이다.

## 배우와 배역

- 배역은 연극 배우가 특정 연극에서 연기하는 역할이다.
- 배역은 연극이 상영되는 동안에만 존재하는 일시적인 개념이다.
- 연극이 끝나면 연극 배우는 배역이라는 역할을 벗어 버리고 원래의 연극 배우로 돌아온다.

- 서로 다른 배우들이 동일한 배역을 연기할 수 있다.
- 하나의 배우가 다양한 연극 안에서 서로 다른 배역을 연기할 수 있다.

연극 안에서 배역을 연기하는 배우라는 은유는 협력 안에서 `역할`을 수행하는 객체라는 관점이 가진 입체적인 측면들을 훌륭하게 담아낸다.

협력이라는 문맥 안에서 `역할`은 특정한 협력에 참여해서 책임을 수행하는 객체의 일부다.

역할은 객체가 협력에 참여하는 잠시 동안에만 존재하는 일시적인 개념이다.

역할은 모양이나 구조에 의해 정의될 수 없으며 오직 시스템의 문맥 안에서 무엇을 하는지에 의해서만 정의 될 수 있다. 역할은 객체의 페르소나다.

객체는 여러 역할을 가질 수 있지만 특정한 협력 안에서는 일시적으로 오직 하나의 역할만이 보여진다.

동일한 객체라고 하더라도 객체가 참여하는 협력에 따라 객체의 얼굴은 계속해서 바뀌게 된다.

객체는 다수의 역할을 보유할 수 있지만 객체가 참여하는 특정 협력은 객체의 한 가지 역할만 바라 볼 수 있다.

역할은 특정한 객체의 종류를 캡슐화하기 때문에 동일한 역할을 수행하고 계약을 준수하는 대체 가능한 객체들은 `다형적`이다.