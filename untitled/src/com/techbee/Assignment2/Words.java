package com.techbee.Assignment2;

import java.util.Scanner;

public class Words {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String sentence="";
        System.out.println("Enter a new sentence");
        sentence = scan.nextLine();
        countWords(sentence);
    }

    private static void countWords(String sentence) {
        int count=0;
        for (int i = 0; i <sentence.length(); i++)
        {
            if(sentence.charAt(i)==' ' && i!=sentence.length()-1)
                count++;
        }
        count+=1;//count the last word
        System.out.println("This sentence consists of " + count + " words");
    }

}
