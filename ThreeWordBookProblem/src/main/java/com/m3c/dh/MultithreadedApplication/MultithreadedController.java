package com.m3c.dh.MultithreadedApplication;

import com.m3c.dh.Application.ResultsDisplay;

import java.util.concurrent.ConcurrentHashMap;

// works with concurrent hash maps instead of hash maps

public class MultithreadedController
{
    MultithreadedBookManager reader = new MultithreadedBookManager();
    MultithreadedWordCounter counter = new MultithreadedWordCounter();
    ResultsDisplay display = new ResultsDisplay();

    ConcurrentHashMap<String, Integer> book = new ConcurrentHashMap<String, Integer>();

    long startTime;


    public void StartApplication()
    {
        startTime = System.nanoTime();
        book = reader.readBook();
        book = counter.filterHashMap(book);
        display.displayMultithreadedResults(book);

        System.out.println(System.nanoTime() - startTime);
    }

    public  ConcurrentHashMap<String, Integer> StartApplication(String filename)
    {
        book = reader.readBook(filename);
        book = counter.filterHashMap(book);
        display.displayMultithreadedResults(book);
        return book;
    }
}
