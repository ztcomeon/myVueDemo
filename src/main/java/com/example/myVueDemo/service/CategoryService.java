/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CategoryService
 * Author:   Administrator
 * Date:     2020-03-19 16:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.myVueDemo.service;

import com.example.myVueDemo.entity.CategoryEntity;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020-03-19
 * @since 1.0.0
 */
public interface CategoryService {

    List<CategoryEntity> findAll();

    CategoryEntity findById(String id);
}