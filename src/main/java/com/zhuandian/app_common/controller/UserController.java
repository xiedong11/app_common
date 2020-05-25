package com.zhuandian.app_common.controller;

import com.zhuandian.app_common.mapper.UserMapper;
import com.zhuandian.app_common.pojo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiedong
 * @DESC
 * @date 2020/5/25.
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/findUserById")
    public UserEntity findUserById(@RequestParam("id") String id) {
        return userMapper.findUserById(id);
    }
}
