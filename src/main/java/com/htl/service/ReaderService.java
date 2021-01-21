package com.htl.service;

import com.htl.domain.Book;
import com.htl.domain.BorrowVo;

import java.util.List;

public interface ReaderService {
    //查询所有图书
    List<Book> findAllBook(int page);
    //获取所有图书界面的总页数
    int getAllBookPages();
    //根据用户id查询用户借书记录
    List<BorrowVo> findAllBorrowByReaderId(int page, int readerId);
    //获取借书页面的总页数
    int getAllBorrowPages(int readerId);
    //插入读者借书记录
    void addBorrow(int readerId,int bookId);
}
