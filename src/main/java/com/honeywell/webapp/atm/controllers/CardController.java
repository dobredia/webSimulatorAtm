package com.honeywell.webapp.atm.controllers;


import com.honeywell.webapp.atm.dto.Card;
import com.honeywell.webapp.atm.entities.CardEntity;
import com.honeywell.webapp.atm.services.CardService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class CardController {
    private
    CardService cardService= new CardService();
    @RequestMapping("/cards")
    public String getCards(Model model) {//throws URISyntaxException, IOException, InterruptedException {
       /*
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(new URI("http://localhost:8080/getBalance/1234123412341234"))
                .GET()
                .build();
        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        Map<String,String> mapCard =  convertWithStream(response.body());


        */

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/getBalance/1234123412341234";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl , String.class);
        Card masterCard = restTemplate
                .getForObject(fooResourceUrl , Card.class);


        List<Card> cards = new ArrayList<>();
        Card card1 = new Card();
        card1.setCardNumber("Diana");
        card1.setPin("111");

        Card card2 = new Card();
        card2.setCardNumber("Elena");
        card2.setPin("1242");

        cards.add(card1);
        cards.add(card2);

        model.addAttribute("cards", cards);
        return "cards";
    }

    @RequestMapping("/cards/{cardNumber}/balance")
    public String getCardByCardNumber(Model model, @PathVariable String cardNumber) {
        Card card = cardService.getCard(cardNumber);

        model.addAttribute("card", card);
        return "card";
    }

    @RequestMapping("/cards/{cardNumber}")
    public String getBalanceByCardNumber(Model model, @PathVariable String cardNumber) {
       Card card = cardService.getBalance(cardNumber);

        model.addAttribute("card", card);
        return "card";
    }

    public Map<String, String> convertWithStream(@NotNull String mapAsString) {
        Map<String, String> map = Arrays.stream(mapAsString.split(","))
                .map(entry -> entry.split("="))
                .collect(Collectors.toMap(entry -> entry[0], entry -> entry[1]));
        return map;
    }
}
