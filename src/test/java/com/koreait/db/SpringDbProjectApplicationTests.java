package com.koreait.db;

import com.koreait.db.dto.BookDTO;
import com.koreait.db.dto.BookStoreDTO;
import com.koreait.db.mapper.BookMapper;
import com.koreait.db.mapper.BookStoreMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class SpringDbProjectApplicationTests {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookStoreMapper bookStoreMapper;

//    @Test
//    public void selectOneToMany(){
//        var books = bookStoreMapper.selectBooksOfBookStore();
//        System.out.println(books);
//    }

    @Test
    public void selectOneToMany(){
        BookStoreDTO bookStoreDTO = bookStoreMapper.selectBookStoreWithBook();
        System.out.println(bookStoreDTO);
    }



//    @Test
//    void insertBookTest() {
//        bookMapper.insertBook("ABC");
//    }

//    @Test
//    void insertBookTest() {
//        bookMapper.insertBook("ABCD", 55454);
//    }

    @Test
    void insertBookTest() {
//        bookMapper.insertBook("ABCD", 55454);

        // 4.
        BookDTO bookDTO = new BookDTO();
        bookDTO.setIsbn("TEST_ISBN");
        bookDTO.setPrice(55555);
        bookDTO.setPublishDate(LocalDateTime.now());
        bookDTO.setName("TEST_NAME");
        // 값들을 가지고 있는 객체 자체를 전달해서 INSERT
//        bookMapper.insertBookDTO(bookDTO);

        // 5.
        bookDTO.setIsbn("TEST_ISBN22222");
        bookMapper.insertBookDTOWithPrice(bookDTO, 77777);

        // + 메서드 return 값이 int형이기에, 값을 받아서 출력도 가능
        bookDTO.setIsbn("TEST_ISBN33333");
        int result = bookMapper.insertBookDTOWithPrice(bookDTO, 77777);
        System.out.println(result);
    }


    @Test
    public void bookTest(){
        BookDTO bookA1 = bookMapper.selectBookByISBN("A1");
        System.out.println(bookA1);
    }

}
