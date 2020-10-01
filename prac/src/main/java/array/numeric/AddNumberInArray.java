package array.numeric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AddNumberInArray {

    private static int size, index, value;

    private static int[] mainArray = { 1, 2, 3, 4, 5 };

    public static void main(String[] args) {
        
     

        size = 5;
        value = 90;
        index = 3;

        // acceptInput();

        System.out.println("INput array is: " + Arrays.toString(mainArray));
        System.out.println("Result array using 2 arrays and for loop is: "
                + Arrays.toString(addByForLoopWith2Arrays(mainArray, index, value)));

        System.out.println(
                "Add using arraylist at last: " + Arrays.toString(addUsingArrayListAtLast(mainArray, value)));

    }

    private static void acceptInput() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of array");
        size = scanner.nextInt();

        System.out.println("Enter the index of new number");
        index = scanner.nextInt();

        System.out.println("Enter the value of new number");
        value = scanner.nextInt();

        mainArray = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.printf("Enter the %d th element", i);
            mainArray[i] = scanner.nextInt();

        }

    }

    private static int[] addByForLoopWith2Arrays(int[] inputArray, int index , int value) {

        int[] resultArray = new int[inputArray.length + 1];

        for (int i = 0, j = 0; i < resultArray.length; i++) {

            if (index == i) {
                resultArray[i] = value;

            } else {
                resultArray[i] = inputArray[j];
                j++;
            }

        }

        return resultArray;
    }

    private static int[] addUsingArrayListAtLast(int[] inputArray, int value) {

        /*
         * Don't try to use Arrays.asList() as it returns a list with an array in first
         * location which is useless
         */
        
        /*
         * Since I am trying to use List, its necessary to convert int[] to Integer[]
         * first and hence using boxed() method on stream
         */
        List<Integer> tempList = IntStream.of(inputArray).boxed().collect(Collectors.toList());

        tempList = new ArrayList<>(tempList);
        tempList.add(value);

        int[] result = tempList.stream().mapToInt(i -> i).toArray();

        /*
         * If Playing with int array, then use stream to convert to list and again
         * convert back to array as experienced, don't go for toList and toArray methods
         */
        /********************************* BUT ****************************************/
        
        /*
         * If playing with Integer(Wrapper) array then u can use toList() mwthod of
         * Arrays class and again while converting from list to array u can use toArray
         * method of list easily PREFER WRAPPER INTEGER FOR QNS INSTEAD OF int
         */
        return result;

    }

}
