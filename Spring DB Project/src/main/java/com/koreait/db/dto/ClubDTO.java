package com.koreait.db.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ClubDTO {
    private String name;
    private Integer roomNo;
    private LocalDateTime createdAt;
}
