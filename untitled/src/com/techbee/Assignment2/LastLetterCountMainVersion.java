package com.techbee.Assignment2;

import java.util.Scanner;

public class LastLetterCountMainVersion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sentence = "";
        System.out.println("Enter a new sentence");
        sentence = scan.nextLine();
        sentence = sentence.toLowerCase();
        getCount(sentence);
        SwitchInstance(sentence);
    }

    private static void getCount(String sentence) {
        int countS = 0;
        int countY = 0;

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (i != sentence.length() - 1) {

                if (ch == 's' && sentence.charAt(i + 1) == ' ')
                    countS++;

                if (ch == 'y' && sentence.charAt(i + 1) == ' ')
                    countY++;
            } else {
                if (ch == 's')
                    countS++;
                if (ch == 'y')
                    countY++;
            }

        }
        System.out.println("counts of words ending in s are " + countS);
        System.out.println("counts  of words ending in y are " + countY);
    }

    private static void SwitchInstance(String sentence) {
        String[] newSentence = sentence.split(" ");
        int instanceS = 0;
        int instanceY = 0;
        String firstS = "";
        String firstY = "";
        int firstSIndex = 0;
        int firstYIndex = 0;
        for (int i = 0; i < newSentence.length; i++) {
            if (newSentence[i].endsWith("s")&&instanceS<1) {
                instanceS++;
                firstS = newSentence[i];
                firstSIndex = i;
            }
            if (newSentence[i].endsWith("y")&&instanceY<1) {
                instanceY++;
                firstY = newSentence[i];
                firstYIndex = i;
            }
            if (instanceS == 1 && instanceY == 1) {
                newSentence[firstSIndex] = firstY;
                newSentence[firstYIndex] = firstS;
                break;
            }
        }
        if (instanceS != 1 || instanceY != 1)
            System.out.println("There is not 'y' and  's' word in the sentence");
        else {
            System.out.print("The new sentence is : ");
            for (int j = 0; j < newSentence.length; j++)
                System.out.print(newSentence[j]+" ");
        }

    }
}
