package com.rada.engeto.mergesort;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Integer[] a = {8,1,7,5,4,2,3,9,6};
        String[] b = {"h","d","g","e","i","a","b","f","c"};

        // Generate random numbers for test
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt() & Integer.MAX_VALUE;
        }

        MergeSort<Integer> mergeSortInteger = new MergeSort<>();
        mergeSortInteger.run(a);
        System.out.println(java.util.Arrays.toString(a));

        MergeSort<Integer> mergeSortRandom = new MergeSort<>();
        mergeSortRandom.run(arr);
        System.out.println(java.util.Arrays.toString(arr));

        MergeSort<String> mergeSortString = new MergeSort<>();
        mergeSortString.run(b);
        System.out.println(java.util.Arrays.toString(b));

    }

}
