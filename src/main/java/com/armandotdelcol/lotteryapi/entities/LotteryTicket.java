package com.armandotdelcol.lotteryapi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_lottery_tickets")
public class LotteryTicket implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer bet1;

    @Column(nullable = false)
    private Integer bet2;

    @Column(nullable = false)
    private Integer bet3;

    @Column(nullable = false)
    private Integer bet4;

    @ManyToOne
    @JoinColumn(name = "bettor_id", nullable = false)
    private Bettor bettor;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    public LotteryTicket() {
    }

    public LotteryTicket(Long id, Integer bet1, Integer bet2, Integer bet3, Integer bet4, Bettor bettor) {
        this.id = id;
        this.bet1 = bet1;
        this.bet2 = bet2;
        this.bet3 = bet3;
        this.bet4 = bet4;
        this.bettor = bettor;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Bettor getBettor() {
        return bettor;
    }

    public void setBettor(Bettor bettor) {
        this.bettor = bettor;
    }

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryTicket that = (LotteryTicket) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
