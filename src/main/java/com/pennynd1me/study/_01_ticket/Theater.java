package com.pennynd1me.study._01_ticket;

import lombok.AllArgsConstructor;

@AllArgsConstructor
/** 소극장 */
public class Theater {
    private TicketSeller ticketSeller;

    /**
     * 관람객을 맞이 하는 메소드
     * @param audience  관람객
     * 판매원이 관람객을 맞이한다.
     */
    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }

    // 소극장의 판매원을 테스트하기 위한 getter
    public TicketSeller getTicketSeller() {
        return ticketSeller;
    }
}
