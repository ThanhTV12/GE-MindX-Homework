package lesson1.homework;

public class Problem4LeetCode283MoveZeros {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
    }

    private static class Solution {
        public void moveZeroes(int[] nums) {
            int pivot = 0;
            int boundary = -1;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] != pivot) {
                    boundary++;
                    int temp = nums[i];
                    nums[i] = nums[boundary];
                    nums[boundary] = temp;
                }
            }
        }
    }
}
