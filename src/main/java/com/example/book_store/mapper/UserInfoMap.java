package com.example.book_store.mapper;

import com.example.book_store.dto.UserInfoDTO;
import com.example.book_store.entity.userInfo;

public class UserInfoMap {
    public static UserInfoDTO toDto(userInfo userInfo)
    {
        return new UserInfoDTO(userInfo.getUserName(),userInfo.getPassword(),userInfo.getRoles());
    }
    public static userInfo toEntity(UserInfoDTO userInfoDTO)
    {
       return new userInfo(userInfoDTO.userName(),userInfoDTO.password(),userInfoDTO.role());
    }
}

