/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alturkeydev.cipher.application;


/**
 *
 * @author
 *
 * Professor Ahmed Alzahrani
 * Younes Alturkey | 1943222
 * CPCS 425 - BE - 10754
 * Project: Cipher Application
 * Spring 2020
 *
 */

import java.io.*;
import java.util.Scanner;


public class Cipher {
    
    public static void decrypt(String message) throws IOException {
        /* Start of the decryption process */
        System.out.println("------------------------------Start Of The Decryption Process----------------------------");
        
        message = "LM#Q&$+U^W%@BYZCD=FGH!?KN*";
        /* Start of Step 1*/
        
        message = message.trim();
        
        System.out.println("After applying Step 1:\n    " + message + "\n");
        
        /* End of Step 1*/
        
        /* Start of Step 2*/
        
        
        char[] messageArray = message.toCharArray();
        
        int halfLength;
        
        if(message.length() % 2 == 0) {
            halfLength = message.length() / 2;
        } else {
            halfLength = (message.length() / 2) + 1;
        }
        
        
        char middleChar = messageArray[halfLength - 1];
        char leftToMiddleChar = messageArray[halfLength - 2];
        
        char rightToMiddleChar = messageArray[halfLength];
        char twoRightsFromMiddleChar = messageArray[halfLength + 1];
        
        messageArray[halfLength - 2] = rightToMiddleChar;
        messageArray[halfLength - 1] = twoRightsFromMiddleChar;
        
        messageArray[halfLength] = leftToMiddleChar;
        messageArray[halfLength + 1] = middleChar;
        
        message = new String(messageArray);
        
        System.out.println("After applying Step 2:\n    " + message + "\n");
        
        /* End of Step 2*/
        
        /* Start of Step 3*/
        
        messageArray = message.toCharArray();
        
        char firstChar = messageArray[0];
        char secondChar = messageArray[1];
        
                
        char beforeLastChar = messageArray[messageArray.length - 2];
        char lastChar = messageArray[messageArray.length - 1];
        
        messageArray[0] = beforeLastChar;
        messageArray[messageArray.length - 2] = firstChar;
        
        messageArray[1] = lastChar;
        messageArray[messageArray.length - 1]  = secondChar;
        
        message = new String(messageArray);
        
        System.out.println("After applying Step 3:\n    " + message + "\n");
        
        /* End of Step 3*/
        
        /* Start of Step 4*/
        
        messageArray = message.toCharArray();
        
        String firstHalf = "";
        String secondHalf = "";
        int indexOfHalf = 0;
        
        for(int i = 0; i < halfLength; i++) {
            firstHalf = firstHalf + messageArray[i];
            indexOfHalf = i;
        }
        
        for(int i = indexOfHalf + 1; i < message.length(); i++) {
            secondHalf = secondHalf + messageArray[i];
        }
        
        message = secondHalf + firstHalf;
        
        System.out.println("After applying Step 4:\n    " + message + "\n");
        
        /* End of Step 4*/
        
        /* Start of Step 5*/
        
        message = "@BCD=FGH!?KLMN*#Q&$+U^W%YZ";
        
        messageArray = message.toCharArray();
        
        char currChar;
        
        for(int i = 0; i < messageArray.length; i++){
            currChar = messageArray[i];
            
            if(currChar == '@') {
                messageArray[i] = 'A';
            } else if(currChar == '=') {
                messageArray[i] = 'E';
            } else if(currChar == '!') {
                messageArray[i] = 'I';
            } else if(currChar == '?') {
                messageArray[i] = 'J';
            } else if(currChar == '*') {
                messageArray[i] = 'O';
            } else if(currChar == '#') {
                messageArray[i] = 'P';
            } else if(currChar == '&') {
                messageArray[i] = 'R';
            } else if(currChar == '$') {
                messageArray[i] = 'S';
            } else if(currChar == '+') {
                messageArray[i] = 'T';
            } else if(currChar == '^') {
                messageArray[i] = 'V';
            } else if(currChar == '%') {
                messageArray[i] = 'X';
            } else if(currChar == '_') {
                messageArray[i] = ' ';
            } else {
                
            }
        }
        
        message = new String(messageArray);
        
        System.out.println("After applying Step 5:\n    " + message + "\n");
        
        /* End of Step 5 */
        
        /* Start of Step 6 */
        
        message = message.toLowerCase();
        
        System.out.println("After applying Step 6:\n    " + message + "\n");
        
        
        /* End of Step 6 */
     
        /* Generating The output file */
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("decrypt.txt"));
        writer.write(message);

        writer.close();
        
        System.out.println("Generated the output file \"decrypt.txt\"\n    Opening the directory...\n");
        Runtime.getRuntime().exec("explorer.exe /select," + "decrypt.txt");

        
        /* End of the decryption process */
        System.out.println("------------------------------End Of The Decryption Process----------------------------");
        
    }
    
    public static void encrypt(String message) throws IOException {
        
        /* Start of the encryption process */
        System.out.println("------------------------------Start Of The Encryption Process------------------------------");
        
        /* Start of Step 1 and Step 2*/
        
        message = message.toUpperCase().trim();
        
        System.out.println("After applying Step 1 and Step 2:\n    " + message + "\n");
        
        /* End of Step 1 and Step 2*/
        
        /* Start of Step 3*/
        
        char[] messageArray = message.toCharArray();
        char currChar;
        
        for(int i = 0; i < messageArray.length; i++){
            currChar = messageArray[i];
            
            if(currChar == 'A') {
                messageArray[i] = '@';
            } else if(currChar == 'E') {
                messageArray[i] = '=';
            } else if(currChar == 'I') {
                messageArray[i] = '!';
            } else if(currChar == 'J') {
                messageArray[i] = '?';
            } else if(currChar == 'O') {
                messageArray[i] = '*';
            } else if(currChar == 'P') {
                messageArray[i] = '#';
            } else if(currChar == 'R') {
                messageArray[i] = '&';
            } else if(currChar == 'S') {
                messageArray[i] = '$';
            } else if(currChar == 'T') {
                messageArray[i] = '+';
            } else if(currChar == 'V') {
                messageArray[i] = '^';
            } else if(currChar == 'X') {
                messageArray[i] = '%';
            } else if(currChar == ' ') {
                messageArray[i] = '_';
            } else {
                
            }
        }
        
        message = new String(messageArray);
        
        System.out.println("After applying Step 3:\n    " + message + "\n");
        
        /* End of Step 3*/
        
        /* Start of Step 4*/
        
        messageArray = message.toCharArray();
        
        int halfLength;
        
        if(message.length() % 2 == 0) {
            halfLength = message.length() / 2;
        } else {
            halfLength = (message.length() / 2) + 1;
        }
        
        String firstHalf = "";
        String secondHalf = "";
        int indexOfHalf = 0;
        
        for(int i = 0; i < halfLength; i++) {
            firstHalf = firstHalf + messageArray[i];
            indexOfHalf = i;
        }
        
        for(int i = indexOfHalf + 1; i < message.length(); i++) {
            secondHalf = secondHalf + messageArray[i];
        }
        
        message = secondHalf + firstHalf;
        
        System.out.println("After applying Step 4:\n    " + message + "\n");
        
        /* End of Step 4*/
         
        /* Start of Step 5*/
        
        messageArray = message.toCharArray();
        
        char firstChar = messageArray[0];
        char secondChar = messageArray[1];
        
                
        char beforeLastChar = messageArray[messageArray.length - 2];
        char lastChar = messageArray[messageArray.length - 1];
        
        messageArray[0] = beforeLastChar;
        messageArray[messageArray.length - 2] = firstChar;
        
        messageArray[1] = lastChar;
        messageArray[messageArray.length - 1]  = secondChar;
        
        message = new String(messageArray);
        
        System.out.println("After applying Step 5:\n    " + message + "\n");
        
        /* End of Step 5*/
        
        /* Start of Step 6*/
        
        messageArray = message.toCharArray();
        
        
        char middleChar = messageArray[halfLength - 1];
        char leftToMiddleChar = messageArray[halfLength - 2];
        
        char rightToMiddleChar = messageArray[halfLength];
        char twoRightsFromMiddleChar = messageArray[halfLength + 1];
        
        messageArray[halfLength - 2] = rightToMiddleChar;
        messageArray[halfLength - 1] = twoRightsFromMiddleChar;
        
        messageArray[halfLength] = leftToMiddleChar;
        messageArray[halfLength + 1] = middleChar;
        
        message = new String(messageArray);
        
        System.out.println("After applying Step 6:\n    " + message + "\n");
        
        /* End of Step 6*/
        
        /* Generating The Intermediate File */
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("cipher.txt"));
        writer.write(message);

        writer.close();
        
        System.out.println("Generated the intermediate file \"cipher.txt\"\n");

        
        /* End of the encryption process */
        System.out.println("------------------------------End Of The Encryption Process------------------------------\n\n");
    }
    
    public static String readMessage(String Path) throws FileNotFoundException {
        System.out.println("-----------------------------Start of Scanning the Input File-----------------------------");

        Scanner sc = new Scanner(System.in);
        
        System.out.println("        Scanning " + Path + "...");
        File inputFile = new File(Path);
        
        sc = new Scanner(inputFile);
        
        String message = "";
        
        while (sc.hasNext()) {
            message = message + sc.next();
        }
        System.out.println("        Done scanning " + Path + "!");
        System.out.println("------------------------------End of Scanning the Input File------------------------------\n\n");

        return message;
    }
    
    public static void main(String[] args) throws IOException {
        
        System.out.println("-------------------------------Welcome to Cipher Application-------------------------------");
        System.out.println("        Developed by Younes Alturkey");
        System.out.println("        Supervised by Professor Ahmed Alzahrani");
        System.out.println("        CPCS 425 - BE - FCIT @ KAU");
        System.out.println("        Encrypting and decrypting a message based on predefined process\n\n");

        
        // Read input file message.txt
        String originalMessage = readMessage("src\\main\\java\\alturkeydev\\cipher\\application\\message.txt");
        
        // Apply the encryption procedure
        encrypt(originalMessage);
        
        // Read the intermediate file cipher.txt
        String encryptedMessage = readMessage("cipher.txt");
        
        // Apply the decryption procedure and generate the output
        decrypt(encryptedMessage);
    }
}
