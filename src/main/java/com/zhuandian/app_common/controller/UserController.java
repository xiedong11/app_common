package com.zhuandian.app_common.controller;

import cn.hutool.json.JSONObject;
import com.zhuandian.app_common.mapper.UserMapper;
import com.zhuandian.app_common.pojo.UserEntity;
import com.zhuandian.app_common.utils.Response;
import com.zhuandian.app_common.utils.StringUtils;
import com.zhuandian.app_common.utils.TimeUtils;
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
            userEntity.setCreateAt(TimeUtils.getTimeFormat());
            userEntity.setUpdateAt(TimeUtils.getTimeFormat());
            userMapper.insertUser2DB(userEntity);
            Map<String, Object> map = new HashMap<>();
            map.put("data", userEntity);
            map.put("msg", "注册成功");
            return Response.ok(map);
        } else {
            return Response.error(502, "用户已经存在");
        }
    }

    @PostMapping("/login")
    public Response login(@RequestBody JSONObject jsonObject) {
        if (jsonObject == null) {
            return Response.error(501, "参数不允许为空");
        }

        String userName = (String) jsonObject.get("name");
        String password = (String) jsonObject.get("password");

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            return Response.error(501, "参数不允许为空");
        }

        UserEntity userEntity = userMapper.findUserByName(userName);
        if (userEntity == null) {
            return Response.error(503, "用户不存在");
        } else if (userEntity.getPassword().equals(password)) {
            Map<String, Object> map = new HashMap<>();
            map.put("data", userEntity);
            map.put("msg", "登陆成功");
            return Response.ok(map);
        } else {
            return Response.error();
        }
    }
}
