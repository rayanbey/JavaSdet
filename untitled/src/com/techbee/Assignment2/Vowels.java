package com.techbee.Assignment2;

import java.util.Locale;
import java.util.Scanner;

public class Vowels {

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String sentence="";
            System.out.println("Enter a new sentence");
            sentence = scan.nextLine();
            sentence = sentence.toLowerCase();
            getVowelCount(sentence);

    }

    private static void getVowelCount(String sentence) {
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == 'a' || sentence.charAt(i) == 'e' || sentence.charAt(i) == 'i' || sentence.charAt(i) == 'o' || sentence.charAt(i) == 'u')
                count++;
        }
        System.out.println("The number of vowels in " + sentence + " sentence is equal to " + count);
    }
}
