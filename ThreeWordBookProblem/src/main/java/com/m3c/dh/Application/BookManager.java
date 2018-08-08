package com.m3c.dh.Application;

import java.util.HashMap;

//A class to create and return the data from the book reader

public class BookManager
{
    HashMap<String, Integer> uncountedContent;
    ResultsDisplay display = new ResultsDisplay();

    public HashMap<String, Integer> readBook()
    {
        BookReader reader = new BookReader("Resources/aLargeFile");
        uncountedContent = reader.readFile();
        return uncountedContent;

    }

    public HashMap<String, Integer> readBook(String path)
    {
        BookReader reader = new BookReader(path);
        uncountedContent = reader.readFile();
        return uncountedContent;
    }
}
