package com.techbee.Assignment2;

import java.util.Scanner;

public class Consonants
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sentence = "";
        System.out.println("Enter a new sentence");
        sentence = scan.nextLine();
        sentence = sentence.toLowerCase();
        getConsonantsCount(sentence);
    }

    private static void getConsonantsCount(String sentence) {
        String replacedSentence = "";
        int count=0;
        for (int i=0 ; i<sentence.length(); i++){
            char ch = sentence.charAt(i);
            if(ch != ' '&&ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u' )
            {
                count++;
                replacedSentence+='*';
            }
            else replacedSentence+=sentence.charAt(i);
        }
        System.out.println("Number of consonants in "+sentence+" is "+count);
        System.out.println("Replaced Sentence is "+replacedSentence);
    }
}
