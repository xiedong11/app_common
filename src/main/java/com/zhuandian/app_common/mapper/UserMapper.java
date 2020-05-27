package com.zhuandian.app_common.mapper;

import com.zhuandian.app_common.pojo.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author xiedong
 * @desc
 * @date 2020/5/25.
 */
@Mapper
@Repository
public interface UserMapper {

    UserEntity findUserById(long id);

    UserEntity findUserByName(String name);

    void deleteUserById(String id);

    void insertUser2DB(UserEntity userEntity);

    void updateUser(UserEntity userEntity);
}
