package com.sxg.test;

import com.sxg.App;
import com.sxg.entity.Users;
import com.sxg.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class UsersServiceTest {
    @Autowired
    private UsersService usersService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testFindUserById(){
        System.out.println(this.usersService.findUserById(1));

        System.out.println(this.usersService.findUserById(2));
    }

    @Test
    public void TestSet(){

        this.redisTemplate.opsForValue().set("test", "200508");
    }

    @Test
    public void testGet(){

        String value = (String)this.redisTemplate.opsForValue().get("test");
        System.out.println(value);
    }

    /**
     * 添加 Users 对象
     */
    @Test
    public void testSetUesrs(){
        Users users = new Users();
        users.setAge(150);
        users.setName("张三丰");
        users.setId(1);
        //重新设置序列化器
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        System.out.println(users);
        this.redisTemplate.opsForValue().set("users", users);
    }
        /**
         *取 Users 对象
         */
        @Test
        public void testGetUsers(){
            //重新设置序列化器
            this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
            Users users = (Users)this.redisTemplate.opsForValue().get("users");
            System.out.println(users);
        }

    /**
     * 基于 JSON 格式存 Users 对象
     */
    @Test
    public void testSetUsersUseJSON(){
        Users users = new Users();
        users.setAge(20);
        users.setName("李四丰");
        users.setId(1);
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
        this.redisTemplate.opsForValue().set("users_json", users);
    }
        /**
         * 基于 JSON 格式取 Users 对象
         */
        @Test
        public void testGetUseJSON(){
            this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
            Users users = (Users)this.redisTemplate.opsForValue().get("users_json");
            System.out.println(users);
        }


}
