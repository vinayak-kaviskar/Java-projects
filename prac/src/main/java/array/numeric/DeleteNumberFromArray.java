package array.numeric;

import java.util.Arrays;

import java.util.Scanner;
import java.util.stream.IntStream;

public class DeleteNumberFromArray {

    private static int size = 6;
    private static int[] mainArray = { 1, 2, 3, 4, 5, 6 }; // new int[size];
    private static int index = 3;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter size of the array");
        size = scanner.nextInt();
        mainArray = new int[size];
        System.out.println("Enter the index to be deleted");
        index = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            System.out.printf("Enter %d th number ", i);
            mainArray[i] = scanner.nextInt();

        }
        scanner.close();

        System.out.println("Entered array is: " + Arrays.toString(mainArray));
        System.out.println("Result array is: " + Arrays.toString(deleteAnElementUsingForLoop(mainArray, index)));
        System.out
                .println("Result array is: " + Arrays.toString(deleteAnElementUsingArrayCopyMethod(mainArray, index)));
        System.out.println("Result array is: " + Arrays.toString(deleteAnElementUsingIntStream(mainArray, index)));

    }

    private static int[] deleteAnElementUsingForLoop(int[] inputArray, int index) {

        int[] resultArray = new int[inputArray.length - 1];

        for (int i = 0, j = 0; i < inputArray.length; i++) {

            if (i == index) {
                continue;
            }

            resultArray[j++] = inputArray[i];

        }

        return resultArray;
    }

    private static int[] deleteAnElementUsingIntStream(int[] inputArray, int index) {

        return IntStream.of(inputArray).filter(i -> i != inputArray[index]).toArray();

    }

    private static int[] deleteAnElementUsingArrayCopyMethod(int[] inputArray, int index) {

        int[] resultArray = new int[inputArray.length - 1];

        System.arraycopy(inputArray, 0, resultArray, 0, index);

        int remainingNumbers = (inputArray.length) - (index + 1);

        /**
         * Arguements in System.arraycopy() 1st − This is the source array.
         * 
         * 2nd − This is the starting position in the source array.
         * 
         * 3rd − This is the destination array.
         * 
         * 4th − This is the starting position in the destination data.
         * 
         * 5th − This is the number of array elements to be copied
         */

        //We can also use Array.copy()  method for copying arrays
        System.arraycopy(inputArray, index + 1, resultArray, index, remainingNumbers);

        return resultArray;
    }

}
