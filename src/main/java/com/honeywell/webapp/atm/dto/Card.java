package com.honeywell.webapp.atm.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Card implements Serializable {
    String cardNumber;
    String pin;
    Account accountInformation;

    public Card() {
    }

    public Card(String cardNumber, String pin, Account accountInformation) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.accountInformation = accountInformation;
    }

    public Card(String cardNumber, String pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
    }
}
