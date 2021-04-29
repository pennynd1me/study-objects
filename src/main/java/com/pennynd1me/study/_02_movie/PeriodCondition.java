package com.pennynd1me.study._02_movie;

import lombok.AllArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;

/** 기간 조건을 표현하는 클래스 */
@AllArgsConstructor
public class PeriodCondition implements DiscountCondition {
    /** 요일 */
    private DayOfWeek dayOfWeek;
    /** 시작 시간 */
    private LocalTime startTime;
    /** 종료 시간 */
    private LocalTime endTime;

    /**
     * 기간 조건을 기준으로 할인 여부를 판단하는 메소드
     * @param screening 상영
     * @return screening의 상영 요일이 dayOfWeek과 같고 && 상영 시작 시간이 startTime과 endTime 사이에 있을 경우 true; 그 외 false;
     */
    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
                startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 &&
                endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }
}
