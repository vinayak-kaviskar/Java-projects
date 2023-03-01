package array.numeric;

public class MissingNumberInArray {

    {

    public static void main(String[] args) {

        int inputArray[] = {1, 3, 4, 5,6, 7,8,9,10};

        int n = inputArray.length;
// formula to find sum of n natural numbers in java
        int sumOfNNaturalNumbers = ((n+1)*(n+2))/2;

        int sumOfNumbersInArray = 0;
        for(int  i=0; i<inputArray.length;i++){
            sumOfNumbersInArray = sumOfNumbersInArray + inputArray[i];
        }
        System.out.println("missing number is:"+(sumOfNNaturalNumbers-sumOfNumbersInArray));
    }

}
}
