package com.htl.service;

import com.htl.domain.BorrowVo;

import java.util.List;

public interface AdminService {
    //根据审核状态，查询借书记录
    List<BorrowVo> findAllBorrowByState(Integer page,Integer state);
    //获取借书记录页面的总页数
    int getAllBorrowPages(Integer state);
    //管理员对借书请求的处理
    void borrowHandler(Integer adminId,Integer borrowId,Integer state);

}
