package edu.nd.se2018.homework.hwk1;
public class Question3 {

        public Question3(){}

    public int getMirrorCount(int[] numbers){
        if (numbers.length == 0) {
                return 0;
        }

                int maxMirror = 1;

                for (int i = 0; i < numbers.length; i++) {
                        int currMax = 0;
                        for (int j = numbers.length - 1; j >=0; j--) {
                                if (i + currMax < numbers.length) {
                                        if (numbers[i + currMax] == numbers[j]) {
                                                currMax++;
                                        }
                                        else {
                                                if (currMax > maxMirror) {
                                                        maxMirror = currMax;
                                                }
                                                currMax = 0;
                                        }
                                }
                        }

                        if (currMax > maxMirror) {
                                maxMirror = currMax;
                        }
                }

                return maxMirror;
        }
}
