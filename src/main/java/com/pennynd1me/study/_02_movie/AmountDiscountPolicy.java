package com.pennynd1me.study._02_movie;

/** 할인 정책을 표현하는 DiscountPolicy 를 상속받는 금액 할인 정책 클래스 */
public class AmountDiscountPolicy extends DefaultDiscountPolicy {
    /** 할인 요금 */
    private Money discountAmount;

    /**
     * 금액 할인 정책 생성자
     * @param discountAmount    할인 금액
     * @param conditions    0개 이상의 할인 조건
     */
    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    /**
     * 할인 금액을 확인하는 메소드
     * @param screening 상영
     * @return discountAmount 할인 금액
     */
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
