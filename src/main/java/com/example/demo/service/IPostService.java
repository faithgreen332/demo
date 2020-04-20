package com.example.demo.service;

import com.example.demo.vo.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ljf
 */
public interface IPostService {

    /**
     * 寫入Post
     *
     * @param record record
     * @return 寫入的條數
     */
    int insertSelective(Post record);

    /**
     * 查询所有Post
     *
     * @return List<Post>
     */
    List<Post> selectPosts();

    /**
     * 根据postId查询Post
     *
     * @param postId postId
     * @return Post
     */
    Post selectPostById(@Param("id") int postId);

    /**
     * 根据postid修改Post
     *
     * @param post postid
     * @return 修改的条数
     */
    int updatePost(Post post);

    /**
     * 删除Post
     *
     * @param postId postid
     * @return 删除成功的条数
     */
    int deleteById(@Param("id") int postId);
}
