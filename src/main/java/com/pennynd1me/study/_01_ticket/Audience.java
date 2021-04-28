package com.pennynd1me.study._01_ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 관람객
 */
@AllArgsConstructor
public class Audience {
    private Bag bag;

    /**
     * 관람객이 티켓을 구매하는 메소드
     *
     * @param ticket 티켓
     * @return if : 초대장이 있다면 0L
     * else : 초대장이 없다면 ticket.getFee()  티켓의 가격
     * 초대장이 없다면 내 가방에서 티켓의 가격만큼 지불한다.
     */
    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }

    // 관람객의 가방의 금액을 테스트 하기 위한 getter
    public Bag getBag() {
        return bag;
    }
}

