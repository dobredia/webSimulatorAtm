package com.honeywell.webapp.atm.entities;

import com.honeywell.webapp.atm.dto.Card;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AccountEntity {

    Integer id;
    Double balance;
    String iban;
    List<Card> cardList = new ArrayList<>();

    public AccountEntity() {
    }

    public AccountEntity(Integer id, Double balance, String iban, List<Card> cardList) {
        this.id = id;
        this.balance = balance;
        this.iban = iban;
        this.cardList = cardList;
    }
}
