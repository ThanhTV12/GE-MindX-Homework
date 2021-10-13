package lesson3.homework;


import lesson3.onclass.Common;

import java.util.Arrays;

//https://leetcode.com/problems/the-k-strongest-values-in-an-array
//TODO level Median
public class Hw011LeetCode1471TheKStrongestValuesInArray {
    public static void main(String[] args) {
        int[] arr = {-7, 22, 17, 3};
        int k = 2;
        Solution solution = new Solution();
        int[] strongest = solution.getStrongest(arr, k);
    }

    /*
     *  time O(2nlog(n)) = O(nlog(n))
     *  space O(log(n))
     */
    private static class Solution extends Common {
        public int[] getStrongest(int[] arr, int k) {
            //Step 1 find median
            int medianIndex = (arr.length - 1) / 2;
            int median = findMedian(arr, medianIndex, 0, arr.length - 1);

            //Step 1 find longest
            return getStrongest(arr, median, k, 0, arr.length - 1);
        }

        private int[] getStrongest(int[] arr, int median, int k, int left, int right) {
            int pivot = arr[getRandomNumber(left, right)];
            int strongestPointStarted = strongestPartition(arr, median, pivot);
            if(arr[strongestPointStarted] == arr[arr.length - k]) {
                return Arrays.copyOfRange(arr, arr.length - k, arr.length);
            }
            if(strongestPointStarted > arr.length - k) {
                return getStrongest(arr, median, k, left, strongestPointStarted - 1);
            }
            return getStrongest(arr, median, k, strongestPointStarted + 1, right);
        }

        private static int strongestPartition(int[] arr, int median, int pivot) {
            int boundaryLeft = -1;
            int absOfPivotWithMedian = Math.abs(pivot - median);
            for(int i = 0; i < arr.length; i++) {
                if(Math.abs(arr[i] - median) < absOfPivotWithMedian ||
                        (Math.abs(arr[i] - median) == absOfPivotWithMedian && arr[i] < pivot)) {
                    boundaryLeft++;
                    sawp(arr, i, boundaryLeft);
                }
            }
            int boundaryRight = arr.length;
            for(int i = arr.length - 1; i >= 0; i--) {
                if(Math.abs(arr[i] - median) > absOfPivotWithMedian ||
                        (Math.abs(arr[i] - median) == absOfPivotWithMedian && arr[i] > pivot)) {
                    boundaryRight--;
                    sawp(arr, i, boundaryRight);
                }
            }
            return (boundaryLeft + boundaryRight) >> 1;
        }

        private int findMedian(int[] arr, int medianIndex, int left, int right) {
            int pivot = arr[getRandomNumber(left, right)];
            int partitionIndex = dutchFlagPartition(arr, pivot);
            if(arr[partitionIndex] == arr[medianIndex]) {
                return pivot;
            }
            if(partitionIndex > medianIndex) {
                return findMedian(arr, medianIndex, left, partitionIndex - 1);
            }
            return findMedian(arr, medianIndex,partitionIndex + 1, right);
        }
    }
}
