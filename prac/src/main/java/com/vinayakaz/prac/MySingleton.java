package com.vinayakaz.prac;

public class MySingleton {

    static int[] a = { 10, 12, 17, 19, 23 };

    int removeNum = 17;

    public static int removeNum(int num) {

        for (int i = 0; i < a.length; i++) {

            if (a[i] == num) {

                
                return i;
            }
        }

        return -1;
    }

    public static void deleteNum(int index) {

        int b[] = new int[a.length - 1];

        for (int j = 0; j < b.length; j++) {
            if (j != index) {
                b[j] = a[j];
            } else {
                //j++;
            }

        }

        printArray(b);

    }

    public static void main(String args[]) {

        int deleteIndex = 0;

        deleteIndex = removeNum(17);
        if (deleteIndex != -1) {
            deleteNum(deleteIndex);
            // printArray();
        } else {
            System.out.println("number is not present in array");
        }

    }

    public static void printArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
