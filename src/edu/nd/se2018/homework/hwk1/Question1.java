package edu.nd.se2018.homework.hwk1;

import java.util.HashSet;
import java.util.Vector;

public class Question1 {
        public Question1() {}

        public int getSumWithoutDuplicates(int[] numbers){
                int total = 0;
                HashSet sumSet = new HashSet();
                for (int j = 0; j < numbers.length; j++) {
                        if (!sumSet.contains(numbers[j])) {
                                total += numbers[j];
                                sumSet.add(numbers[j]);
                        }
                }
                return total;
        }
}

