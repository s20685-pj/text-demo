package com.example.textdemo.service;

import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;
import com.example.textdemo.repository.AccountRepository;
import com.example.textdemo.model.Account;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void save(Account account){
        accountRepository.save(account);
    }

    public List<Account> getAllAcounts(){
        return accountRepository.getAll();
    }

    public Account findAccountById(Long id){
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()){
            return optionalAccount.get();
        } else {
            throw new RuntimeException();
        }
    }

    public Account withdraw(long id, double balance){
        if (balance > accountRepository.findById(id).get().getBalance()){
            throw new RuntimeException();
        }
       return accountRepository.withdraw(id, balance);
    }


}
