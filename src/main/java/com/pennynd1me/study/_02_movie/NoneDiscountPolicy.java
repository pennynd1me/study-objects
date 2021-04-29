package com.pennynd1me.study._02_movie;

/**  할인 정책을 표현하는 DiscountPolicy 를 상속받는 할인 하지 않는 할인 정책 클래스 */
public class NoneDiscountPolicy extends DiscountPolicy {

    /**
     * 할인 금액을 확인하는 메소드
     * @param screening 상영
     * @return Money 타입의 0 (할인 금액이 없음)
     */
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
