package com.uob.hrSystem.Controllers;

import com.uob.hrSystem.Models.Account.Users;
import com.uob.hrSystem.Services.AccountService.AccountApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/account")
public class AccountController {


    @Autowired
    private AccountApplication accountApplication;

    @PostMapping("/add")
    private ResponseEntity<Users> addAccount(@RequestBody Users users){
        try {
            return ResponseEntity.ok().body(accountApplication.addAccount(users));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/edit/id/{id}")
    private ResponseEntity<Users> updateAccount(@PathVariable long id, @RequestBody Users users){
        try {
            return ResponseEntity.ok().body(accountApplication.updateAccount(users,id));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
