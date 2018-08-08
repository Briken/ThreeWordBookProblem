package com.m3c.dh.MultithreadedApplication;

import com.m3c.dh.Threads.ReaderThread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

//Spins up 8 threads to allow the program to read
// 8 different lines at a time

public class MultithreadedBookReader
{
    private String filePath;
    private Thread[] readerThreads;
    private int numThreads =8;
    volatile ConcurrentHashMap<String, Integer> book;


    public MultithreadedBookReader(String bookPath)
    {
        filePath = bookPath;
    }


    ConcurrentHashMap<String, Integer> readFile() {
        File newBook;
        book =  new ConcurrentHashMap<>();
        try {

            newBook = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(newBook));
            readerThreads = new Thread[numThreads];

            for(int i = 0; i < numThreads; i++)
            {
                String threadID = "Thread " +i;
                ReaderThread reader = new ReaderThread(br, book);
                readerThreads[i] = new Thread(reader, threadID);
                readerThreads[i].start();
            }


            for (int i = 0; i < numThreads; i++)
            {
                readerThreads[i].join();
            }

            return book;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null; //TODO: write bookreader exception
    }
}
