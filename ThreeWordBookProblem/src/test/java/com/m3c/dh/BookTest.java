package com.m3c.dh;

import com.m3c.dh.Application.ApplicationController;
import com.m3c.dh.Application.BookManager;
import java.util.HashMap;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class BookTest {

    HashMap<String, Integer> topThree = new HashMap<String, Integer>();

    HashMap<String, Integer> normalTestSuccess = new HashMap<String, Integer>();
    HashMap<String, Integer> punctuationSuccess = new HashMap<String, Integer>();

    String normalFilePath = "Resources/test.txt";
    String punctuationPath = "Resources/punctuation.txt";
    ApplicationController controller;


    @Before
    public void setup()
    {
        controller = new ApplicationController();
        normalTestSuccess.put("dog", 5);
        normalTestSuccess.put("red", 9);
        normalTestSuccess.put("koala", 3);

        punctuationSuccess.put("dog", 5);
        punctuationSuccess.put("red", 9);
        punctuationSuccess.put("koala", 4);
    }

    @Test
    public void testNormal()
    {
        topThree = controller.StartApplication(normalFilePath);

        assertTrue(topThree == normalTestSuccess);
    }

    @Test
    public void testPunctuation()
    {
        topThree = controller.StartApplication(punctuationPath);
        assertTrue(topThree ==punctuationSuccess);
    }
}
