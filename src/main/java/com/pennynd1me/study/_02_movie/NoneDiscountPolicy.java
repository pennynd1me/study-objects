package com.pennynd1me.study._02_movie;

/** 할인 정책을 표현하는 DiscountPolicy 를 구현하는 할인 하지 않는 할인 정책 클래스 */
public class NoneDiscountPolicy implements DiscountPolicy {

    /**
     * 할인 금액을 계산하는 메소드
     * @param screening 상영
     * @return Money 타입의 ValueOf(0) (할인 금액 없음)
     */
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
