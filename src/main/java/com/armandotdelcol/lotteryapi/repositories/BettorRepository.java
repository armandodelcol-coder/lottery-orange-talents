package com.armandotdelcol.lotteryapi.repositories;

import com.armandotdelcol.lotteryapi.entities.Bettor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BettorRepository extends JpaRepository<Bettor, Long> {

    @Query("SELECT b FROM Bettor b WHERE b.email=:email")
    public Optional<Bettor> findByEmail(@Param("email") String email);

}
