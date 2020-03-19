/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CategoryServiceImpl
 * Author:   Administrator
 * Date:     2020-03-19 16:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.myVueDemo.service.internal;

import com.example.myVueDemo.entity.CategoryEntity;
import com.example.myVueDemo.repository.CategoryRepository;
import com.example.myVueDemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020-03-19
 * @since 1.0.0
 */
@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity findById(String id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElse(null);
        return categoryEntity;
    }
}