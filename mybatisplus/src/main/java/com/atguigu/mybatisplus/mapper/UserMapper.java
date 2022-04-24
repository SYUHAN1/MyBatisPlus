package com.atguigu.mybatisplus.mapper;

import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {

    @MapKey("id")
    Map<String,Object> selectMapById(Long id);
//    通过年龄查询用户信息并分页
//    Page : MyBatisPlus所提供的分页对象 必须位于第一个位置
    Page<User> selectPageVo(@Param("page") Page<User> page,@Param("age") Integer age);
}
