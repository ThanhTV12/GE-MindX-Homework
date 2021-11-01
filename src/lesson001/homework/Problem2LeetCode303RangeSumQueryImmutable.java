package lesson001.homework;

public class Problem2LeetCode303RangeSumQueryImmutable {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        int rang02 = numArray.sumRange(2, 5);
    }

    private static class NumArray {

        int[] prefixSums;

        public NumArray(int[] nums) {
            /*convert sums to array of prefix sum of nums*/
            int prefixSum = 0;
            for(int i = 0; i < nums.length; i++) {
                prefixSum += nums[i];
                nums[i] = prefixSum;
            }
            prefixSums = nums;
        }

        public int sumRange(int left, int right) {
            if(left == 0) {
                return prefixSums[right];
            }
            return prefixSums[right] - prefixSums[left - 1];
        }
    }
}
