package com.rada.engeto.mergesort;

public class MergeSort<T extends Comparable<? super T>>{

    public void run(T[] ar){

        int procCount = Runtime.getRuntime().availableProcessors();

        if(procCount <= 1){
            sort(ar);
            return;
        }

        sort(ar, procCount);

    }

    private Thread mergeSortThread(T[] ar, int threadCount){

        return new Thread(() -> sort(ar, threadCount / 2));
    }

    /**
     * method for sequential sorting
     * @param ar
     */
    private void sort(T[] ar){

        // terminate for input of size 1
        if(ar.length <= 1){
            return;
        }

        // find middle of array
        int mid = ar.length / 2;

        T[] left = (T[]) new Comparable[mid];
        T[] right = (T[]) new Comparable[ar.length - mid];

        // copy elements left of mid point to left array
        for(int i=0; i < left.length; i++){
            left[i] = ar[i];
        }

        // copy elements right of mid point to right array
        for(int j=0; j < right.length; j++){
            right[j] = ar[mid+j];
        }

        // recursively sort;
        sort(left);
        sort(right);

        // merge results
        mergeSort(left, right, ar);
    }

    /**
     * (overloaded) method for parallel sorting
     * @param ar
     * @param threadCount
     */
    private void sort(T[] ar, int threadCount){

        // terminate for input of size 1
        if(ar.length <= 1){
            return;
        }

        // find middle of array
        int mid = ar.length / 2;

        T[] left = (T[]) new Comparable[mid];
        T[] right = (T[]) new Comparable[ar.length - mid];

        // copy elements left of mid point to left array
        for(int i=0; i < left.length; i++){
            left[i] = ar[i];
        }

        // copy elements right of mid point to right array
        for(int j=0; j < right.length; j++){
            right[j] = ar[mid+j];
        }

        // recursively sort;
        Thread leftSort = mergeSortThread(left, threadCount);
        Thread rightSort = mergeSortThread(right, threadCount);

        leftSort.start();
        rightSort.start();

        try {
            leftSort.join();
            rightSort.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // merge results
        mergeSort(left, right, ar);
    }

    private void mergeSort(T[] left,T[] right, T[] original){

        int i = 0, j =0, k =0;

        while (i < left.length && j < right.length){
            if(left[i].compareTo(right[j]) < 0)
                original[k++] = left[i++];
            else
                original[k++] = right[j++];
        }

        while (i < left.length){
            original[k++] = left[i++];
        }

        while (j < right.length){
            original[k++] = right[j++];
        }
    }
}

