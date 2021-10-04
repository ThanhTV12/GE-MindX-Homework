package lesson1.homework;

public class Problem1LeetCode480RunningSumOf1dArray {
    public static void main(String[] args) {
        int[] prefixSums = runningSum(new int[] {1, 2, 3, 4});
    }
    public static int[] runningSum(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result += nums[i];
            nums[i] = result;
        }
        return nums;
    }
}
