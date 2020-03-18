/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UserServiceImpl
 * Author:   Administrator
 * Date:     2020-03-05 17:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.myVueDemo.service.internal;


import com.example.myVueDemo.entity.UserEntity;
import com.example.myVueDemo.repository.UserRepository;
import com.example.myVueDemo.service.UserService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020-03-05
 * @since 1.0.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserEntity create(UserEntity userEntity) {

        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> users = userRepository.findAll();
        return users;
    }

    @Override
    public UserEntity findById(String id) {
//        List<UserEntity> users = (List<UserEntity>) userRepository.findById(id).get();
        //getOne返回的是代理对象
//        UserEntity userEntity = userRepository.getOne(id);
        UserEntity userEntity = userRepository.findById(id).orElse(null);

        return userEntity;
    }

    @Override
    public List<UserEntity> findByName(String name) {
        List<UserEntity> users = userRepository.findByUserName(name);
        return users;
    }

    @Transactional
    @Override
    public UserEntity modifyUser(UserEntity userEntity) {
        //修改用户信息
        Validate.notNull(userEntity, "修改用户时，用户信息不能为空");
        Validate.notBlank(userEntity.getId(), "修改用户时，用户信息不能为空");
        UserEntity oldUser = this.findById(userEntity.getId());
        Validate.notNull(oldUser, "无法获取到该用户");
        oldUser.setUserName(userEntity.getUserName());
        oldUser.setPassword(userEntity.getPassword());
        oldUser.setUserAge(userEntity.getUserAge());
        return userRepository.saveAndFlush(oldUser);
    }

    @Override
    public UserEntity findByNameAndPassword(String name, String password) {
        UserEntity userEntity = null;
        userEntity = userRepository.findByNameAndPassword(name, password);
        return userEntity;
    }
}