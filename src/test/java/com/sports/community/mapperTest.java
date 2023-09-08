package com.sports.community;

import com.sports.community.dao.DiscussPostMapper;
import com.sports.community.dao.UserMapper;
import com.sports.community.entity.DiscussPost;
import com.sports.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class mapperTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper dpMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("Harry");
        user.setEmail("harry@gmail.com");
        user.setPassword("1234");
        user.setSalt("uasa");
        user.setHeaderUrl("http://www.nowcoder.com/500.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() {
        int rows = userMapper.updateStatus(150,1);
        System.out.println(rows);

        rows = userMapper.updateHeader(150,"http://www.nowcoder.com/400.png");
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> posts = dpMapper.selectDiscussPosts(0,0,10);
        int rows = dpMapper.selectDiscussPostRows(0);
        for (DiscussPost post: posts){
            System.out.println(post);
        }
        System.out.println(rows);
    }
}
