package com.htl.domain;

import lombok.Data;

@Data
public class BorrowVo {
    private Integer id;
    private String bookName;
    private String author;
    private String publish;
    private String readerName;
    private String tel;
    private String cardId;
    private String borrowTime;
    private String returnTime;
    private Integer state;
}
