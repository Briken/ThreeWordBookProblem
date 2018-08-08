package com.m3c.dh.MultithreadedApplication;

//does the same as the bookmanager
// class but loads a concurrent hash map
// and calls the multithreaded version of the program

import java.util.concurrent.ConcurrentHashMap;

public class MultithreadedBookManager
{
    ConcurrentHashMap<String, Integer> uncountedContent;

    public ConcurrentHashMap<String, Integer> readBook()
    {
        MultithreadedBookReader reader = new MultithreadedBookReader("Resources/aLargeFile");
        uncountedContent = reader.readFile();
        return uncountedContent;

    }

    public ConcurrentHashMap<String, Integer> readBook(String path)
    {
        MultithreadedBookReader reader = new MultithreadedBookReader(path);
        uncountedContent = reader.readFile();
        return uncountedContent;
    }
}
