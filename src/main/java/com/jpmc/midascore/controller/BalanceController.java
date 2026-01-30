package com.jpmc.midascore.controller;

import com.jpmc.midascore.foundation.Balance;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.repository.UserRecordRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BalanceController {

    private final UserRecordRepository userRepository;

    public BalanceController(UserRecordRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/balance")
    public Balance getBalance(@RequestParam long userId) {

        Optional<UserRecord> userOpt = userRepository.findById(userId);

        if (userOpt.isEmpty()) {
            return new Balance(0);
        }

        return new Balance(userOpt.get().getBalance());
    }
}
