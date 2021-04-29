package com.pennynd1me.study._02_movie;

import java.math.BigDecimal;

/** 금액과 관련된 다양한 계산을 구현하는 클래스 */
public class Money {
    public static final Money ZERO = Money.wons(0);

    private final BigDecimal amount;

    /**
     * Money 인스턴스를 생성하는 메소드
     * @param amount    long 타입
     * @return BigDecimal 타입의 Money 인스턴스
     */
    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    /**
     * Money 인스턴스를 생성하는 메소드
     * @param amount    double 타입
     * @return BigDecimal 타입의 Money 인스턴스
     */
    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    /**
     * Money 생성자
     * @param amount    BigDecimal 타입
     */
    Money(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 금액을 더하는 메소드
     * @param amount    Money 타입
     * @return  this.amount(BigDecimal).add(Money.amount)의 값을 가진 Money 인스턴스
     */
    public Money plus(Money amount) {
        return new Money(this.amount.add(amount.amount));
    }
    /**
     * 금액을 차감하는 메소드
     * @param amount    Money 타입
     * @return this.amount(BigDecimal).subtract(Money.amount)의 값을 가진 Money 인스턴스
     */
    public Money minus(Money amount) {
        return new Money(this.amount.subtract(amount.amount));
    }

    /**
     * 비율 할인 정책으로 할인받은 금액을 구하는 메소드
     * @param percent   double 타입
     * @return this.amount(BigDecimal).multiply(BigDecimal.valueOf(percent))의 값을 가진 Money 인스턴스
     */
    public Money times(double percent) {
        return new Money(this.amount.multiply(
                BigDecimal.valueOf(percent)));
    }

    /**
     * 금액이 더 작은지 비교하는 메소드
     * @param other Money 타입
     * @return 작다면 True, 크거나 같으면 False
     */
    public boolean isLessThan(Money other) {
        return amount.compareTo(other.amount) < 0;
    }

    /**
     * 금액이 크거나 같은지 비교하는 메소드
     * @param other Money 타입
     * @return 크거나 같다면 True, 작다면 False
     */
    public boolean isGreaterThanOrEqual(Money other) {
        return amount.compareTo(other.amount) >= 0;
    }

}
