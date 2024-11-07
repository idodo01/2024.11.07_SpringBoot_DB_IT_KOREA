package com.koreait.db.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BookStoreDTO {
    private Integer id;
    private String name;
//    private BookDTO book;
    private List<BookDTO> book;
}
