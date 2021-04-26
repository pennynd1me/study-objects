package com.pennynd1me.study._01_ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 매표소 */
public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
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
}
