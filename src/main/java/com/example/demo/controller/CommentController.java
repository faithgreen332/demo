package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.ICommentService;
import com.example.demo.service.IPostService;
import com.example.demo.util.Constant;
import com.example.demo.util.Utils;
import com.example.demo.vo.Author;
import com.example.demo.vo.Comment;
import com.example.demo.vo.Post;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ljf
 */
@RestController
public class CommentController {

    @Resource
    private ICommentService commentService;

    @RequestMapping("insertComment")
    public Object insertComment(@RequestBody JSONObject jsonObject) {
        //取得comment的id，前台传过来默认是没有这个参数的
        Integer id = jsonObject.getInteger("id");
        //取得post的id
        Integer postId = jsonObject.getInteger("post");
        String ctime = jsonObject.getString("ctime");
        String updatedat = jsonObject.getString("updatedat");
        String content = jsonObject.getString("content");
        Author author = new Author();
        author.setId(jsonObject.getInteger("author"));

        Comment comment = new Comment();
        comment.setId(id);
        comment.setPostId(postId);
        comment.setAuthor(author);
        comment.setCtime(ctime);
        comment.setUpdatedat(updatedat);
        comment.setContent(content);

        //写进commont表
        int count = commentService.insertSelective(comment);
        JSONObject result = new JSONObject();
        if (count > 0) {
            result.put(Constant.STATUS, Constant.OK_CODE);
            result.put(Constant.MESSAGE, "updated " + count + " record(s)");
        } else {
            result.put(Constant.STATUS, Constant.NOT_OK_CODE);
            result.put(Constant.MESSAGE, "updated failed!");
        }
        return result;
    }

    @RequestMapping("deleteComment")
    public Object deleteComment(@RequestBody JSONObject jsonObject) {

        Integer id = jsonObject.getInteger("id");

        JSONObject result = new JSONObject();
        int count = commentService.deleteById(id);
        if (count > 0) {
            result.put(Constant.STATUS, Constant.OK_CODE);
            result.put(Constant.MESSAGE, "updated " + count + " records");
        } else {
            result.put(Constant.STATUS, Constant.NOT_OK_CODE);
            result.put(Constant.MESSAGE, "updated fail!");
        }
        return result;
    }

    @RequestMapping("updateComment")
    public Object updateComment(@RequestBody JSONObject jsonObject) {

        Integer authorid = jsonObject.getJSONObject("author").getInteger("id");
        Author author = new Author();
        author.setId(authorid);
        Integer id = jsonObject.getInteger("id");
        String ctime = jsonObject.getString("ctime");
        String updatedAt = jsonObject.getString("updatedAt");
        String content = jsonObject.getString("content");
        Comment comment = new Comment();
        comment.setId(id);
        comment.setAuthor(author);
        comment.setCtime(ctime);
        comment.setUpdatedat(updatedAt);
        comment.setContent(content);

        JSONObject result = new JSONObject();
        int count = commentService.updateComment(comment);
        if (count > 0) {
            result.put(Constant.STATUS, Constant.OK_CODE);
            result.put(Constant.MESSAGE, "updated " + count + " records");
        } else {
            result.put(Constant.STATUS, Constant.NOT_OK_CODE);
            result.put(Constant.MESSAGE, "updated fail!");
        }
        return result;
    }

    @RequestMapping("commentList")
    public Object commentList() {
        List<Comment> comments = commentService.selectAllComments();

        JSONObject result = new JSONObject();
        if (CollectionUtils.isEmpty(comments)) {
            result.put(Constant.STATUS, Constant.NOT_OK_CODE);
            result.put(Constant.MESSAGE, "operation occurred an error!");
        } else {
            result.put(Constant.STATUS, Constant.OK_CODE);
            result.put(Constant.MESSAGE, comments);
        }
        return result;
    }

    @RequestMapping("comment")
    public Object comment(@RequestParam("postId") int postId) {
        List<Comment> comments = commentService.selectCommentByPostId(postId);

        JSONObject result = new JSONObject();
        if (CollectionUtils.isEmpty(comments)) {
            result.put(Constant.STATUS, Constant.NOT_OK_CODE);
            result.put(Constant.MESSAGE, "operation occurred an error!");
        } else {
            result.put(Constant.STATUS, Constant.OK_CODE);
            result.put(Constant.MESSAGE, comments);
        }
        return result;
    }
}
