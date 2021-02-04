package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testUser(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
    
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testDiscussPost(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPost(149, 0, 10);
        for (DiscussPost dp :
                discussPosts) {
            System.out.println(dp);
        }

        int i = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(i);
    }
}
