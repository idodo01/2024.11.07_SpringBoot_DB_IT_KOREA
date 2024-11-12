package com.koreait.db.mapper;

import com.koreait.db.dto.ClubDTO;
import com.koreait.db.dto.UserClubDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClubMapper {
    List<UserClubDTO> selectUserWithClub();
    void insertClub(ClubDTO club);
}
