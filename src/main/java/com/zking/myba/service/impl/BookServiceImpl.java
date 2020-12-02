package com.zking.myba.service.impl;

import com.zking.myba.mapper.BookMapper;
import com.zking.myba.model.Book;
import com.zking.myba.service.IBookService;
import com.zking.myba.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements IBookService {
 @Autowired
    private BookMapper bookMapper;

    @Override
    public int deleteByPrimaryKey(Integer bookId) {
        return bookMapper.deleteByPrimaryKey(bookId);
    }

    @Override
    public int insert(Book record) {
        return bookMapper.insert(record);
    }

    @Override
    public int insertSelective(Book record) {
        return bookMapper.insertSelective(record);
    }

    @Override
    public Book selectByPrimaryKey(Integer bookId) {
        return bookMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return bookMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Book record) {
        return bookMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Book> list(Book book, PageBean pageBean) {

        pageBean.setPage(1);
        pageBean.setRows(5);
        return bookMapper.list(book);
    }

    @Override
    @Cacheable(value="bookselectSingleTest",key="'key:'+#book.bookId",condition ="#book.bookId>3")
    public Book selectSingle(Book book) {
        return bookMapper.selectSingle(book);
    }
}
