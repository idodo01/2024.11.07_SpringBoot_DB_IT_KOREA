package com.koreait.db.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserClubDTO {
    private String userName;
    private String role;
    private String clubName;
    private String roomNo;
    private LocalDateTime joinedAt;
}
