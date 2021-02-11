package com.techbee.Assignment2;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String word="";
        System.out.println("Enter a word to check if it's palindrome");
        word=scan.nextLine();
        word = word.toLowerCase();
        if(IsPalindrome(word))
        System.out.println(word+" is a palindrome");
        else
            System.out.println(word+" is not a palindrome");

    }
    public static boolean IsPalindrome(String word){
        String reversedWord="";
        for (int i =word.length()-1,j=0; i >=0;i--,j++)
        {
            reversedWord += word.charAt(i);
            if (word.charAt(j) != reversedWord.charAt(j))
                return false;
        }
        return true;
    }
}
