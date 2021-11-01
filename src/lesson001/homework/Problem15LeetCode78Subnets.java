package lesson001.homework;

import java.util.ArrayList;
import java.util.List;

public class Problem15LeetCode78Subnets {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(new int[]{1, 2, 3});
    }

    private static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            for(int i = 0; i < 8; i++) {
                result.add(getSubnetByBits(nums, i));
            }
            return result;
        }

        private List<Integer> getSubnetByBits(int[] nums, int bits) {
            List<Integer> subnet = new ArrayList<>();
            for(int i = 0; i < 3; i++) {
                if(getBit(bits, i) == 1) {
                    subnet.add(nums[i]);
                }
            }
            return subnet;
        }

        private int getBit(int bits, int position) {
            int mark = bits>>position;
            return mark & 1;
        }
    }
}
