package com.hotelreservation.userservice.repository;

import com.hotelreservation.userservice.model.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance,Long> {

    Balance findByUserId(Long userid);
}
