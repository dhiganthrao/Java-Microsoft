//Crypto, made for Project 3 by Dhiganth Rao
//V 1.0

import java.util.Scanner;

public class Crypto {

        public static void main(String[] args){
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the text you would like to encrypt: ");
            String text = input.nextLine();

            System.out.print("What is your shift value (\"key\")? ");
            int key = input.nextInt();

            System.out.print("What number of letters do you want per group? ");
            int groupsize = input.nextInt();

            String encryptedText = "";
            encryptedText = encryptString(text, key, groupsize);
            System.out.println("Here is your encrypted text: " + encryptedText);
            String decipheredText = "";
            decipheredText = decipher(encryptedText,key);
            System.out.println("Here is your deciphered text: " + decipheredText);
            String obfuscatedText = "";
            text = normalizeText(text);
            obfuscatedText = obify(text);
            System.out.println("Here is your obfuscated text: " + obfuscatedText);

            }

        public static String normalizeText(String text){
            text = text.replace(" ", "");
            text = text.replaceAll("\\p{Punct}", "").toUpperCase();
            return text;
        }

        public static String obify(String message) {

            String newmessage = "";
            for (int i = 0; i < message.length(); i++) {
                if (message.charAt(i) == 'A' || message.charAt(i) == 'E' || message.charAt(i) == 'I' || message.charAt(i) == 'O' || message.charAt(i) == 'U' || message.charAt(i) == 'Y') {
                    newmessage = newmessage + "OB" + message.charAt(i);
                }
                else {
                    newmessage = newmessage + message.charAt(i);
                }
            }
            return(newmessage);

                }

        public static String shiftAlphabet(int shift) {
            int start = 0;
            if (shift < 0) {
                start = (int) 'Z' + shift + 1;
            } else {
                start = 'A' + shift;
            }
            String result = "";
            char currChar = (char) start;
            for(; currChar <= 'Z'; ++currChar) {
                result = result + currChar;
            }
            if(result.length() < 26) {
                for(currChar = 'A'; result.length() < 26; ++currChar) {
                    result = result + currChar;
                }
            }
            return result;
        }

        public static String caesarify(String s, int key){
            String shiftedAlphabet = shiftAlphabet(key);
            String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String caesarText = "";
            for (int i=0; i < s.length(); i++) {
                char char_old = s.charAt(i);
                int index_old = Alphabet.indexOf(char_old);
                char charNEW = shiftedAlphabet.charAt(index_old);
                caesarText = caesarText + charNEW;
            }
            return caesarText;
        }

        public static String groupify(String message, int letters){
            int length = message.length();
            String newText = "";
            while (message.length() >= letters){
                String part = message.substring(0, letters);
                message = message.substring(letters);
                newText = newText + part + " ";
            }
            if (message.length() != 0){
                newText = newText + message;

                for(int i = 1; i <= letters - message.length(); i++){
                    newText = newText + "x";
                }
            }
            return newText;
        }

        public static String encryptString(String s, int shift, int groupsize){
            String normText = normalizeText(s);
            String caeserText = caesarify(normText, shift);
            String groupText = groupify(caeserText, groupsize);
            return groupText;

        }

        public static String decipher(String phrase, int key){
            phrase = phrase.substring(0,phrase.indexOf('x'));
            String decryptedString;
            String normalizedPhrase;
            normalizedPhrase = normalizeText(phrase);
            decryptedString = caesarify(normalizedPhrase, -key);
            return decryptedString;
        }
}


