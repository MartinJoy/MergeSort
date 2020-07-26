package com.rada.engeto.mergesort;

import java.io.BufferedReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Integer[] a = {8,1,7,5,4,2,3,9,6};
        String[] b = {"h","d","g","e","i","a","b","f","c"};

        MergeSort<Integer> mergeSortInteger = new MergeSort<>();
        mergeSortInteger.run(a);
        System.out.println(java.util.Arrays.toString(a));

        MergeSort<String> mergeSortString = new MergeSort<>();
        mergeSortString.run(b);
        System.out.println(java.util.Arrays.toString(b));

    }

}
