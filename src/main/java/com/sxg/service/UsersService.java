package com.sxg.service;

import com.sxg.entity.Users;

import java.util.List;

public interface UsersService {
    List<Users> findUserAll();

    Users findUserById(Integer id);
}
