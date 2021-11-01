package lesson001.homework;

public class Problem7LeetCode922SortArrayByParity2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sorted = solution.sortArrayByParityII(new int[]{4, 2, 5, 7});
    }

    private static class Solution {
        public int[] sortArrayByParityII(int[] nums) {
            int boundary = -1;
            for(int i = 0; i < nums.length; i++) {
                if(isValid(nums[i], i)) {
                    boundary++;
                } else {
                    int itemForSwappingIndex = findItemForSwapping(nums, i);
                    if(itemForSwappingIndex == -1) {
                        continue;
                    }
                    swap(nums, ++boundary, itemForSwappingIndex);
                }
            }
            return nums;
        }

        private void swap(int[] nums, int first, int second) {
            int temp = nums[first];
            nums[first] = nums[second];
            nums[second] = temp;
        }

        private boolean isValid(int num, int position) {
            if(position % 2 == 0) {
                return num % 2 == 0;
            }
            return num % 2 != 0;
        }

        private int findItemForSwapping(int[] nums, int start) {
            for(int i = start + 1; i < nums.length; i = i + 2) {
                if(!isValid(nums[i], i)) {
                    return i;
                }
            }
            return -1;
        }
    }
}
