package com.shgx.db.Mapper;

import com.shgx.db.entity.UserEntity;
import com.shgx.db.enums.UserSexEnum;
import com.shgx.db.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by gshan on 2018/8/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private  UserMapper userMapper;


    @Test
    public void testInsert() throws Exception {
        userMapper.insert(new UserEntity("aa", "a123456", UserSexEnum.MAN));
        userMapper.insert(new UserEntity("bb", "b123456", UserSexEnum.WOMAN));
        userMapper.insert(new UserEntity("cc", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, userMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<UserEntity> users = userMapper.getAll();
        System.out.println(users.toString());
    }


    @Test
    public void testUpdate() throws Exception {
        UserEntity user = userMapper.getOne(3l);
        System.out.println(user.toString());
        user.setNickName("shgx");
        userMapper.update(user);
        Assert.assertTrue(("shgx".equals(userMapper.getOne(3l).getNickName())));
    }
}
