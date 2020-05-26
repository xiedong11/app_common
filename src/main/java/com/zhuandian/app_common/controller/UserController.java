package com.zhuandian.app_common.controller;

import com.zhuandian.app_common.mapper.UserMapper;
import com.zhuandian.app_common.pojo.UserEntity;
import com.zhuandian.app_common.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/findUserByName")
    public UserEntity findUserByName(@RequestParam("name") String name) {
        return userMapper.findUserByName(name);
    }

    @PostMapping("/register")
    public Response register(@RequestBody UserEntity userEntity) {
        if (userEntity == null) {
            return Response.error(501, "参数不允许为空");
        }

        UserEntity user = userMapper.findUserByName(userEntity.getName());
        if (user == null) {
            userEntity.setId(System.currentTimeMillis() + "");
            userMapper.insertUser2DB(userEntity);
            Map<String, Object> map = new HashMap<>();
            map.put("data", userEntity);
            map.put("msg", "注册成功");
            return Response.ok(map);
        } else {
            return Response.error(502, "用户已经存在");
        }
    }
}
