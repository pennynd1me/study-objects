package com.pennynd1me.study._01_ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
/** 티켓 판매원 : 초대장을 티켓으로 교환해주거나 티켓을 판매한다. */
public class TicketSeller {
    /** 자신이 일하는 매표소 */
    @Getter private TicketOffice ticketOffice;

}
