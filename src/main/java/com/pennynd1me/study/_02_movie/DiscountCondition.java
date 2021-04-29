package com.pennynd1me.study._02_movie;

/** 할인 조건을 표현하는 인터페이스 */
public interface DiscountCondition {
    /**
     * 할인을 받을 수 있는지 없는지 확인하는 interface 메소드
     * @param screening 상영
     * @return if: 할인이 가능하다면 = true; else: false;
     */
    boolean isSatisfiedBy(Screening screening);
}
