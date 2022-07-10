package com.honeywell.webapp.atm.entities;

import com.honeywell.webapp.atm.dto.Account;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CardEntity {
    Integer id;
    String cardNumber;
    String pin;
    Account accountInformation;

    public CardEntity() {
    }

    public CardEntity(Integer id, String cardNumber, String pin, Account accountInformation) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.accountInformation = accountInformation;
    }
}
