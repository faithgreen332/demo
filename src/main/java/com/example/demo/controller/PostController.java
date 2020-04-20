package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.IPostService;
import com.example.demo.util.Constant;
import com.example.demo.vo.Author;
import com.example.demo.vo.Post;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ljf
 */
@RestController
public class PostController {

    @Resource
    private IPostService postService;

    @RequestMapping("insertPost")
    public Object insertPostSelective(@RequestBody JSONObject jsonObject) {

        Integer authorid = jsonObject.getJSONObject("author").getInteger("id");
        Author author = new Author();
        author.setId(authorid);
        Integer id = jsonObject.getInteger("id");
        String title = jsonObject.getString("title");
        String ctime = jsonObject.getString("ctime");
        String updatedAt = jsonObject.getString("updatedAt");
        Integer vote = jsonObject.getInteger("vote");
        String ext = jsonObject.getString("ext");
        Post post = new Post();
        post.setId(id);
        post.setAuthor(author);
        post.setTitle(title);
        post.setCtime(ctime);
        post.setUpdatedat(updatedAt);
        post.setVote(vote);
        post.setExt(ext);

        JSONObject result = new JSONObject();
        int count = postService.insertSelective(post);
        if (count > 0) {
            result.put(Constant.STATUS, Constant.OK_CODE);
            result.put(Constant.MESSAGE, "updated " + count + " records");
        } else {
            result.put(Constant.STATUS, Constant.NOT_OK_CODE);
            result.put(Constant.MESSAGE, "updated fail!");
        }
        return result;
    }

    @RequestMapping("deletePost")
    public Object deletePost(@RequestBody JSONObject jsonObject) {

        int postId = jsonObject.getInteger("id");

        JSONObject result = new JSONObject();
        int count = postService.deleteById(postId);
        if (count > 0) {
            result.put(Constant.STATUS, Constant.OK_CODE);
            result.put(Constant.MESSAGE, "updated " + count + " records");
        } else {
            result.put(Constant.STATUS, Constant.NOT_OK_CODE);
            result.put(Constant.MESSAGE, "updated fail!");
        }
        return result;
    }

    @RequestMapping("postList")
    public Object postList(@RequestParam("filter") Object filter) {
        List<Post> posts = postService.selectPosts();

        JSONObject result = new JSONObject();
        if (CollectionUtils.isEmpty(posts)) {
            result.put(Constant.STATUS, Constant.NOT_OK_CODE);
            result.put(Constant.MESSAGE, "select operation occurred an error");
        } else {
            result.put(Constant.STATUS, Constant.OK_CODE);
            result.put(Constant.MESSAGE, posts);
        }
        return result;
    }

    @RequestMapping("post")
    public Object post(@RequestParam("id") Integer id) {

        Post post = postService.selectPostById(id);

        JSONObject result = new JSONObject();
        if (post == null) {
            result.put(Constant.STATUS, Constant.NOT_OK_CODE);
            result.put(Constant.MESSAGE, "select operation occurred an error");
        } else {
            result.put(Constant.STATUS, Constant.OK_CODE);
            result.put(Constant.MESSAGE, post);
        }
        return result;
    }


    @RequestMapping("updatePost")
    public Object updatePostById(@RequestBody JSONObject jsonObject) {

        int authorid = jsonObject.getJSONObject("author").getInteger("id");
        Author author = new Author();
        author.setId(authorid);
        int id = jsonObject.getInteger("id");
        String title = jsonObject.getString("title");
        String ctime = jsonObject.getString("ctime");
        String updatedAt = jsonObject.getString("updatedAt");
        Integer vote = jsonObject.getInteger("vote");
        String ext = jsonObject.getString("ext");
        Post post = new Post();
        post.setId(id);
        post.setAuthor(author);
        post.setTitle(title);
        post.setCtime(ctime);
        post.setUpdatedat(updatedAt);
        post.setVote(vote);
        post.setExt(ext);

        JSONObject result = new JSONObject();
        int count = postService.updatePost(post);
        if (count > 0) {
            result.put(Constant.STATUS, Constant.OK_CODE);
            result.put(Constant.MESSAGE, "updated " + count + " records");
        } else {
            result.put(Constant.STATUS, Constant.NOT_OK_CODE);
            result.put(Constant.MESSAGE, "updated fail!");
        }
        return result;
    }
}
