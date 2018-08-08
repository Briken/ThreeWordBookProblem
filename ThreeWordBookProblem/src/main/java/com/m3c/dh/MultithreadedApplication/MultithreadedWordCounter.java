package com.m3c.dh.MultithreadedApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//a word counter which splits a line
// and counts the top 3 words in the book

public class MultithreadedWordCounter
{
    private HashMap<String, Integer> book = new HashMap<String, Integer>();



    public String[] countWords(String line) {

        String[] splitBook = line.replaceAll("\\p{Punct}", "").toLowerCase().split("\\s+");
        return  splitBook;
    }


    public ConcurrentHashMap<String, Integer> filterHashMap(ConcurrentHashMap<String, Integer> map) {

        ConcurrentHashMap<String, Integer> filteredMap = new ConcurrentHashMap<String, Integer>();


        Map.Entry<String, Integer> maxEntry = null;
        Map.Entry<String, Integer> maxEntry2 = null;
        Map.Entry<String, Integer> maxEntry3 = null;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                if (maxEntry2 != null) {
                    maxEntry3 = maxEntry2;
                    maxEntry2 = maxEntry;
                }
                maxEntry = entry;
            } else if (maxEntry2 == null || entry.getValue().compareTo(maxEntry2.getValue()) > 0) {
                maxEntry3 = maxEntry2;
                maxEntry2 = entry;
            } else if (maxEntry3 == null || entry.getValue().compareTo(maxEntry3.getValue()) > 0) {
                maxEntry3 = entry;
            }
        }
        filteredMap.put(maxEntry.getKey(), maxEntry.getValue());
        filteredMap.put(maxEntry2.getKey(), maxEntry2.getValue());
        filteredMap.put(maxEntry3.getKey(), maxEntry3.getValue());

        return filteredMap;
    }
}
