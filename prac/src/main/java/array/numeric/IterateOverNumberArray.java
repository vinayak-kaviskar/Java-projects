package array.numeric;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class IterateOverNumberArray {

    static int size = 0;
    static int[] mainArray =  new int[size];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("please enter size of array");
        size = scanner.nextInt();
        mainArray = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("please enter " + i + "th number");
            int currentNum = scanner.nextInt();
            mainArray[i] = currentNum;

        }
        scanner.close();

        System.out.println("Numbers entered are :" + Arrays.toString(mainArray));

        usingForEachLoop(mainArray);
        usingIeteratorFromIntStream(mainArray);

    }

    private static void usingForEachLoop(int[] numArray) {

        System.out.println("iterating using for each loop");

        for (int i : numArray) {
            System.out.println(i);
        }

    }

    private static void usingIeteratorFromIntStream(int[] numArray) {
        System.out.println("Iterating an array using Int stream");
        
        /** Three ways to get Iterator of primitive array */

        /** Getting primitive iterator from int stream using Array Class */
        PrimitiveIterator.OfInt i1 = Arrays.stream(numArray).iterator();
        
        
        /** Getting primitive iterator from int stream using IntStream Class */
        PrimitiveIterator.OfInt i2 = IntStream.of(numArray).iterator();
        
        
        /** Getting Integer(wrapper) Iterator from IntStream class */
        //boxed method converts into wrapper integer class
        Iterator<Integer> i3 = IntStream.of(numArray).boxed().iterator();

        while (i3.hasNext()) {
            System.out.println(i3.next());
            
        }
    }
}
