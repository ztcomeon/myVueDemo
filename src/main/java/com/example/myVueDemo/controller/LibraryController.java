/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LibraryController
 * Author:   Administrator
 * Date:     2020-03-19 16:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.myVueDemo.controller;

import com.example.myVueDemo.controller.model.ResponseCode;
import com.example.myVueDemo.controller.model.ResponseModel;
import com.example.myVueDemo.entity.BookEntity;
import com.example.myVueDemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020-03-19
 * @since 1.0.0
 */
@RestController
@RequestMapping("/library")
public class LibraryController extends BaseController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/createBook", method = RequestMethod.POST)
    public ResponseModel createBook(BookEntity bookEntity) {
        try {
            BookEntity entity = bookService.create(bookEntity);
            return new ResponseModel(new Date().getTime(), entity, ResponseCode._200, "");
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseModel findAll() {
        try {
            List<BookEntity> books = bookService.findAll();
            return new ResponseModel(new Date().getTime(), books, ResponseCode._200, "");
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }

}