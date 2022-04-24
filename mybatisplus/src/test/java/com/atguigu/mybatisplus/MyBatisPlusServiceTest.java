package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.pojo.User;
import com.atguigu.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MyBatisPlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void TestGetCount(){
//        查询总记录数
        long count = userService.count();
        System.out.println(count);

    }

    @Test
    public void testInsertMore(){
        List<User> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++){
            User user = new User();
            user.setName("s" + i);
            user.setAge(18+i);
            list.add(user);
        }
//        批量添加
        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }
//    小小测试一波
//    再次测试
//    这个是hot-fix分支
//    加一行测试
}
