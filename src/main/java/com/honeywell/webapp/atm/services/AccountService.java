package com.honeywell.webapp.atm.services;

import com.honeywell.webapp.atm.dto.Account;
import com.honeywell.webapp.atm.dto.Card;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static com.honeywell.webapp.atm.Constants.ConstantsAccount.*;
@Service
public class AccountService {

    RestTemplate restTemplate = new RestTemplate();

    public Account getAccount(String id){
        String urlGetCardInformation = URL_GET_ACCOUNT_INFORMATION + id;
        Account account = restTemplate.getForObject(urlGetCardInformation, Account.class);
        return account;
    }

    public Account updateBalance(Account account, String cash) {
        String urlPostAccountUpdateBalance = URL_ACCOUNT + account.getId() + URL_BALANCE + cash;
        HttpEntity<Account> requestEntity = new HttpEntity<>(account);
        account = restTemplate.postForObject(urlPostAccountUpdateBalance,requestEntity, Account.class);
        return account;
    }
}
