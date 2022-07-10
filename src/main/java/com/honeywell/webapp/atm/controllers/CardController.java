package com.honeywell.webapp.atm.controllers;


import com.honeywell.webapp.atm.dto.Card;
import com.honeywell.webapp.atm.services.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CardController {
    private
    CardService cardService= new CardService();

    @RequestMapping("/cards/{cardNumber}/balance")
    public String getCardByCardNumber(Model model, @PathVariable String cardNumber) {
        Card card = cardService.getCard(cardNumber);
        model.addAttribute("card", card);
        return "card";
    }

}
