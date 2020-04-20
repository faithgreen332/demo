package com.example.demo.service.impl;

import com.example.demo.dao.AuthorMapper;
import com.example.demo.service.IAuthorService;
import com.example.demo.vo.Author;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ljf
 */
@Service("authorServiceImpl")
public class AuthorServiceImpl implements IAuthorService {

    @Resource
    private AuthorMapper authorMapper;

    @Override
    public int insertSelective(Author record) {
        return authorMapper.insertSelective(record);
    }

    @Override
    public int deleteAuthor(int id) {
        return authorMapper.deleteAuthor(id);
    }

    @Override
    public int updateAuthor(Author author) {
        return authorMapper.updateAuthor(author);
    }

    @Override
    public List<Author> selectAllAuthors() {
        return authorMapper.selectAllAuthors();
    }

    @Override
    public Author selectAuthorById(int id) {
        return authorMapper.selectAuthorById(id);
    }
}
