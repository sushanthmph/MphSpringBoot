package com.mphasis.tfp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.SaveTransactions;


@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private SaveTransactions saveTransactions;

    @PostMapping("/upload")
    public String upload(@RequestBody String input) {

        saveTransactions.saveTransaction(input);

        return "Transaction saved successfully";
    }
}