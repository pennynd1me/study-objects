package com.pennynd1me.study._02_movie;

import lombok.AllArgsConstructor;

/** 예매를 표현하는 클래스 */
@AllArgsConstructor
public class Reservation {
    /** 고객 */
    private Customer customer;
    /** 상영 정보 */
    private Screening screening;
    /** 예매 요금 */
    private Money fee;
    /** 인원 수 */
    private int audienceCount;

}
