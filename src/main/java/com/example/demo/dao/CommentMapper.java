package com.example.demo.dao;

import com.example.demo.vo.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ljf
 */
public interface CommentMapper {

    /**
     * 写入一条评论
     *
     * @param record Comment
     * @return 写入的条数
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    int insertSelective(@Param("comment") Comment record);

    /**
     * 根据删除一条comment
     *
     * @param id id
     * @return 删除的条数
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    int deleteById(@Param("id") int id);

    /**
     * 修改一条记录
     *
     * @param comment comment
     * @return 修改的条数
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    int updateComment(@Param("comment") Comment comment);

    /**
     * 查询所有的comment
     *
     * @return 所有的comments
     */
    List<Comment> selectAllComments();

    /**
     * 根据id查询comment
     *
     * @param postId postId
     * @return Comment
     */
    List<Comment> selectCommentByPostId(@Param("postId") int postId);

    /**
     * 根据作者查询comments
     *
     * @param id id
     * @return 这个author发表的所有comment的集合
     */
    List<Comment> selectCommentByAuthorId(@Param("id") int id);

}