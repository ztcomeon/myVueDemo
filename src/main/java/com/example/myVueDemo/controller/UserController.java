/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UserController
 * Author:   Administrator
 * Date:     2020-03-05 17:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.myVueDemo.controller;


import com.example.myVueDemo.controller.model.ResponseCode;
import com.example.myVueDemo.controller.model.ResponseModel;
import com.example.myVueDemo.entity.UserEntity;
import com.example.myVueDemo.service.UserService;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020-03-05
 * @since 1.0.0
 */
@RestController
public class UserController extends BaseController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/create", method = {RequestMethod.POST})
    public ResponseModel create(@RequestBody UserEntity user) {
        try {
            UserEntity userEntity = userService.create(user);
            return new ResponseModel(new Date().getTime(), userEntity, ResponseCode._200, "");
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public ResponseModel login1(String id) {
        try {
            UserEntity userEntity = userService.findById(id);
            return new ResponseModel(new Date().getTime(), userEntity, ResponseCode._200, "");
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResponseModel modifyUser(@ApiParam(value = "修改用户") @RequestBody UserEntity userEntity) {
        try {
            Validate.notNull(userEntity, "用户资料信息不能为空!");
//            OperatorEntity operator = verifyLdapNodeLogin(opUser);
//            Validate.notNull(operator, "当前登录用户不能为空!");
//            if(null != userEntity){
//                userEntity.modifyUser(operator);
//            }
            userService.modifyUser(userEntity);
            return this.buildHttpReslut();
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }

}