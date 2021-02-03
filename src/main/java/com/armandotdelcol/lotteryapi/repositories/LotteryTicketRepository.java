package com.armandotdelcol.lotteryapi.repositories;

import com.armandotdelcol.lotteryapi.entities.LotteryTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotteryTicketRepository extends JpaRepository<LotteryTicket, Long> {
}
