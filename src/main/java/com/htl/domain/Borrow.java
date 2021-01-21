package com.htl.domain;

import lombok.Data;

@Data
public class Borrow {
    private Integer id;
    private Integer bookid;
    private Integer readid;
    private String borrowtime;
    private String returntime;
    private Integer adminid;
    private Integer state;
}
