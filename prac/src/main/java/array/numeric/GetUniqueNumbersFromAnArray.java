package array.numeric;

public class GetUniqueNumbersFromAnArray {{

    private static int inputArray[] = { 1, 2, 3, 4, 2, 5, 5, 3, 5 };

    public static void main(String[] args) {
        GetUniqueNumbersFromAnArray.printUniqueNumbers();
    }

    public static void printUniqueNumbers() {

        int uniqueNumberArray[] = new int[inputArray.length];
        int uniqueIndex = 0;
        int numberUnderComparison = 0;
        //read complexity w.r,t loops
        for( int i = 0; i < inputArray.length; i++ ) {
            boolean flag = false;
            numberUnderComparison = inputArray[i];

            for( int j = 0; j < i; j++ ) {

                if( inputArray[j] == inputArray[i] ) {
                    flag = true;
                }
            }
            if( flag == false ) {
                uniqueNumberArray[uniqueIndex] = numberUnderComparison;
                uniqueIndex++;
            }
        }
        System.out.println("Input array is: " + Arrays.toString(inputArray));
        System.out.println("Unique number array is: " + Arrays.toString(uniqueNumberArray));

//        int newUniqueArray[] = Arrays.stream(inputArray).boxed().collect(Collectors.toSet()).stream().mapToInt(i -> i).toArray();
//        System.out.println("Array using Set: "+Arrays.toString(newUniqueArray));

    }
}
}
