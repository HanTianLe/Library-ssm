package com.htl.controller;

import com.htl.domain.Book;
import com.htl.service.ReaderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/reader")
public class ReaderController {

    @Resource(name = "readerService")
    private ReaderService readerService;

    /**
     * 查询所有图书
     * @param page
     * @return
     */
    @RequestMapping("/findAllBook/{page}")
    public ModelAndView findAllBook(@PathVariable("page") int page){
        ModelAndView modelAndView = new ModelAndView();
        List<Book> bookList = readerService.findAllBook(page);
        modelAndView.addObject("list",bookList);//图书集合
        modelAndView.addObject("dataPrePage",6);//每页6条数据
        modelAndView.addObject("currentPage",page);//当前页号
        modelAndView.addObject("pages",readerService.getAllBookPages());//总页数
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 根据用户id查询用户借书记录
     * @param page
     * @param readerId
     * @return
     */
    @RequestMapping("/findAllBorrow/{page}/{readerId}")
    public ModelAndView findAllBorrow(
            @PathVariable("page") int page,
            @PathVariable("readerId") int readerId
    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",readerService.findAllBorrowByReaderId(page, readerId));//借书记录
        modelAndView.addObject("dataPrePage",6);//每页六条记录
        modelAndView.addObject("currentPage",page);//当前页号
        modelAndView.addObject("pages",readerService.getAllBorrowPages(readerId));//总页数
        modelAndView.setViewName("borrow");
        return modelAndView;
    }

    /**
     * 插入读者借书记录
     * @param readerId
     * @param bookId
     * @return
     */
    @RequestMapping("/addBorrow/{readerId}/{bookId}")
    public String addBorrow(
            @PathVariable("readerId") int readerId,
            @PathVariable("bookId") int bookId
    ) {
        readerService.addBorrow(readerId, bookId);
        return "redirect:/reader/findAllBorrow/1/"+readerId;
    }

}

