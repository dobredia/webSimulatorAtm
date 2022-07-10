package com.honeywell.webapp.atm.services;

import com.honeywell.webapp.atm.dto.Card;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static com.honeywell.webapp.atm.Constants.ConstantsCard.URL_GET_CARD_INFORMATION;

public class CardService {
    private final RestTemplate restTemplate = new RestTemplate();

    public Card getCard(String cardNumber) {
        String urlGetCardInformation = URL_GET_CARD_INFORMATION + cardNumber;
        ResponseEntity<String> response = restTemplate.getForEntity(urlGetCardInformation, String.class);
        Card masterCard = restTemplate.getForObject(urlGetCardInformation, Card.class);
        return masterCard;
    }
}
