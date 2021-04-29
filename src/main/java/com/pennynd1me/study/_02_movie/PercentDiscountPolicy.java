package com.pennynd1me.study._02_movie;

/** 할인 정책을 표현하는 DiscountPolicy 를 상속받는 비율 할인 정책 클래스 */
public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private double percent;

    /**
     * 비율 할인 정책 생성자
     * @param percent   할인율
     * @param conditions    할인 조건
     */
    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    /**
     * 할인 금액을 확인하는 메소드
     * @param screening 상영
     * @return 할인 비율을 곱해 할인된 금액
     */
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
