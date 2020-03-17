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


import com.example.myVueDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



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


    @RequestMapping(value = "/create", method = {RequestMethod.GET})
    public void create() {


    }



}