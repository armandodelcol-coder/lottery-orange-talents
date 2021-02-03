package com.armandotdelcol.lotteryapi.dto;

import com.armandotdelcol.lotteryapi.entities.Bettor;
import com.armandotdelcol.lotteryapi.entities.LotteryTicket;

import java.io.Serializable;

public class LotteryTicketDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer bet1;
    private Integer bet2;
    private Integer bet3;
    private Integer bet4;
    private Bettor bettor;

    public LotteryTicketDTO() {
    }

    public LotteryTicketDTO(Long id, Integer bet1, Integer bet2, Integer bet3, Integer bet4, Bettor bettor) {
        this.id = id;
        this.bet1 = bet1;
        this.bet2 = bet2;
        this.bet3 = bet3;
        this.bet4 = bet4;
        this.bettor = bettor;
    }

    public LotteryTicketDTO(LotteryTicket entity) {
        this.id = entity.getId();
        this.bet1 = entity.getBet1();
        this.bet2 = entity.getBet2();
        this.bet3 = entity.getBet3();
        this.bet4 = entity.getBet4();
        this.bettor = entity.getBettor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBet1() {
        return bet1;
    }

    public void setBet1(Integer bet1) {
        this.bet1 = bet1;
    }

    public Integer getBet2() {
        return bet2;
    }

    public void setBet2(Integer bet2) {
        this.bet2 = bet2;
    }

    public Integer getBet3() {
        return bet3;
    }

    public void setBet3(Integer bet3) {
        this.bet3 = bet3;
    }

    public Integer getBet4() {
        return bet4;
    }

    public void setBet4(Integer bet4) {
        this.bet4 = bet4;
    }

    public Bettor getBettor() {
        return bettor;
    }

    public void setBettor(Bettor bettor) {
        this.bettor = bettor;
    }

}
