package com.honeywell.webapp.atm.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Account implements Serializable {
    Integer id;
    Double balance;
    String iban;
    List<Card> cardList = new ArrayList<>();

    public Account() {
    }

    public Account(Integer id, Double balance, String iban, List<Card> cardList) {
        this.id = id;
        this.balance = balance;
        this.iban = iban;
        this.cardList = cardList;
    }

}
