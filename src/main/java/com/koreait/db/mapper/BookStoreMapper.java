package com.koreait.db.mapper;

import com.koreait.db.dto.BookDTO;
import com.koreait.db.dto.BookStoreDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookStoreMapper {
    @Select("SELECT 1 AS isbn, 2 AS name, 3, 4")
    BookDTO getTest();

    // 1번 서점에 있는 모든 책의 정보를 조회하자 + 1번 서점 정보도 조회하자
    @Select("""
       SELECT BS.id AS bookStoreId, BS.name bookStoreName, B.*
       FROM book_store BS
       INNER JOIN book B
       ON BS.id = B.book_store_id
    """)
    List<BookDTO> selectBooksOfBookStore();


    BookStoreDTO selectBookStoreWithBook();

}
