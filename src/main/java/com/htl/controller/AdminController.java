package com.htl.controller;

import com.htl.domain.BorrowVo;
import com.htl.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource(name = "adminService")
    private AdminService adminService;

    /**
     * 根据审核状态（state=0表示未审核，state=1表示审核通过）查询借书记录
     * @param page
     * @return
     */
    @RequestMapping("/findAllBorrowByState/{page}/{state}")
    public ModelAndView findAllBorrowByState(
            @PathVariable("page") int page,
            @PathVariable("state") int state
    ) {
        ModelAndView modelAndView = new ModelAndView();
        switch (state){
            //未审核
            case 0:
                List<BorrowVo> borrowVOList = adminService.findAllBorrowByState(page,state);
                modelAndView.addObject("list",borrowVOList);
                modelAndView.addObject("dataPrePage",6);//每页6条数据
                modelAndView.addObject("currentPage",page);//当前页号
                modelAndView.addObject("pages",adminService.getAllBorrowPages(state));//总页数
                modelAndView.setViewName("admin");
                return modelAndView;
            //审核通过
            case 1:
                List<BorrowVo> borrowVOList2 = adminService.findAllBorrowByState(page, state);
                modelAndView.addObject("list",borrowVOList2);
                modelAndView.addObject("dataPrePage",6);//每页6条数据
                modelAndView.addObject("currentPage",page);//当前页号
                modelAndView.addObject("pages",adminService.getAllBorrowPages(state));//总页数
                modelAndView.setViewName("return");
                return modelAndView;
        }
        return modelAndView;
    }


    /**
     * 管理员对借书请求的处理
     * @param adminId
     * @param borrowId
     * @param state
     * @return
     */
    @RequestMapping("/borrowHandler/{adminId}/{borrowId}/{state}")
    public String borrowHandler(
            @PathVariable("adminId") Integer adminId,
            @PathVariable("borrowId") Integer borrowId,
            @PathVariable("state") Integer state
    ) {
        adminService.borrowHandler(adminId, borrowId, state);
        switch (state){
            //同意
            case 1:
                return "redirect:/admin/findAllBorrowByState/1/0";
            //拒绝
            case 2:
                return "redirect:/admin/findAllBorrowByState/1/0";
            //归还
            case 3:
                return "redirect:/admin/findAllBorrowByState/1/1";
        }
        return null;
    }

}

