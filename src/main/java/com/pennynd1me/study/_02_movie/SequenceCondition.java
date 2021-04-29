package com.pennynd1me.study._02_movie;

import lombok.AllArgsConstructor;

/** 순번 조건을 표현하는 클래스 */
@AllArgsConstructor
public class SequenceCondition implements DiscountCondition {
    /** 순번 */
    private int sequence;

    /**
     * 상영 순번을 기준으로 할인 여부를 판단하는 메소드
     * @param screening 상영
     * @return 할인이 가능한 순번이라면 = true; else: false;
     */
    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
