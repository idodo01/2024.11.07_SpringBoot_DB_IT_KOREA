package com.koreait.db.mapper;

import com.koreait.db.dto.BookDTO;
import com.koreait.db.dto.BookStoreDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookStoreMapper {
    // 1번 서점에 있는 모든 책의 정보를 조회하자 + 1번 서점 정보도 조회하자
//    @Select("""
//       SELECT * FROM book_store BS
//       INNER JOIN book B
//       ON BS.id = B.book_store_id
//    """)
//    List<BookDTO> selectBooksOfBookStore();

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

    //
//    LIMIT는 소수의 샘플 데이터만 확인하고 싶을 때, 1하면 1개의 행만 추출
//    @Select(
//            """
//            SELECT * FROM book_store BS
//                INNER JOIN book B
//                ON BS.id = B.book_store_id
//            LIMIT 1;
//            """)
//    BookStoreDTO selectBookStoreWithBook();



// 1) resources > mybatis > mapper > bookstore-mapper.xml 파일만들어서
// 안에 sql 넣고
// 2) application.properties 설정 파일안에 만든 xml 파일을 연결시켜준다
    BookStoreDTO selectBookStoreWithBook();
}
