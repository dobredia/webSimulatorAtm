package com.honeywell.webapp.atm.controllers;

import com.honeywell.webapp.atm.dto.Account;
import com.honeywell.webapp.atm.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommandsController {
    @Autowired
    AccountService accountService;

    @RequestMapping("/commands/{id}")
    public String getCommandsList(Model model, @PathVariable String id) {
        Account account = accountService.getAccount(id);
        model.addAttribute("account", account);
        return "commands";
    }
}
