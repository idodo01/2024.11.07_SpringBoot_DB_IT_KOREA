package com.koreait.db.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AuthorDTO {
    private String name;
    private Integer age;
    private List<BookDTO> books;
}
