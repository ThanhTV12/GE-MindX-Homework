package lesson009.homework;

public class Hw006LeetCode69Sqrt {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.mySqrt(2147395599);
    }

    private static class Solution {
        public int mySqrt(int x) {
            int lo = 0;
            int hi = x;
            if(x < 2) {
                return x;
            }
            while(lo <= hi) {
                long mid = lo + (hi - lo) / 2;
                if((mid * mid <= x) && ((mid + 1) * (mid + 1)) > x) {
                    return (int) mid;
                }
                if(mid * mid >= x) {
                    hi = (int) mid - 1;
                } else {
                    lo = (int)mid + 1;
                }
            }
            return lo;
        }
    }
}
