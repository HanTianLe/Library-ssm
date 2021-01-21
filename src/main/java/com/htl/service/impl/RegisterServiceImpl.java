package com.htl.service.impl;

import com.htl.domain.Reader;
import com.htl.mapper.ReaderMapper;
import com.htl.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private ReaderMapper readerMapper;

    /**
     *  读者注册
     */
    @Override
    public void readerRegister(Reader reader) {
        String gender = reader.getGender();
        if (gender.equals("1")){
            reader.setGender("男");
        }else {
            reader.setGender("女");
        }
        readerMapper.readerRegister(reader);
    }
}
