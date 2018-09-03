package edu.nd.se2018.homework.hwk1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Question2 {

        public Question2(){}

        public String getMostFrequentWord(String input, String stopwords){
                HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
                for (String word : input.split(" ")) {
                        if (!stopwords.contains(word)) {
                                 if (!wordMap.containsKey(word)) {
                                wordMap.put(word, 1);
                         } else {
                                wordMap.put(word, (Integer) wordMap.get(word) + 1);
                         }
                        }
                }

                int maxes = 0;
                String maxWord = "";
                int maxValueInMap=(Collections.max(wordMap.values()));
        for (Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue()==maxValueInMap) {
                maxWord = entry.getKey();
                maxes++;
            }
        }

        if (maxes <= 1) {
                return maxWord;
        }
        else {
                return null;
        }
        }
}
