package com.koreait.db.mapper;

import com.koreait.db.dto.AuthorDTO;
import com.koreait.db.dto.BookDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {
    // ISBN값으로 book 객체 하나 조회하기!
    @Select("SELECT * FROM `book` WHERE isbn = #{ISBN}")
    BookDTO selectBookByISBN(String ISBN);

    @Select("SELECT * FROM book")
    List<BookDTO> selectAllBooks();

    @Insert("INSERT INTO book (isbn, price) VALUES (#{bookISBN}, #{param2})")
    void insertBook(
            @Param("bookISBN") String ISBN, // param1
            int price // param2
    );

    // 값을 하나하나 전달하지 않고 객체를 전달해서 객체에 있는 데이터를 사용하기
    // 변수 이름 그대로 적으면 된다
    @Insert("INSERT INTO book VALUES (#{isbn}, #{name}, #{price}, #{publishDate})")
    void insertBookDTO(BookDTO bookDTO);

    // 값을 하나하나 전달하지 않고 객체를 전달해서 객체에 있는 데이터를 사용하기
    // 변수 이름 그대로 적으면 된다
    @Insert("INSERT INTO book VALUES (#{bookDTO.isbn}, #{bookDTO.name}, #{bookPrice}, #{bookDTO.publishDate})")
    int insertBookDTOWithPrice(BookDTO bookDTO, int bookPrice);

    /********************************************************/
    List<BookDTO> selectBookByPrice(int price);

    void insertBookWithAuthor(BookDTO bookDTO);

    BookDTO selectBookWithAuthor(String isbn);


    AuthorDTO selectAuthorWithBooks(String authorName);
}








