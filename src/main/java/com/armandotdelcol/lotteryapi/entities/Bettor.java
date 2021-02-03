package com.armandotdelcol.lotteryapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_bettors")
public class Bettor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy="bettor")
    @OrderBy("createdAt DESC")
    private Set<LotteryTicket> lotteryTickets;

    public Bettor() {
    }

    public Bettor(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<LotteryTicket> getLotteryTickets() {
        return lotteryTickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bettor bettor = (Bettor) o;
        return Objects.equals(id, bettor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
