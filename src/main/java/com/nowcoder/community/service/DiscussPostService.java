package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> selectDiscussPost(int userId, int offset, int limit){
        return discussPostMapper.selectDiscussPost(userId,offset,limit);
    }

    //@Param注解用于给参数取别名
    //如果只有一个参数，并且在<if>里使用，则必须加别名
    public int selectDiscussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
