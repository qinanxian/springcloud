package com.lih.articleservice;

import com.lih.articleservice.controller.ArticeleController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArticleServiceApplicationTests {
    @Autowired
    ArticeleController articeleController;
    @Test
    void test() {
        String s="abcdefg";
        System.out.println(s.contains("x"));
    }

}
