package com.htl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.htl.domain.Book;
import com.htl.domain.Borrow;
import com.htl.domain.BorrowVo;
import com.htl.mapper.ReaderMapper;
import com.htl.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("readerService")
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderMapper readerMapper;

    /**
     *  查询所有图书
     */
    @Override
    public List<Book> findAllBook(int page) {
        PageHelper.startPage(page,6);
        List<Book> bookList = readerMapper.findAllBook();
        return bookList;
    }

    /**
     *  获取所有图书界面的总页数
     */
    @Override
    public int getAllBookPages() {
        PageHelper.startPage(1,6);
        List<Book> bookList = readerMapper.findAllBook();
        PageInfo<Book> pageInfo = new PageInfo<Book>(bookList);
        int pages = pageInfo.getPages();
        return pages;
    }

    /**
     *  根据用户id查询用户借书记录
     */
    @Override
    public List<BorrowVo> findAllBorrowByReaderId(int page, int readerId) {
        PageHelper.startPage(page,6);
        List<BorrowVo> borrowList = readerMapper.findAllBorrowByReaderId(readerId);
        return borrowList;
    }

    /**
     *  获取借书页面的总页数
     */
    @Override
    public int getAllBorrowPages(int readerId) {
        PageHelper.startPage(1,6);
        List<BorrowVo> borrowList = readerMapper.findAllBorrowByReaderId(readerId);
        PageInfo<BorrowVo> pageInfo = new PageInfo<BorrowVo>(borrowList);
        int pages = pageInfo.getPages();
        return pages;
    }

    /**
     *  插入读者借书记录
     */
    @Override
    public void addBorrow(int readerId, int bookId) {
        // 借书时间。
        Date date = new Date();
        // 定义时间规则。
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 使用时间规则来改变date。
        String borrowTime = simpleDateFormat.format(date);
        // 还书时间，借书时间+14天。
        Calendar calendar = Calendar.getInstance();// 创建calendar对象。（可以自动计算日期）
        // 算出当前日期是一年当中的第几天的天数，然后+14。
        int dates = calendar.get(Calendar.DAY_OF_YEAR) + 14;
        // Calendar.DAY_OF_YEAR是转换规则，说明dates的值也是一年当中的第几天，然后存储。
        calendar.set(Calendar.DAY_OF_YEAR, dates);
        // 用calendar调用getTime()方法，拿到14天之后的日期。
        Date date2 = calendar.getTime();
        // 定义并赋值还书时间。
        String returnTime = simpleDateFormat.format(date2);
        Borrow borrow = new Borrow();
        borrow.setBookid(bookId);
        borrow.setReadid(readerId);
        borrow.setBorrowtime(borrowTime);
        borrow.setReturntime(returnTime);
        borrow.setState(0);
        readerMapper.addBorrow(borrow);
    }
}
