package com.htl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.htl.domain.BorrowVo;
import com.htl.mapper.AdminMapper;
import com.htl.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     *  根据审核状态，查询借书记录
     */
    @Override
    public List<BorrowVo> findAllBorrowByState(Integer page,Integer state) {
        PageHelper.startPage(page,6);
        List<BorrowVo> borrowVoList = adminMapper.findAllBorrowByState(state);
        return borrowVoList;
    }

    /**
     *  获取借书记录页面的总页数
     */
    @Override
    public int getAllBorrowPages(Integer state) {
        PageHelper.startPage(1,6);
        List<BorrowVo> borrowVoList = adminMapper.findAllBorrowByState(state);
        PageInfo<BorrowVo> pageInfo = new PageInfo<BorrowVo>(borrowVoList);
        int pages = pageInfo.getPages();
        return pages;
    }

    /**
     *  管理员对借书请求的处理
     */
    @Override
    public void borrowHandler(Integer adminId, Integer borrowId, Integer state) {
        adminMapper.borrowHandler(state, adminId, borrowId);
    }

}
