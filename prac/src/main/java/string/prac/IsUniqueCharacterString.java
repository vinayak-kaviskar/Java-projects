package string.prac;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IsUniqueCharacterString {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        String input = inputScanner.nextLine();

        System.out.println("Input string is :" + input);

        System.out.println("By method 1: " + method1(input));
        System.out.println("By method 2: " + method2(input));
        System.out.println("By method 3: " + method3(input));

    }

    private static boolean method1(String input) {

        char[] characterArray = input.toCharArray();

        for (int i = 0; i < input.length(); i++) {
            if (input.indexOf(characterArray[i]) != input.lastIndexOf(characterArray[i]))
                return false;
        }
        return true;
    }

    private static boolean method2(String input) {

        Set<Character> stringSet = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            stringSet.add(input.charAt(i));
        }
        // OR
        /**
         * stringSet = input.chars().mapToObj(chr -> (char)chr)
         * .collect(Collectors.toSet());
         */

        if (stringSet.size() != input.length()) {
            return false;
        }

        return true;
    }
    
    private static boolean method3(String input) {
        
        char[] charArray = input.toCharArray();
        
        for(int i=0; i< input.length(); i++) {
            
            for(int j = i+1; j<input.length();j++) {
                if(charArray[i] == charArray[j])
                return false;
            }
        }
        
        return true;
    }
}
