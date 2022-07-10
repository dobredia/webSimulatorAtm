package com.honeywell.webapp.atm.services;

import com.honeywell.webapp.atm.dto.Card;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import static com.honeywell.webapp.atm.Constants.ConstantsCard.*;

public class CardService {
    private final RestTemplate restTemplate = new RestTemplate();

    public Card getCard(String cardNumber) {
        String urlGetCardInformation = URL_GET_CARD_INFORMATION + cardNumber;
        return restTemplate.getForObject(urlGetCardInformation, Card.class);
    }

    public Boolean login(String cardNumber, String pin){
        String urlPostLogin = URL_POST_LOGIN + URL_CARD_NUMBER + cardNumber + URL_PIN + pin;
        HttpEntity<Card> requestEntity = new HttpEntity<>(new Card(cardNumber,pin));
        int   statusCode;
        try {
            ResponseEntity<Card> response = restTemplate.exchange(urlPostLogin, HttpMethod.POST, requestEntity, Card.class);
            statusCode = response.getStatusCode().value();
        }catch(HttpStatusCodeException e) {
            ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());
            statusCode =  e.getStatusCode().value();
        }

        return  statusCode== 200;
    }
}
