package com.armandotdelcol.lotteryapi.controllers;

import com.armandotdelcol.lotteryapi.dto.LotteryTicketDTO;
import com.armandotdelcol.lotteryapi.services.LotteryTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lottery_tickets")
public class LotteryTicketsController {

    @Autowired
    private LotteryTicketService lotteryTicketService;

    @GetMapping
    public ResponseEntity<List<LotteryTicketDTO>> findAllByEmail(@RequestBody LotteryTicketDTO dto) {
        List<LotteryTicketDTO> dtoList = lotteryTicketService.findAllByEmail(dto);
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping
    public ResponseEntity<LotteryTicketDTO> insert(@RequestBody LotteryTicketDTO dto) {
        dto = lotteryTicketService.insert(dto);
        return ResponseEntity.ok().body(dto);
    }

}
