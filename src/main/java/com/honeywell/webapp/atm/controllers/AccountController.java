package com.honeywell.webapp.atm.controllers;

import com.honeywell.webapp.atm.dto.Account;
import com.honeywell.webapp.atm.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    private void setAccountModel(Model model, String id) {
        Account account = accountService.getAccount(id);
        model.addAttribute("account", account);
    }

    private void updateCash(String id, Double balance, RedirectAttributes redirectAttributes) {
        Account account = accountService.getAccount(id);
        accountService.updateBalance(account, balance.toString());
        redirectAttributes.addFlashAttribute("account", account);
        redirectAttributes.addFlashAttribute("updateAccountSuccess", true);
    }

    @RequestMapping("/account/{id}/balance")
    public String getBalance(Model model, @PathVariable String id){
        setAccountModel(model, id);
        return "accountBalance";
    }

    @RequestMapping(value = "/account/{id}/withdrawCash", method = RequestMethod.GET)
    public String withdrawCash(Model model, @PathVariable String id){
        setAccountModel(model, id);
        return "withdrawCash";
    }

    @RequestMapping(value = "/account/{id}/depositCash", method = RequestMethod.GET)
    public String depositCash(Model model, @PathVariable String id){
        setAccountModel(model, id);
        return "depositCash";
    }

    @RequestMapping(value = "/account/{id}/withdrawCash", method = RequestMethod.POST)
    public RedirectView withdrawCash( @RequestParam("balance1") Double balance, @PathVariable String id, RedirectAttributes redirectAttributes){
        final RedirectView redirectView = new RedirectView("/account/"+id+"/withdrawCash", true);
        updateCash(id, -balance, redirectAttributes);
        return redirectView;
    }

    @RequestMapping(value = "/account/{id}/depositCash", method = RequestMethod.POST)
    public RedirectView depositCash( @RequestParam("balance1") Double balance, @PathVariable String id, RedirectAttributes redirectAttributes){
        final RedirectView redirectView = new RedirectView("/account/"+id+"/depositCash", true);
        updateCash(id, balance, redirectAttributes);
        return redirectView;
    }
}
