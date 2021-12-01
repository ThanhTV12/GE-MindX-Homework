package lesson011_2_pointer;

public class Hw001LeetCode845LongestMountainInArray {

    public static void main(String[] args) {

    }
    class Solution {
        public int longestMountain(int[] arr) {
            int left = 0;
            int right = 0;
            int res = 0;
            while(right < arr.length) {
                while(right < arr.length - 1 && arr[right + 1] > arr[right] ) {
                    right++;
                }
                int top = right;
                while(right < arr.length - 1 && arr[right + 1] < arr[right] ) {
                    right++;
                }
                if(left != top  && top != right) {
                    int length = right - left + 1;
                    if (length > res) {
                        res = length;
                    }
                }
                if(left == right) {
                    right++;
                    left = right;
                } else {
                    left = right;
                }
            }
            return res;
        }
    }

}
