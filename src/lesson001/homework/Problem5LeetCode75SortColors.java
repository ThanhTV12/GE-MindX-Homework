package lesson001.homework;

public class Problem5LeetCode75SortColors {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] colors = new int[] {0, 2, 1, 0, 0, 1, 2, 0};
        solution.sortColorsV2(colors, 3);
    }

    private static class Solution {
        // red = 0
        // white = 1
        // blue = 2
        //Solution 1  Datch Plag Partition Problem
        public void sortColorsV1(int[] nums) {
            int pivot = 1;
            //from left to right
            int boundary = -1;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] < pivot) {
                    boundary++;
                    int temp = nums[i];
                    nums[i] = nums[boundary];
                    nums[boundary] = temp;
                }
            }

            //from right to left
            boundary = nums.length;
            for(int i = nums.length - 1; i >= 0; i--) {
                if(nums[i] > pivot) {
                    boundary--;
                    int temp = nums[i];
                    nums[i] = nums[boundary];
                    nums[boundary] = temp;
                }
            }
        }

        // solution 2 if there are move than 3 color
        public void sortColorsV2(int[] nums, int numberOfColor) {
            int[] numberOfColorByIndex = new int[numberOfColor];
            for(int i = 0; i < nums.length; i++) {
                numberOfColorByIndex[nums[i]] = numberOfColorByIndex[nums[i]] + 1;
            }
            int numsIndex = 0;
            for(int colorIndex = 0; colorIndex < numberOfColorByIndex.length; colorIndex++) {
                for(int i = 0; i < numberOfColorByIndex[colorIndex]; i++) {
                    nums[numsIndex++] = colorIndex;
                }
            }
        }
    }
}
