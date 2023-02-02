package com.example.textdemo.repository;


import com.example.textdemo.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepository {

    private final List<Account> accountList = new ArrayList<>();


    public void save(Account account){
        accountList.add(account);
    }

    public List<Account> getAll(){
        return this.accountList;
    }

    public Optional<Account> findById(Long id){
        return accountList.stream()
                .filter(account -> account.getId() == id)
                .findFirst();
    }

    public Account withdraw(Long id, double balance){
        Account account = findById(id).get();
        account.setBalance(account.getBalance()-balance);
        return account;
    }
}
