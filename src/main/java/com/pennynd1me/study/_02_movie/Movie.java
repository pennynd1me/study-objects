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

    /**
     * 할인 정책을 교체하는 setter 메소드
     * @param discountPolicy    할인 정책
     */
    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
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
