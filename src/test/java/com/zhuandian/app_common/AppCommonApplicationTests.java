package com.zhuandian.app_common;

import com.zhuandian.app_common.mapper.UserMapper;
import com.zhuandian.app_common.pojo.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppCommonApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {

//        testInsertUser();

        testFindUserById();
//
//        testDeleteUser();

        testInsertUser();

//        testUpdateUser();
//        testFindUserById();
    }

    private void testUpdateUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(123456);
        userEntity.setLocal("ll");
        userEntity.setPassword("132456");
        userEntity.setPhone("100886");
        userMapper.updateUser(userEntity);

    }

    private void testInsertUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setLocal("china");
        userEntity.setPassword("132456");
        userEntity.setPhone("100886");
        userMapper.insertUser2DB(userEntity);
    }

    private void testDeleteUser() {
        userMapper.deleteUserById("123456");
        System.out.println("删除成功");
    }

    private void testFindUserById() {
        UserEntity userById = userMapper.findUserById(123456);
        System.out.println(userById.toString());
    }

}
