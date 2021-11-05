package lesson009.homework;

public class Hw001LeetCode852PeakIndexnInAountainArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int peak = solution.peakIndexInMountainArray(new int[]{3, 5, 3, 2, 0});
    }

    private static class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int lo = 0;
            int hi = arr.length - 1;
            while(lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if(arr[mid] < arr[mid - 1]) {
                    hi = mid;
                } else if(arr[mid] < arr[mid + 1]) {
                    lo = mid;
                } else {
                    return -1;
                }
            }
            return -1;
        }
    }
}
