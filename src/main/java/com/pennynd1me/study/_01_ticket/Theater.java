package com.pennynd1me.study._01_ticket;

import lombok.AllArgsConstructor;

@AllArgsConstructor
/** 소극장 */
public class Theater {
    private TicketSeller ticketSeller;

    /**
     * 관람객을 맞이 하는 메소드
     * @param audience  관람객
     * if: 관람객의 가방에 초대장이 있다면
     * 티켓 교환원이 매표소에서 티켓을 get 해서
     * 관람객의 가방에 set 해준다.
     * else: 관람객의 가방에 초대장이 없다면
     * 관람객의 가방에서 티켓 가격을 차감하고
     * 티켓 교환원의 매표소에 판매 금액을 더한 뒤
     * 관람객의 가방에 티켓을 set 해준다.
     */
    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
