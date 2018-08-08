package com.m3c.dh.Application;

//handles the control of the application

//TODO: write an interface to allow this and the multithreaded version to be called
import java.util.HashMap;

public class ApplicationController
{
    BookManager reader = new BookManager();
    WordCounter counter = new WordCounter();
    ResultsDisplay display = new ResultsDisplay();

    HashMap<String, Integer> book = new HashMap<>();

    long startTime;


    public void StartApplication()
    {
       startTime = System.nanoTime();
       book = reader.readBook();
       book = counter.filterHashMap(book);
       display.displayResults(book);

       System.out.println(System.nanoTime() - startTime);
    }

    public  HashMap<String, Integer> StartApplication(String filename)
    {
        book = reader.readBook(filename);
        book = counter.filterHashMap(book);
        display.displayResults(book);
        return book;
    }

}
