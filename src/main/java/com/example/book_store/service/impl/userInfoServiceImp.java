package com.example.book_store.service.impl;

import com.example.book_store.dto.UserInfoDTO;
import com.example.book_store.entity.userInfo;
import com.example.book_store.mapper.UserInfoMap;
import com.example.book_store.repository.userInfoRepo;
import com.example.book_store.service.userInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userInfoServiceImp implements userInfoService {
    @Autowired
    userInfoRepo userinfoRepo;
    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public UserInfoDTO createUser(UserInfoDTO userInfoDto)
    {
        userInfo userinfo= UserInfoMap.toEntity(userInfoDto);
        userinfo.setPassword(passwordEncoder.encode(userinfo.getPassword()));
        userinfoRepo.save(userinfo);
        return UserInfoMap.toDto(userinfo);
    }
}
