package com.htl.domain;

import lombok.Data;

@Data
public class ReturnBook {
    private Integer id;
    private Integer bookid;
    private Integer readerid;
    private String returntime;
    private Integer adminid;
}
