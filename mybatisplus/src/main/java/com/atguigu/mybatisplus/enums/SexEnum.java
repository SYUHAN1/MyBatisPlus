package com.atguigu.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum SexEnum {
    MALE(1,"男"),
    FEMALE(2,"女");

    @EnumValue // 将注解所标识的属性的值存储到数据库中
    private Integer sex;
    private String sexEnum;

    SexEnum(Integer sex, String sexEnum) {
        this.sex = sex;
        this.sexEnum = sexEnum;
    }
}
