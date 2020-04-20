package com.example.demo.dao;

import com.example.demo.vo.Author;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ljf
 */
public interface AuthorMapper {

    /**
     * 动态写入一条Author
     *
     * @param record author
     * @return 写入的条数
     */
    int insertSelective(@Param("author") Author record);

    /**
     * 删除一条author
     *
     * @param id id
     * @return 删除成功的条数
     */
    int deleteAuthor(@Param("id") int id);

    /**
     * 修改author
     * @param author author
     * @return 修改成功的条数
     */
    int updateAuthor(@Param("author") Author author);

    /**
     * 查询所有Author
     *
     * @return List<Author>
     */
    List<Author> selectAllAuthors();

    /**
     * 根据id查询Author
     *
     * @param authorId authorId
     * @return Author
     */
    Author selectAuthorById(@Param("id") int authorId);
}