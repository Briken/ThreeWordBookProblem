package com.m3c.dh.Application;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
//Displays the results of the program

//TODO: Ask keith how to do logging again so that this can be incorporated
public class ResultsDisplay {

    public void displayResults(HashMap<String, Integer> result)
    {
        System.out.println(result);
    }

    public void displayMultithreadedResults(ConcurrentHashMap<String, Integer> book) {
        System.out.println(book);
    }
}
