package com.honeywell.webapp.atm.controllers;

import com.honeywell.webapp.atm.dto.Account;
import com.honeywell.webapp.atm.dto.Card;
import com.honeywell.webapp.atm.entities.CardEntity;
import com.honeywell.webapp.atm.services.AccountService;
import com.honeywell.webapp.atm.services.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommandsController {
    AccountService accountService = new AccountService();

    @RequestMapping("/commands/{id}")
    public String getCommandsList(Model model, @PathVariable  String id) {
        Account account = accountService.getAccount(id);
       model.addAttribute("account", account);
        return "commands";
    }
}