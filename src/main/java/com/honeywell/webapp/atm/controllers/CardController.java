package com.honeywell.webapp.atm.controllers;


import com.honeywell.webapp.atm.dto.Card;
import com.honeywell.webapp.atm.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class CardController {
    @Autowired
    private CardService cardService;
    @Autowired
    private HttpSession session;


    @RequestMapping(value = "/changePin", method = RequestMethod.GET)
    public String changePin(Model model) {
        Object cardNumber = session.getAttribute("cardNumber");
        Card card = cardService.getCard((String) cardNumber);
        model.addAttribute("account", card.getAccountInformation());
        return "changePin";
    }

    @RequestMapping(value = "/changePin", method = RequestMethod.POST)
    public RedirectView changePin(Model model, @RequestParam("newPin") String newPin, RedirectAttributes redirectAttributes) {
        RedirectView redirectView = new RedirectView("/changePin", true);
        Boolean isChangePinSucessful = cardService.changePin(newPin);
        if (isChangePinSucessful) {
            redirectAttributes.addFlashAttribute("pinChanged", true);
        } else {
            redirectAttributes.addFlashAttribute("pinChanged", false);
        }
        Object cardNumber = session.getAttribute("cardNumber");
        Card card = cardService.getCard((String) cardNumber);
        model.addAttribute("account", card.getAccountInformation());
        return redirectView;
    }
}
