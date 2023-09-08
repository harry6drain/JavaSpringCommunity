package com.sports.community.service;

import com.sports.community.dao.DiscussPostMapper;
import com.sports.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper dpMapper;

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return dpMapper.selectDiscussPosts(userId,offset,limit);
    }

    public int findDiscussPostRows(int userId) {
        return dpMapper.selectDiscussPostRows(userId);
    }
}
