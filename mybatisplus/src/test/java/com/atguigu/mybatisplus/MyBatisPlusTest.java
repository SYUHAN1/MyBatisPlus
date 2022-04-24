package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
//      通过条件构造器查询一个list集合，若没有条件，则可以设置null为参数
        List<User> list =  userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("张李");
        user.setAge(19);
        user.setEmail("zhangsan@atguigu.com");
        int result = userMapper.insert(user);
        System.out.println(result);
        System.out.println(user.getId());
    }

    @Test
    public void Delete(){
//        通过id删除用户信息
//        int result = userMapper.deleteById(1512442396547919873L);
//        System.out.println(result);

//        根据map集合中所设置的条件删除用户信息
//        Map<String,Object> map = new HashMap<>();
//        map.put("name","张三");
//        map.put("age",23);
//        int i = userMapper.deleteByMap(map);

//        通过多个id实现批量删除
//        DELETE FROM user WHERE id IN ( ? , ? , ? )
        List<Long> longs = Arrays.asList(1L, 2L, 3L);
        int i = userMapper.deleteBatchIds(longs);
        System.out.println(i);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(4L);
        user.setName("再见");
        user.setEmail("666@qq.com");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }
    
    @Test
    public void testSelect(){
//        通过id查询用户信息
//        User user = userMapper.selectById(1L);

//        List<Long> longs = Arrays.asList(1L, 2L, 3L);
//        根据多个id查询多个用户信息
//        List<User> users = userMapper.selectBatchIds(longs);
//        users.forEach(System.out::println);

//        Map<String,Object> map = new HashMap<>();
//        map.put("name","再见");
//        map.put("age",18);
//        根据map集合中的条件查询用户信息
//        List<User> users = userMapper.selectByMap(map);
//        users.forEach(System.out::println);

//        查询所有数据
//        List<User> users = userMapper.selectList(null);

        Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);
    }
}
