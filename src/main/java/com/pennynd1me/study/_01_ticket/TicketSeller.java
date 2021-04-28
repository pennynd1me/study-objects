package com.pennynd1me.study._01_ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
/** 티켓 판매원 : 초대장을 티켓으로 교환해주거나 티켓을 판매한다. */
public class TicketSeller {
    /** 자신이 일하는 매표소 */
    private TicketOffice ticketOffice;

    /**
     * 판매원이 티켓을 판매하는 메소드
     * @param audience
     * 관람객에게 매표소의 티켓을 가져와 판매한다.
     * 그 티켓의 금액만큼 자신이 일하는 매표소에 더해준다.
     */
    public void sellTo(Audience audience) {
        ticketOffice.sellTicketTo(audience);
    }

    // 판매원의 매표소를 테스트 하기 위한 getter
    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }
}
