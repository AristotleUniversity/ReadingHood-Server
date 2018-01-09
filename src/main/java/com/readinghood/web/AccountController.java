/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readinghood.web;

import com.readinghood.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.readinghood.repository.AccountRepository;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/accounts") // This means URL's start with /demo (after Application path)
public class AccountController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private AccountRepository accountRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Account> getAllAccounts() {
        // This returns a JSON or XML with the users
        return accountRepository.findAll();
    }


    @GetMapping(path = "/findemail")
    public @ResponseBody
    Account getAccountByEmail(@RequestParam String email) {
        // This returns a JSON or XML with the users
        return accountRepository.findByEmail(email);
    }


    @GetMapping(path = "/findnamelike")
    public @ResponseBody
    Iterable<Account> getAccountsByUsername(@RequestParam String pattern) {
        // This returns a JSON or XML with the users
        return accountRepository.findByUsername(pattern);
    }

}
