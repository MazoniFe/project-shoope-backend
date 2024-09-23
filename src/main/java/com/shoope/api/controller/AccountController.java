package com.shoope.api.controller;

import com.shoope.api.dtos.InsertAccountDTO;
import com.shoope.api.dtos.LoginDTO;
import com.shoope.api.entity.Account;
import com.shoope.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping
    public ResponseEntity<?> insertRouteProcess (@RequestBody InsertAccountDTO data) {
        return service.register(data);
    }

    @GetMapping
    public Page<Account> getAccounts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.selectAccounts(pageable);
    }

    @PostMapping("/login")
    public ResponseEntity<?> getAccountByEmail(@RequestBody LoginDTO data) {
        return service.selectAccountByEmailAndPassword(data.email(), data.password());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAllData(@PathVariable Long id) {
        return service.deleteById(id);
    }
}
