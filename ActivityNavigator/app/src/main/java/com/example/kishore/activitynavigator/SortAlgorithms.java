package com.example.kishore.activitynavigator;

/**
 * Created by Kishore on 10/14/2016.
 */

 public class SortAlgorithms {

        public static void selection(int[] arr){

            for (int i = 0; i < arr.length - 1; i++)
            {
                int index = i;
                for (int j = i + 1; j < arr.length; j++)
                    if (arr[j] < arr[index])
                        index = j;

                int smallerNumber = arr[index];
                arr[index] = arr[i];
                arr[i] = smallerNumber;
            }

        }


        public static void insertion(int[] input){

            int temp;
            for (int i = 1; i < input.length; i++) {
                for(int j = i ; j > 0 ; j--){
                    if(input[j] < input[j-1]){
                        temp = input[j];
                        input[j] = input[j-1];
                        input[j-1] = temp;
                    }
                }
            }

        }
        public static void bubble(int[] array){

            int n = array.length;
            int k;
            for (int m = n; m >= 0; m--) {
                for (int i = 0; i < n - 1; i++) {
                    k = i + 1;
                    if (array[i] > array[k]) {
                        swapNumbers(i, k, array);
                    }
                }
            }

        }

        private static void swapNumbers(int i, int j, int[] array) {

            int temp;
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        public static void printNumbers(int[] input) {

            for (int i = 0; i < input.length; i++) {
                System.out.print(input[i] + ", ");
            }
            System.out.println("\n");
        }



        public static void mergeSort(int[] array) {
            if (array.length > 1){
                int[] left = leftHalf(array);
                int[] right = rightHalf(array);
                mergeSort(left);
                mergeSort(right);
                merge(array, left, right);
            }
            //printNumbers(array);
        }
        public static int[] leftHalf(int[] array){
            int size1 = array.length / 2;
            int[] left = new int[size1];
            for (int i = 0; i < size1; i++){
                left[i] = array[i];
            }
            return left;
        }
        public static int[] rightHalf(int[] array){
            int size1 = array.length / 2;
            int size2 = array.length - size1;
            int[] right = new int[size2];
            for (int i = 0; i < size2; i++){
                right[i] = array[i + size1];
            }
            return right;
        }
        public static void merge(int[] result,int[] left, int[] right){
            int i1 = 0;
            int i2 = 0;
            for (int i = 0; i < result.length; i++){
                if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])){
                    result[i] = left[i1];
                    i1++;
                }else{
                    result[i] = right[i2];
                    i2++;
                }
            }
        }


        public static void quick(int[] arr)
        {
            quickSort(arr, 0, arr.length - 1);
        }
        public static void quickSort(int arr[], int low, int high)
        {
            int i = low, j = high;
            int temp;
            int pivot = arr[(low + high) / 2];

            while (i <= j)
            {
                while (arr[i] < pivot)
                    i++;
                while (arr[j] > pivot)
                    j--;
                if (i <= j)
                {
                    temp=arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    i++;
                    j--;
                }
            }

            if (low < j)
                quickSort(arr, low, j);
            if (i < high)
                quickSort(arr, i, high);
        }

        static int N;
        public static void heap(int arr[])
        {
            heapify(arr);
            for (int i = N; i > 0; i--)
            {
                swapNumbers(0, i,arr);
                N = N-1;
                maxheap(arr, 0);
            }
        }
        /* Function to build a heap */
        public static void heapify(int arr[])
        {
            N = arr.length-1;
            for (int i = N/2; i >= 0; i--)
                maxheap(arr, i);
        }
        /* Function to swap largest element in heap */
        public static void maxheap(int arr[], int i)
        {
            int left = 2*i ;
            int right = 2*i + 1;
            int max = i;
            if (left <= N && arr[left] > arr[i])
                max = left;
            if (right <= N && arr[right] > arr[max])
                max = right;

            if (max != i)
            {
                swapNumbers( i, max, arr);
                maxheap(arr, max);
            }
        }
 }


