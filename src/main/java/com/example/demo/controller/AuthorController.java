package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.IAuthorService;
import com.example.demo.util.Constant;
import com.example.demo.vo.Author;
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
public class AuthorController {

    @Resource
    private IAuthorService authorService;

    @RequestMapping("insertAuthor")
    public Object insertAuthor(@RequestBody JSONObject jsonObject) {

        Author author = new Author();
        author.setId(jsonObject.getInteger("id"));
        author.setUsername(jsonObject.getString("username"));
        author.setCtime(jsonObject.getString("ctime"));
        author.setUserDesc(jsonObject.getString("userDesc"));

        int count = authorService.insertSelective(author);

        JSONObject result = new JSONObject();
        if (count > 0) {
            result.put(Constant.STATUS, Constant.OK_CODE);
            result.put(Constant.MESSAGE, "updated " + count + " records");
        } else {
            result.put(Constant.STATUS, Constant.NOT_OK_CODE);
            result.put(Constant.MESSAGE, "updated failed!");
        }
        return result;
    }

    @RequestMapping("deleteAuthor")
    public Object deleteAuthor(@RequestBody JSONObject jsonObject) {

        int id = jsonObject.getInteger("id");
        int count = authorService.deleteAuthor(id);

        JSONObject result = new JSONObject();
        if (count > 0) {
            result.put(Constant.STATUS, Constant.OK_CODE);
            result.put(Constant.MESSAGE, "updated " + count + " records");
        } else {
            result.put(Constant.STATUS, Constant.NOT_OK_CODE);
            result.put(Constant.MESSAGE, "updated failed!");
        }
        return result;
    }

    @RequestMapping("updateAuthor")
    public Object updateAuthor(@RequestBody JSONObject jsonObject) {

        Author author = new Author();
        author.setId(jsonObject.getInteger("id"));
        author.setUsername(jsonObject.getString("username"));
        author.setCtime(jsonObject.getString("ctime"));
        author.setUserDesc(jsonObject.getString("userDesc"));

        int count = authorService.updateAuthor(author);

        JSONObject result = new JSONObject();
        if (count > 0) {
            result.put(Constant.STATUS, Constant.OK_CODE);
            result.put(Constant.MESSAGE, "updated " + count + " records");
        } else {
            result.put(Constant.STATUS, Constant.NOT_OK_CODE);
            result.put(Constant.MESSAGE, "updated failed!");
        }
        return result;
    }

    @RequestMapping("authorList")
    public Object authorList() {
        List<Author> authors = authorService.selectAllAuthors();

        JSONObject result = new JSONObject();
        if (CollectionUtils.isEmpty(authors)) {
            result.put(Constant.STATUS, Constant.NOT_OK_CODE);
            result.put(Constant.MESSAGE, "updated failed!");
        } else {
            result.put(Constant.STATUS, Constant.OK_CODE);
            result.put(Constant.MESSAGE, authors);
        }
        return result;
    }

    @RequestMapping("author")
    public Object author(@RequestParam("id") int id) {
        Author author = authorService.selectAuthorById(id);

        JSONObject result = new JSONObject();
        if (author == null) {
            result.put(Constant.STATUS, Constant.NOT_OK_CODE);
            result.put(Constant.MESSAGE, "select failed!");
        } else {
            result.put(Constant.STATUS, Constant.OK_CODE);
            result.put(Constant.MESSAGE, author);
        }
        return result;
    }
}
