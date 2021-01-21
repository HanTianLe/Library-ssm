package com.htl.service.impl;

import com.htl.mapper.AdminMapper;
import com.htl.mapper.ReaderMapper;
import com.htl.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private ReaderMapper readerMapper;

    @Override
    public Object login(String username, String password, String type) {
        Object object = null;
        switch (type){
            case "reader":
                object = readerMapper.findReaderByUsernameAndPassword(username, password);
                break;
            case "admin":
                object = adminMapper.findAdminByUsernameAndPassword(username, password);
                break;
        }
        return object;
    }
}

