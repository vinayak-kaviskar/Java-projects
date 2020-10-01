package array.numeric;

public class MissingNumberInArray {

    private static int[] mainArray = new int[99]; 
    public static void main(String[] args) {
        
        int sum = 0;
        int expectedSum = 0;
        for(int i =0,j = 0; i< 100; i++) {
            
            if( i != 77) {
                mainArray[j] = i;
                j++;
                sum = sum + i;
            }
            expectedSum = expectedSum+ i;
        }
        
        System.out.println(expectedSum- sum);
    }
    
}
