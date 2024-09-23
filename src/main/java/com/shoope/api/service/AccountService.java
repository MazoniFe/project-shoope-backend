package com.shoope.api.service;

import com.shoope.api.dtos.InsertAccountDTO;
import com.shoope.api.entity.Account;
import com.shoope.api.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public ResponseEntity<?> register(InsertAccountDTO data) {
        try {
            Account account = repository.save(new Account(null,data.email(), data.password()));
            return ResponseEntity.ok(account);
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public Page<Account> selectAccounts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public ResponseEntity<?> deleteById(Long id) {
        try {
            Account account = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Account not found."));
            repository.delete(account);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public Account selectAccountByEmail(String email) {
        try {
            return repository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("Bad Credentials"));
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
