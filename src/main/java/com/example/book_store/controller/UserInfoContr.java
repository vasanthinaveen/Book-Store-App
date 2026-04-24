package com.example.book_store.controller;

import com.example.book_store.dto.UserInfoDTO;
import com.example.book_store.service.userInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-info")
public class UserInfoContr {
    @Autowired
    userInfoService userInfoService;
    @PostMapping("/register")
    public ResponseEntity<String> createUserInfo(@RequestBody UserInfoDTO userInfoDto)
    {
        UserInfoDTO userInfoDto1=userInfoService.createUser(userInfoDto);
        return new ResponseEntity<>("User "+userInfoDto.userName()+" is created", HttpStatus.CREATED);
    }

}
