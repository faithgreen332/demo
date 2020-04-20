package com.example.demo.service.impl;

import com.example.demo.dao.CommentMapper;
import com.example.demo.service.ICommentService;
import com.example.demo.vo.Comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ljf
 */
@Service("commentServiceImpl")
public class CommentServiceImpl implements ICommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public int insertSelective(Comment record) {
        return commentMapper.insertSelective(record);
    }

    @Override
    public int deleteById(int id) {
        return commentMapper.deleteById(id);
    }

    @Override
    public int updateComment(Comment comment) {
        return commentMapper.updateComment(comment);
    }

    @Override
    public List<Comment> selectAllComments() {
        return commentMapper.selectAllComments();
    }

    @Override
    public List<Comment> selectCommentByPostId(int postId) {
        return commentMapper.selectCommentByPostId(postId);
    }

    @Override
    public List<Comment> selectCommentByAuthorId(int id) {
        return commentMapper.selectCommentByAuthorId(id);
    }
}
