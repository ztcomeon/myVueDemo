/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: BookRepository
 * Author:   Administrator
 * Date:     2020-03-19 16:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.myVueDemo.repository;

import com.example.myVueDemo.entity.BookEntity;
import com.example.myVueDemo.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020-03-19
 * @since 1.0.0
 */
@Repository("bookRepository")
public interface BookRepository extends JpaRepository<BookEntity, String>, JpaSpecificationExecutor<BookEntity> {

    List<BookEntity> findAllByCategory(CategoryEntity category);

    List<BookEntity> findAllByTitleLikeOrAuthorLike(String title, String author);
}