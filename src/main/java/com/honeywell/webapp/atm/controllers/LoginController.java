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

@Controller
public class LoginController {
    @Autowired
    CardService cardService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login( Model model) {
        if (model.getAttribute("updateAccountSuccess") == null) {
            model.addAttribute("updateAccountSuccess", true);
        }
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RedirectView login(@RequestParam("cardNumber") String cardNumber, @RequestParam("pin") String pin, RedirectAttributes redirectAttributes) {
        RedirectView redirectView;
        Boolean isAuthenticated = cardService.login(cardNumber, pin);
        if (isAuthenticated) {
            Card card = cardService.getCard(cardNumber);
            redirectView = new RedirectView("/commands/" + card.getAccountInformation().getId(), true);
            redirectAttributes.addFlashAttribute("updateAccountSuccess", true);
        } else {
            redirectView = new RedirectView("/login", true);
            redirectAttributes.addFlashAttribute("updateAccountSuccess", false);
        }
        return redirectView;
    }


}