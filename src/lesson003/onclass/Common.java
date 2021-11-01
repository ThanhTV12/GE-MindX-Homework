package lesson003.onclass;

import java.util.Random;

public abstract class Common {

    private static Random r = new Random();

    protected static int dutchFlagPartition(int[] arr, int pivot) {
        int boundaryLeft = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < pivot) {
                boundaryLeft++;
                sawp(arr, i, boundaryLeft);
            }
        }
        int boundaryRight = arr.length;
        for(int i = arr.length - 1; i > boundaryLeft; i--) {
            if(arr[i] > pivot) {
                boundaryRight--;
                sawp(arr, i, boundaryRight);
            }
        }
        return (boundaryLeft + boundaryRight) >> 1;
    }

    protected static void sawp(int[] arr, int leftIndex, int rightIndex) {
        int temp = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = temp;
    }

    protected static int getRandomNumber(int min, int max) {
        return (int)((Math.random() * (max - min + 1)) + min);
    }
}
