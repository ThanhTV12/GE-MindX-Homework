package lesson001.homework;

public class Problem6LeetCode905SortArrayByParity {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sorted = solution.sortArrayByParity(new int[]{6, 3, 1, 2, 4});
    }

    private static class Solution {

        //3,1,2,4
        //Datch Plag partition Problem
        public int[] sortArrayByParity(int[] nums) {
            int boundary = -1;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] % 2 == 0) {
                    boundary++;
                    swap(nums, i, boundary);
                }
            }
            return nums;
        }


        private void swap(int[] nums, int first, int second) {
            int temp = nums[first];
            nums[first] = nums[second];
            nums[second] = temp;
        }
    }
}
