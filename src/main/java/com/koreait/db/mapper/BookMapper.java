package com.koreait.db.mapper;

import com.koreait.db.dto.BookDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {

    // 1. SELECT문

    @Select("SELECT * FROM book")
    List<BookDTO> selectAllBooks();


    // ISBN값으로 book 객체 하나 조회하기!
    @Select("SELECT * FROM `book` WHERE isbn = #{ISBN}")
    BookDTO selectBookByISBN(String ISBN);



    //  2. INSERT문
    //      1)
    //    @Insert("INSERT INTO book (isbn) VALUES (#{ISBN})")
    //    void insertBook(String ISBN);
    //      2)
    //    @Insert("INSERT INTO book (isbn, price) VALUES (#{ISBN}, #{price})")
    //    void insertBook(String ISBN, int price);
    //

//    //    3) 이름 다르게 하고 싶으면, PARAM 사용하면 됨
//    @Insert("INSERT INTO book (isbn, price) VALUES (#{bookISBN}, #{price})")
//    void insertBook(
//            @Param("bookISBN") String ISBN,
//            int price
//    );


    // 4. 값을 하나하나 전달하지 않고 객체를 전달해서 객체에 있는 데이터를 사용하기
    // 변수 이름 그대로 적으면 된다
    @Insert("INSERT INTO book VALUES (#{isbn}, #{name}, #{price}, #{publishDate})")
    void insertBookDTO(BookDTO bookDTO);

    // 5. 객체와 또 다른 변수를 같이 사용할 때는, 객체 변수 앞에 객체. 붙여줘서 구분해야한다
    @Insert("INSERT INTO book VALUES (#{bookDTO.isbn}, #{bookDTO.name}, #{bookPrice}, #{bookDTO.publishDate})")
    int insertBookDTOWithPrice(BookDTO bookDTO, int bookPrice);





}
