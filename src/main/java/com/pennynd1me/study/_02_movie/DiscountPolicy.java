package com.pennynd1me.study._02_movie;

/** 할인 정책을 표현하는 인터페이스 */
public interface DiscountPolicy {
    /**
     * 할인 금액을 계산하는 interface 메소드
     * @param screening 상영
     * @return  할인 금액
     */
    Money calculateDiscountAmount(Screening screening);
}
