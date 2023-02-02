package com.example.textdemo.service;

import com.example.textdemo.model.Account;
import com.example.textdemo.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AccountServiceTest {

    private final AccountRepository accountRepository = mock(AccountRepository.class);
    private final AccountService accountService = new AccountService(accountRepository);

    @Test
    void shouldReturnAccountById(){
        //given
        long id = 5;
        Account testAccount = new Account(id, "Kuba", "Merta", 1500.0);
        //when
        Mockito.when(accountRepository.findById(5L)).thenReturn(Optional.of(testAccount));
        Account result = accountService.findAccountById(5L);
        //then
        Assertions.assertEquals(result, testAccount);
    }


}