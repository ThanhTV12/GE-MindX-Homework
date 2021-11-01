package lesson003.homework;

public class Hw001LeetCode88MergeSortedArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums1 = new int []{1,2,3,0,0,0};
//        int[] nums2 = new int []{2,5,6};
//        int m = 3;
//        int n = 3;
        int[] nums1 = new int []{0};
        int[] nums2 = new int []{1};
        int m = 0;
        int n = 1;
        solution.merge(nums1, m, nums2, n);
    }

    private static class Solution {
        /*
         *  time 0(n + m)
         *  space O(1)
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int resultIndex = m + n - 1;
            while (m > 0 && n > 0) {
                if(nums1[m - 1] > nums2[n - 1]) {
                    nums1[resultIndex--] = nums1[m - 1];
                    m--;
                } else {
                    nums1[resultIndex--] = nums2[n - 1];
                    n--;
                }
            }
            if(n > 0) {
                while (resultIndex >= 0) {
                    nums1[resultIndex--] = nums2[n - 1];
                    n--;
                }
            }
        }
    }
}
