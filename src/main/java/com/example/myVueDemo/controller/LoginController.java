/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LoginController
 * Author:   Administrator
 * Date:     2020-03-17 16:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.myVueDemo.controller;


import com.example.myVueDemo.controller.model.ResponseCode;
import com.example.myVueDemo.controller.model.ResponseModel;
import com.example.myVueDemo.entity.UserEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Date;
import java.util.Objects;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020-03-17
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api")
public class LoginController extends BaseController {

    //解决跨域问题的注解
    @CrossOrigin
    @PostMapping(value = "/login")
    @ResponseBody
    public ResponseModel login(@RequestBody UserEntity requestUser) {
        try {
            // 对 html 标签进行转义，防止 XSS 攻击
            String username = requestUser.getUserName();
            username = HtmlUtils.htmlEscape(username);
            if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
                String message = "账号密码错误";
                System.out.println("test");
                return this.buildHttpReslut();
//            return new ResponseModel(new Date().getTime(), null, ResponseCode._200, "");
            } else {
                throw new IllegalArgumentException("用户名或密码错误");
            }
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }

    @CrossOrigin
    @GetMapping(value = "/login1")
    @ResponseBody
    public ResponseModel login1() {
        try {
            return new ResponseModel(new Date().getTime(), null, ResponseCode._200, "");
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }


}