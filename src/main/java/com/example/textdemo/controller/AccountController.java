package com.example.textdemo.controller;


import com.example.textdemo.model.Account;
import com.example.textdemo.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/register")
    public void registerAccount(@RequestBody Account account){
        accountService.save(account);
    }

    @GetMapping("/FindAll")
    public List<Account> showAllAccount(){
        return this.accountService.getAllAcounts();
    }

    @GetMapping("/FindById")
    public Account findById(@RequestParam long id){
        return accountService.findAccountById(id);
    }
    @PostMapping("/withdraw")
    public Account withDraw(@RequestParam long id, @RequestParam double balance){
            return accountService.withdraw(id, balance);
    }
}
