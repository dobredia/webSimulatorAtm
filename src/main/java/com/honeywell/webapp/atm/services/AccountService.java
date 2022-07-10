package com.honeywell.webapp.atm.services;

import com.honeywell.webapp.atm.dto.Account;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.honeywell.webapp.atm.Constants.ConstantsAccount.*;

@Service
public class AccountService {

    RestTemplate restTemplate = new RestTemplate();

    public Account getAccount(String id) {
        String urlGetCardInformation = URL_GET_ACCOUNT_INFORMATION + id;
        return restTemplate.getForObject(urlGetCardInformation, Account.class);
    }

    public Account updateBalance(@NotNull Account account, String cash) {
        String urlPostAccountUpdateBalance = URL_ACCOUNT + account.getId() + URL_BALANCE + cash;
        HttpEntity<Account> requestEntity = new HttpEntity<>(account);
        return  restTemplate.postForObject(urlPostAccountUpdateBalance, requestEntity, Account.class);
    }
}
