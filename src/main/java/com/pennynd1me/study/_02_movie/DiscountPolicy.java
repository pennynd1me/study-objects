package com.pennynd1me.study._02_movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 할인 정책을 표현하는 추상 클래스 */
public abstract class DiscountPolicy {
    /**
     * 할인 조건을 포함하는 List
     */
    private List<DiscountCondition> conditions = new ArrayList<>();

    /**
     * 할인 정책 생성자
     * @param conditions DiscountCondition 타입의 0개 이상의 조건
     */
    public DiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    /**
     * 전체 할인 조건에 대해 차례대로 isSatisfiedBy() 메소드를 호출하는 메소드
     * @param screening 상영
     * @return 만족하는 할인 요금; 만족하는 할인 조건이 없다면: Money.valueOf(0)
     */
    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    /**
     * 할인 금액을 확인하는 템플릿 메소드
     * @param screening 상영
     * @return Money 타입의 할인 받을 금액
     */
    abstract protected Money getDiscountAmount(Screening screening);
}
