package com.koreait.db;

import com.koreait.db.dto.AuthorDTO;
import com.koreait.db.dto.BookDTO;
import com.koreait.db.dto.BookStoreDTO;
import com.koreait.db.mapper.BookMapper;
import com.koreait.db.mapper.BookStoreMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class SpringDbProjectApplicationTests {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookStoreMapper bookStoreMapper;

    @Test
    public void bookTest1108(){
//        List<BookDTO> bookDTOS = bookMapper.selectBookByPrice(20000);
//        System.out.println(bookDTOS);

        //// DB에 넣고 싶은 자바 객체가 존재할 때, 해당 객체들을 사용해서 insert 하자
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName("최강현");
        authorDTO.setAge(40);

        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthor(authorDTO); // bookDTO의 author 변수에는 위의 Author 객체를 넣기!
        bookDTO.setIsbn("ISBN-1108");
        bookDTO.setName("AUTHOR와 함께");
        bookDTO.setPrice(1);
        bookDTO.setPublishDate(LocalDateTime.now());

        bookMapper.insertBookWithAuthor(bookDTO);
    }


    @Test
    public void bookTest1108_2(){
        BookDTO bookDTO = bookMapper.selectBookWithAuthor("A1");
        System.out.println(bookDTO);
    }

    @Test
    public void bookTest1108_3(){
        AuthorDTO authorDTO = bookMapper.selectAuthorWithBooks("김나나");
        System.out.println("저자명: " + authorDTO.getName());
        System.out.println("저자 나이: " + authorDTO.getAge());
        System.out.println("저자가 쓴 책 정보들:");
        for(var bookDTO : authorDTO.getBooks()){
            System.out.println(bookDTO);
        }
    }


    @Test
    public void selectOneToMany(){
//        var books = bookStoreMapper.selectBooksOfBookStore();
//        System.out.println(books);
        BookStoreDTO bookStoreDTO = bookStoreMapper.selectBookStoreWithBook();
        System.out.println(bookStoreDTO);
    }



    @Test
    void insertBookTest() {
//        bookMapper.insertBook("ABCD", 55454);
        BookDTO bookDTO = new BookDTO();
        bookDTO.setIsbn("TEST_ISBN");
        bookDTO.setPrice(55555);
        bookDTO.setPublishDate(LocalDateTime.now());
        bookDTO.setName("TEST_NAME");
        // 값들을 가지고 있는 객체 자체를 전달해서 INSERT
//        bookMapper.insertBookDTO(bookDTO);

//        bookDTO.setIsbn("TEST_ISBN22222");
//        bookMapper.insertBookDTOWithPrice(bookDTO, 77777);

        bookDTO.setIsbn("TEST_ISBN33333");
        int result = bookMapper.insertBookDTOWithPrice(bookDTO, 77777);
        System.out.println(result);


    }


    @Test
    public void bookTest(){
        BookDTO bookA1 = bookMapper.selectBookByISBN("A1");
        System.out.println(bookA1);

        List<BookDTO> books = bookMapper.selectAllBooks();
        System.out.println(books);
    }

}
