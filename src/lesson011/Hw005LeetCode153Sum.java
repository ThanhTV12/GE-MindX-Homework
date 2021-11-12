package lesson011;

import java.util.*;

public class Hw005LeetCode153Sum {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,1,1,2};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(nums);
    }

    private static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList();
            for(int i = 0; i < nums.length - 1; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                while(left < right) {
                    if (nums[left] + nums[right] + nums[i] == 0) {
                        if(!isContaint(nums[left], nums[right], nums[i])) {
                            result.add(Arrays.asList(nums[left], nums[right], nums[i]));
                        }
                        break;
                    } else if (nums[left] + nums[right] + nums[i] > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return result;
        }
        Set<Item> set = new HashSet();
        private boolean isContaint(int first, int second, int third) {
            Item item = new Item(first, second, third);
            if(set.contains(item)) {
                return true;
            }
            set.add(item);
            return false;
        }
    }

    private static class Item {
        public int first;
        public int second;
        public int third;

        public Item(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return first == item.first && second == item.second && third == item.third;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second, third);
        }
    }
}
