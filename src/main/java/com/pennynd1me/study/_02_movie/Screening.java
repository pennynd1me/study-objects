package com.pennynd1me.study._02_movie;

import java.time.LocalDateTime;

/** 상영 정보를 표현하는 클래스 */
public class Screening {
    /** 상영할 영화 */
    private Movie movie;
    /** 순번 */
    private int sequence;
    /** 상영 시작 시간 */
    private LocalDateTime whenScreened;

    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    /**
     * 순번이 왔는지 안왔는지 확인하는 메소드
     * @param sequence  순번
     * @return if: 순번이 왔으면 true; else: false;
     */
    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
