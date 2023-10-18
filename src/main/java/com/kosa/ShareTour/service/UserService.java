package com.kosa.ShareTour.service;

import com.kosa.ShareTour.dto.UserListDto;

import java.util.List;

public interface UserService {

    List<UserListDto> getAllUsers();
    UserListDto getUserById(Long userId);

}
