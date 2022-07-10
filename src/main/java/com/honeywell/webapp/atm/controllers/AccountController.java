package com.honeywell.webapp.atm.controllers;

import com.honeywell.webapp.atm.dto.Account;
import com.honeywell.webapp.atm.services.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {
    AccountService accountService = new AccountService();

    @RequestMapping("/account/{id}/balance")
    public String getCards(Model model, @PathVariable String id){
        Account account = accountService.getAccount(id);

        model.addAttribute("account", account);
        return "accountBalance";
    }
}
