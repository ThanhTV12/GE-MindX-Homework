package lesson009.homework;

public class Hw009LeetCode1760MinimumLimitOfBallsInABag {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minimumSize(new int[]{9}, 2);
    }

    private static class Solution {
        public int minimumSize(int[] nums, int maxOperations) {
            //nums = [2,4,8,2],
            //maxOperations = 4
            //Using BS
            //initiate lo = 0, hi = 10e9
            //mid = lo + (hi - lo) / 2
            //mid = 4
            //2, 4 -> 4, 4, 4, 2, 2

            int lo = 1;
            int hi = 1000000000;
            int result = 1;
            while(lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if(isValid(nums, maxOperations, mid)) {
                    result = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            return result;
        }

        private boolean isValid(int[] nums, int maxOperations, int ballExpected) {
            for(int i = 0; i < nums.length; i++) {
                int value = nums[i];
                if(value > ballExpected) {
                    if(maxOperations < 1) {
                        return false;
                    }
                    int numberOfDivision = value / ballExpected;
                    int remainder = value % ballExpected;
                    if(remainder == 0) {
                        maxOperations -= (numberOfDivision - 1);
                    } else {
                        maxOperations -= numberOfDivision;
                    }
                    if(maxOperations < 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
