// 지우면 안되는 파일
// 스프링부트는 여기서 모든 파일을 실행한다


package com.koreait.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDbProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDbProjectApplication.class, args);
    }

}
