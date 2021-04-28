package com.pennynd1me.study._01_ticket;

import lombok.Getter;

/** 관람객의 소지품 가방 */
public class Bag {
    @Getter private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    // 인스턴스 생성 시점에 제약 강제
    /**
     * 초대장을 받지 못한 관람객
     * @param amount    현금
     */
    public Bag(long amount) {
        this(null, amount);
    }

    /**
     * 초대장을 받은 관람객
     * @param invitation    초대장
     * @param amount        현금
     */
    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    /**
     * 가방의 행위를 표현하는 메소드
     * @param ticket
     * @return if : 초대장이 있다면 0L
     * else : ticket.getFee()   티켓의 가격
     */
    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
    /**
     * 관람객이 초대장을 가지고 있다면 true 를 리턴한다.
     * @return invitation != null
     */
    private boolean hasInvitation() {
        return invitation != null;
    }

    /**
     * 관람객이 티켓을 가지고 있다면 true 를 리턴한다.
     * @return ticket != null
     */
    public boolean hasTicket() {
        return ticket != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
