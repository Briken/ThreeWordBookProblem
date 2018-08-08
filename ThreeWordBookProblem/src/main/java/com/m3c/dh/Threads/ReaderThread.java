package com.m3c.dh.Threads;

import com.m3c.dh.MultithreadedApplication.MultithreadedWordCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

//This thread handles the reading of the line and the
// filling of a concurrent hash map for the word
// counter to count

public class ReaderThread implements Runnable
{
    BufferedReader reader;
    MultithreadedWordCounter counter;
    ConcurrentHashMap<String, Integer> resultMap;

    public ReaderThread(BufferedReader br, ConcurrentHashMap<String, Integer> res)
    {
        this.reader =  br;
        this.resultMap = res;
    }

    public void run()
    {
        String currentLine;
        String[] chunkedLine;
        counter = new MultithreadedWordCounter();

        try {
            while ((currentLine = reader.readLine()) != null)
            {
                chunkedLine = counter.countWords(currentLine);
                fillHashMap(chunkedLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillHashMap(String[] line)
    {
        for (int i = 0; i < line.length; i ++) {
            if (resultMap.containsKey(line[i])) {
                resultMap.put(line[i], resultMap.get(line[i]) +1);
            } else {
                resultMap.put(line[i], 1);
            }
        }
    }
}
