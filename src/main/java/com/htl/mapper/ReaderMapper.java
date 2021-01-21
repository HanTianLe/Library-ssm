package com.htl.mapper;

import com.htl.domain.Book;
import com.htl.domain.Borrow;
import com.htl.domain.BorrowVo;
import com.htl.domain.Reader;

import java.util.List;

public interface ReaderMapper {
    //读者登录
    Reader findReaderByUsernameAndPassword(String username,String password);
    //查询所有图书
    List<Book> findAllBook();
    //根据用户id查询用户借书记录
    List<BorrowVo> findAllBorrowByReaderId(int readerId);
    //插入读者借书记录
    void addBorrow(Borrow borrow);
    //读者注册
    void readerRegister(Reader reader);
}
