package com.example.demo;

import com.example.demo.util.ContentUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SensitiveTest {

    @Autowired
    private ContentUtil contentUtil;

    @Test
    public void testFilter(){
        String text = contentUtil.filter("这里可以吸#毒#，嫖$$娼");
        System.out.println(text);
    }
}
