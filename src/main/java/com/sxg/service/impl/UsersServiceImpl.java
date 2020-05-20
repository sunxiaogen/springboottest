package com.sxg.service.impl;

import com.sxg.dao.UsersMapper;
import com.sxg.entity.Users;
import com.sxg.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional  //事务
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;


    @Override
//    @Cacheable :对当前查询的对象做缓存处理
//    @Cacheable("users")
    public List<Users> findUserAll() {

        return this.usersMapper.selectAll();
    }

    @Override
//    @Cacheable("users")
    public Users findUserById(Integer id) {
        return this.usersMapper.selectByPrimaryKey(id);
    }
}
