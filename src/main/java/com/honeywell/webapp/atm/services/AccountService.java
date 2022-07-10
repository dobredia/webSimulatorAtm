package com.honeywell.webapp.atm.services;

import com.honeywell.webapp.atm.dto.Account;
import com.honeywell.webapp.atm.dto.Card;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static com.honeywell.webapp.atm.Constants.ConstantsAccount.URL_GET_ACCOUNT_INFORMATION;

public class AccountService {

    RestTemplate restTemplate = new RestTemplate();

    public Account getAccount(String id){
        String urlGetCardInformation = URL_GET_ACCOUNT_INFORMATION + id;
        ResponseEntity<String> response
                = restTemplate.getForEntity(urlGetCardInformation, String.class);
        Account account = restTemplate
                .getForObject(urlGetCardInformation, Account.class);
        return account;
    }


}
