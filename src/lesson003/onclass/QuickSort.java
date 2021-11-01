package lesson003.onclass;

import java.util.Arrays;

public class QuickSort extends Common {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 1, 8, 2, 5, 0, 9, 4, 7, 6};
        //int[] nums = new int[] {3, 1, 8, 2, 5};
        int[] sorted = sortV2(nums);
    }

    //v1
    private static int[] sort(int[] nums) {
        if(nums.length < 2) {
            return nums;
        }
        int pivot = nums[getRandomNumber(0, nums.length)];
        int p = dutchFlagPartition(nums, pivot);
        int[] left = Arrays.copyOfRange(nums, 0, p);
        int[] right = Arrays.copyOfRange(nums, p + 1, nums.length);
        int[] leftSorted = sort(left);
        int[] rightSorted = sort(right);
        int[] result = Arrays.copyOf(leftSorted, leftSorted.length + rightSorted.length + 1);
        result[leftSorted.length] = pivot;
        System.arraycopy(rightSorted, 0, result, leftSorted.length + 1, rightSorted.length);
        return result;
    }

    /*------------*/
    //V2
    private static int[] sortV2(int[] nums) {
        return qs(nums, 0, nums.length - 1);
    }

    private static int[] qs(int[] nums, int left, int right) {
        if(left >= right) {
            return nums;
        }
        int pivot = nums[getRandomNumber(left, right)];
        int partitionPosition = dutchFlagPartition(nums, pivot);
        qs(nums, left, partitionPosition - 1);
        qs(nums, partitionPosition + 1, right);
        return nums;
    }
}
