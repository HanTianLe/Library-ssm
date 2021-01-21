package com.htl.mapper;

import com.htl.domain.BookAdmin;
import com.htl.domain.BorrowVo;

import java.util.List;

public interface AdminMapper {
    //管理员登录
    BookAdmin findAdminByUsernameAndPassword(String username,String password);
    //根据审核状态，查询借书记录
    List<BorrowVo> findAllBorrowByState(Integer state);
    //管理员对借书请求的处理
    void borrowHandler(Integer state,Integer adminId, Integer borrowId);

}
