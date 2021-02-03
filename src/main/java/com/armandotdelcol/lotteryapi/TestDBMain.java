package com.armandotdelcol.lotteryapi;

import com.armandotdelcol.lotteryapi.entities.Bettor;
import com.armandotdelcol.lotteryapi.entities.LotteryTicket;
import com.armandotdelcol.lotteryapi.repositories.BettorRepository;
import com.armandotdelcol.lotteryapi.repositories.LotteryTicketRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.Random;

public class TestDBMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(LotteryApiApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);

        BettorRepository bettorRepository = applicationContext.getBean(BettorRepository.class);
        LotteryTicketRepository lotteryTicketRepository = applicationContext.getBean(LotteryTicketRepository.class);

        Bettor bettor1 = new Bettor();
        bettor1.setEmail("better1@gmail.com");
        bettorRepository.save(bettor1);

        Random betGenerator = new Random();
        LotteryTicket lotteryTicket1 = new LotteryTicket();
        lotteryTicket1.setBet1(betGenerator.nextInt(100));
        lotteryTicket1.setBet2(betGenerator.nextInt(100));
        lotteryTicket1.setBet3(betGenerator.nextInt(100));
        lotteryTicket1.setBet4(betGenerator.nextInt(100));
        lotteryTicket1.setBettor(bettor1);
        lotteryTicketRepository.save(lotteryTicket1);
    }

}
