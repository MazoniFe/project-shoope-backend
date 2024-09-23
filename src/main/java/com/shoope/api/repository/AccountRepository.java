package com.shoope.api.repository;

import com.shoope.api.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT * FROM account WHERE email = :email", nativeQuery = true)
    Optional<Account> findByEmail(String email);

    @Query(value = "SELECT * FROM account WHERE email = :email AND password = :password", nativeQuery = true)
    Optional<Account> findByEmailAndPassword(String email, String password);
}