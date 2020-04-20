package com.example.demo.service.impl;

import com.example.demo.dao.PostMapper;
import com.example.demo.service.IPostService;
import com.example.demo.vo.Post;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ljf
 */
@Service("postServiceImpl")
public class PostServiceImpl implements IPostService {

    @Resource
    private PostMapper postMapper;

    @Override
    public int insertSelective(Post record) {
        return postMapper.insertSelective(record);
    }

    @Override
    public List<Post> selectPosts() {
        return postMapper.selectAllPosts();
    }

    @Override
    public Post selectPostById(int postId) {
        return postMapper.selectPostById(postId);
    }

    @Override
    public int updatePost(Post post) {
        return postMapper.updatePost(post);
    }

    @Override
    public int deleteById(int postId) {
        return postMapper.deleteById(postId);
    }
}
