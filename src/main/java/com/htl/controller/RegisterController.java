package com.htl.controller;

import com.htl.domain.Reader;
import com.htl.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class RegisterController {

    @Resource(name = "registerService")
    private RegisterService registerService;


    @RequestMapping("/readerRegister")
    public String readerRegister(Reader reader, Model model){
        try {
            registerService.readerRegister(reader);
        } catch (Exception e) {
            model.addAttribute("error",reader.getUsername()+"已存在！请重新输入！");
            return "redirect:/register.jsp";
        }
        return "redirect:/login.jsp";
    }

}
