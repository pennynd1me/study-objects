package com.pennynd1me.study._01_ticket;

import java.util.ArrayList;
import java.util.List;

/** 매표소 */
public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, List<Ticket> tickets) {
        this.amount = amount;
        this.tickets = tickets;
    }

    /**
     * 관람객에게 티켓을 판매하는 메소드
     * @param audience  관람객
     * 티켓을 관람객에게 판매하고, 그 금액만큼 매표소에 금액을 더한다.
     */
    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }

    /**
     * 판매할 티켓을 꺼내준다.
     * @return Ticket 컬렉션의 index: 0
     */
    public Ticket getTicket() {
        return tickets.remove(0);
    }

    /** 판매 금액을 차감한다. */
    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    /** 판매 금액을 더한다. */
    public void plusAmount(Long amount) {
        this.amount += amount;
    }

    // 매표소의 금액을 테스트하기 위한 getter
    public Long getAmount() {
        return amount;
    }
}
