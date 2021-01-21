package com.htl.controller;

import com.htl.domain.BookAdmin;
import com.htl.domain.Reader;
import com.htl.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Resource(name = "loginService")
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(String username,String password,String type,HttpSession session) {
        Object login = loginService.login(username, password, type);
        if (login != null){
            switch (type){
                case "reader":
                    Reader reader = (Reader) login;
                    session.setAttribute("reader",reader);
                    return "redirect:/reader/findAllBook/1";
                case "admin":
                    BookAdmin admin = (BookAdmin) login;
                    session.setAttribute("admin",admin);
                    return "redirect:/admin/findAllBorrowByState/1/0";
            }
        }
        return "redirect:/login.jsp";
    }

}

