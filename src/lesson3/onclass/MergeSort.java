package lesson3.onclass;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 1, 2, 5, 0, 9, 4, 7, 6};
        sort(nums);
    }

    private static int[] sort(int[] nums) {
        if(nums.length <= 1) {
            return nums;
        }
        int halfSize = nums.length / 2;
        int[] leftSorted = sort(Arrays.copyOfRange(nums, 0, halfSize));
        int[] rightSorted = sort(Arrays.copyOfRange(nums, halfSize, nums.length));
        return mergeSort(leftSorted, rightSorted);
    }

    private static int[] mergeSort(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] sorted = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if(left[i] < right[j]) {
                sorted[k++] = left[i++];
            } else {
                sorted[k++] = right[j++];
            }
        }
        while (i < left.length) {
            sorted[k++] = left[i++];
        }
        while (j < right.length) {
            sorted[k++] = right[j++];
        }
        return sorted;
    }
}
