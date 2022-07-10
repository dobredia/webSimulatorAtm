package com.honeywell.webapp.atm.controllers;


import com.honeywell.webapp.atm.dto.Card;
import com.honeywell.webapp.atm.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CardController {
    private@Autowired
    CardService cardService;

    @RequestMapping("/cards/{cardNumber}/balance")
    public String getCardByCardNumber(Model model, @PathVariable String cardNumber) {
        Card card = cardService.getCard(cardNumber);
        model.addAttribute("card", card);
        return "card";
    }

    @RequestMapping(value = "/changePin", method = RequestMethod.GET)
    public String changePin( Model model) {
        if (model.getAttribute("updateAccountSuccess") == null) {
            model.addAttribute("updateAccountSuccess", true);
        }
        return "changePin";
    }

    @RequestMapping(value = "/changePin", method = RequestMethod.POST)
    public RedirectView changePin(@RequestParam("newPin") String newPin, RedirectAttributes redirectAttributes) {
        RedirectView redirectView;
        Boolean isChangePinSucessful = cardService.changePin(newPin);
        redirectView = new RedirectView("/changePin", true);
        if (isChangePinSucessful) {
            redirectAttributes.addFlashAttribute("updateAccountSuccess", true);
        } else {
            redirectAttributes.addFlashAttribute("updateAccountSuccess", false);
        }
        return redirectView;
    }

}
