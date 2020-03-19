package com.example.myVueDemo.entity;

import javax.persistence.*;

/**
 * CategoryEntity entity.
 *
 * @author Evan
 * @date 2019/4
 */
@Entity
@Table(name = "vue_category")
public class CategoryEntity extends UuidEntity{

    /**
     * CategoryEntity name in Chinese.
     */
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
