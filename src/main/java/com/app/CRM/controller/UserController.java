package com.app.CRM.controller;

import com.app.CRM.model.AppUser;
import com.app.CRM.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/public/adduser")
    public ResponseEntity<String>  addUser(@RequestBody AppUser appUser){
        appUserService.addUser(appUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("User save successfully.");
    }

//    @GetMapping("/public")
//    public String publicApi(String st){
//        return "This is public.";
//    }
//
//    @GetMapping("/user")
//    public String userApi(String st){
//        return "This is user.";
//    }

    @GetMapping("/alluser")
    public List<AppUser> getAllUsers() {
        return appUserService.getAllUser();
    }

}