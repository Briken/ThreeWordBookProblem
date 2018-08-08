package com.m3c.dh.Application;

import java.io.*;
import java.util.HashMap;


//This class handles the reading of the file
// and calls a word counter in the single threaded version



public class BookReader {

    private String filePath;
    private File newbook;

    WordCounter chunker = new WordCounter();


    HashMap<String, Integer> book;


    public BookReader(String bookPath)
    {
        filePath = bookPath;
    }

    synchronized public HashMap<String, Integer> readFile() {

        try {

            newbook = new File(filePath);
             BufferedReader br = new BufferedReader(new FileReader(newbook));
            String cLine;


            while ((cLine = br.readLine()) != null)
            {

                chunker.countWords(cLine);
            }
            book = chunker.getBook();

            return book;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; //TODO: write bookreader exception
    }

}
