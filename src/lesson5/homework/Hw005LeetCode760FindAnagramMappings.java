package lesson5.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hw005LeetCode760FindAnagramMappings {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] anagramMappings(int[] nums1, int[] nums2) {
            Map<Integer, Integer> mapOfNum2AndIndex = new HashMap<>(nums2.length);
            for(int i = 0; i < nums2.length; i++) {
                mapOfNum2AndIndex.put(nums2[i], i);
            }
            int index = -1;
            for(int i = 0; i < nums1.length; i++) {
                if(mapOfNum2AndIndex.containsKey(nums1[i])) {
                    /*
                     *  use nums2 to save result to save memory
                     */
                    nums2[++index] = mapOfNum2AndIndex.get(nums1[i]);
                }
            }
            if(index == -1) {
                return new int[] {};
            }
            return Arrays.copyOf(nums2, index + 1);
        }
    }
}
