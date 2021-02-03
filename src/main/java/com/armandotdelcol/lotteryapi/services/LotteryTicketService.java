package com.armandotdelcol.lotteryapi.services;

import com.armandotdelcol.lotteryapi.dto.LotteryTicketDTO;
import com.armandotdelcol.lotteryapi.entities.Bettor;
import com.armandotdelcol.lotteryapi.entities.LotteryTicket;
import com.armandotdelcol.lotteryapi.repositories.BettorRepository;
import com.armandotdelcol.lotteryapi.repositories.LotteryTicketRepository;
import com.armandotdelcol.lotteryapi.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LotteryTicketService {

    @Autowired
    private LotteryTicketRepository lotteryTicketRepository;

    @Autowired
    private BettorRepository bettorRepository;

    @Transactional
    public LotteryTicketDTO insert(LotteryTicketDTO dto) {
        // Random betGenerator = new Random();
        Bettor bettor = getOrCreateBettor(dto.getBettor().getEmail());
        LotteryTicket entity = new LotteryTicket();
        /* entity.setBet1(betGenerator.nextInt(100));
        entity.setBet2(betGenerator.nextInt(100));
        entity.setBet3(betGenerator.nextInt(100));
        entity.setBet4(betGenerator.nextInt(100)); */
        generateBets(bettor, entity);
        entity.setBettor(bettor);
        entity = lotteryTicketRepository.save(entity);
        return new LotteryTicketDTO(entity);
    }

    @Transactional
    public List<LotteryTicketDTO> findAllByEmail(LotteryTicketDTO dto) {
        Optional<Bettor> obj = bettorRepository.findByEmail(dto.getBettor().getEmail());
        Set<LotteryTicket> lotteryTickets = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found.")).getLotteryTickets();
        List<LotteryTicketDTO> dtoList = lotteryTickets.stream().map(x -> new LotteryTicketDTO(x)).collect(Collectors.toList());
        return dtoList;
    }

    @Transactional
    private Bettor getOrCreateBettor(String email) {
        Optional<Bettor> obj = bettorRepository.findByEmail(email);
        try {
            return obj.get();
        } catch (Exception e) {
            Bettor bettor = new Bettor();
            bettor.setEmail(email);
            return bettorRepository.save(bettor);
        }
    }

    @Transactional
    private void generateBets(Bettor bettor, LotteryTicket entity) {
        Boolean allRight = false;
        Random betGenerator = new Random();
        Integer attempedBet1 = betGenerator.nextInt(100);
        Integer attempedBet2 = betGenerator.nextInt(100);
        Integer attempedBet3 = betGenerator.nextInt(100);
        Integer attempedBet4 = betGenerator.nextInt(100);
        Optional<Bettor> obj = bettorRepository.findByEmail(bettor.getEmail());
        Set<LotteryTicket> lotteryTickets = obj.get().getLotteryTickets();
        try {
            for (LotteryTicket lotteryTicket : lotteryTickets) {
                List<Integer> bets = new ArrayList<>();
                bets.add(lotteryTicket.getBet1());
                bets.add(lotteryTicket.getBet2());
                bets.add(lotteryTicket.getBet3());
                bets.add(lotteryTicket.getBet4());
                if (!bets.contains(attempedBet1) &&
                        !bets.contains(attempedBet2) &&
                        !bets.contains(attempedBet3) &&
                        !bets.contains(attempedBet4)) {
                    allRight = true;
                }
            }
            if (!allRight) {
                generateBets(bettor, entity);
            } else {
                entity.setBet1(betGenerator.nextInt(100));
                entity.setBet2(betGenerator.nextInt(100));
                entity.setBet3(betGenerator.nextInt(100));
                entity.setBet4(betGenerator.nextInt(100));
            }
        } catch (Exception e) {
            entity.setBet1(betGenerator.nextInt(100));
            entity.setBet2(betGenerator.nextInt(100));
            entity.setBet3(betGenerator.nextInt(100));
            entity.setBet4(betGenerator.nextInt(100));
        }
    }

}
