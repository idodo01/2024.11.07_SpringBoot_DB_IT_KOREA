package com.koreait.db.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BookDTO {
    private String isbn;
    private String name;
    private Integer price;
    private LocalDateTime publishDate;
}
