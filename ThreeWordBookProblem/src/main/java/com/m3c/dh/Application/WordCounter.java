package com.m3c.dh.Application;

import java.util.HashMap;
import java.util.Map;

//word counter to split a line from
// the book and add it to a hashmap
//also filters the hashmap for the top 3

public class WordCounter
{
    private HashMap<String, Integer> book = new HashMap<>();

    public HashMap<String, Integer> getBook() {
        return book;
    }

    public void countWords(String line)
    {

        String[] splitBook = line.replaceAll("\\p{Punct}", "").toLowerCase().split("\\s+");

        for (int i = 0; i < splitBook.length; i ++)
        {
            if (book.containsKey(splitBook[i])) {
                int x = book.get(splitBook[i]);
                x += 1;
                book.put(splitBook[i], x);
            }
            else{
                book.put(splitBook[i], 1);
            }
        }
    }



    public HashMap<String, Integer> filterHashMap (HashMap<String, Integer> map)
    {

        HashMap<String, Integer> filteredMap = new HashMap<String, Integer>();


        Map.Entry<String, Integer> maxEntry = null;
        Map.Entry<String, Integer> maxEntry2 = null;
        Map.Entry<String, Integer> maxEntry3 = null;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                if (maxEntry2 != null) {
                    maxEntry3 = maxEntry2;
                    maxEntry2 = maxEntry;
                }
                maxEntry = entry;
            }
            else if (maxEntry2 == null || entry.getValue().compareTo(maxEntry2.getValue()) > 0)
            {
                maxEntry3 = maxEntry2;
                maxEntry2 = entry;
            }
            else if (maxEntry3 == null || entry.getValue().compareTo(maxEntry3.getValue()) > 0)
            {
                maxEntry3 = entry;
            }
        }
        filteredMap.put(maxEntry.getKey(), maxEntry.getValue());
        filteredMap.put(maxEntry2.getKey(), maxEntry2.getValue());
        filteredMap.put(maxEntry3.getKey(), maxEntry3.getValue());

        return filteredMap;
  }
}
