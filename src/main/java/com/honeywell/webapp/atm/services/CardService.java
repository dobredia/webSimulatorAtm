package com.honeywell.webapp.atm.services;

import com.honeywell.webapp.atm.dto.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

import static com.honeywell.webapp.atm.Constants.ConstantsCard.*;

@Service
public class CardService {
    public static final String CARD_NUMBER = "cardNumber";
    public static final String PIN = "pin";
    private final RestTemplate restTemplate = new RestTemplate();
    @Autowired
    HttpSession session;

    public Card getCard(String cardNumber) {
        String urlGetCardInformation = URL_GET_CARD_INFORMATION + cardNumber;
        return restTemplate.getForObject(urlGetCardInformation, Card.class);
    }

    public Boolean login(String cardNumber, String pin) {
        String urlPostLogin = URL_POST_LOGIN + URL_CARD_NUMBER + cardNumber + URL_PIN + pin;
        HttpEntity<Card> requestEntity = new HttpEntity<>(new Card(cardNumber, pin));
        int statusCode;
        try {
            ResponseEntity<Card> response = restTemplate.exchange(urlPostLogin, HttpMethod.POST, requestEntity, Card.class);

            statusCode = response.getStatusCode().value();
        } catch (HttpStatusCodeException e) {
            ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());
            statusCode = e.getStatusCode().value();
        }
        if (statusCode == 200) {
            session.setAttribute(CARD_NUMBER, cardNumber);
            session.setAttribute(PIN, pin);
        }

        return statusCode == 200;
    }

    public Boolean changePin(String newPin) {
        String cardNumber = (String) session.getAttribute(CARD_NUMBER);


        String urlPostChangePin = URL_CARD + cardNumber + URL_CHANGE_PIN + newPin;
        HttpEntity<Card> requestEntity = new HttpEntity<>(new Card(cardNumber, newPin));
        int statusCode;
        try {
            ResponseEntity<Card> response = restTemplate.exchange(urlPostChangePin, HttpMethod.POST, requestEntity, Card.class);
            statusCode = response.getStatusCode().value();
        } catch (HttpStatusCodeException e) {
            ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());
            statusCode = e.getStatusCode().value();
        }
        if (statusCode == 200) {
            session.setAttribute(PIN, newPin);
        }
        return statusCode == 200;

    }
}
