package com.example.demo.dao;

import com.example.demo.vo.Post;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ljf
 */
public interface PostMapper {

    /**
     * 写入一条post
     *
     * @param record post
     * @return 写入的条数
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    int insertSelective(@Param("post") Post record);

    /**
     * 查询所有post
     *
     * @return 查询出的所有post
     */
    List<Post> selectAllPosts();

    /**
     * 根据id查询post
     *
     * @param id id
     * @return Post
     */
    Post selectPostById(@Param("id") int id);

    /**
     * 根据authorId查询Post
     *
     * @param authorId authorId
     * @return post的集合
     */
    List<Post> selectPostByAuthorId(@Param("authorId") int authorId);

    /**
     * 更新一条Post
     *
     * @param post 需要更新的post
     * @return 更新的条数
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    int updatePost(@Param("post") Post post);

    /**
     * 根据id删除一条Post
     *
     * @param id id
     * @return 删除的条数
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    int deleteById(@Param("id") int id);
}