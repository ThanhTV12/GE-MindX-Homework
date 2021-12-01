package lesson011_2_pointer;

import java.util.HashMap;
import java.util.Map;

public class Hw011LeetCode340LongestSubstringwithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = solution.lengthOfLongestSubstringKDistinct("abaccc", 2);
    }
    private static class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if(k < 1) {
                return 0;
            }
            Map<Character, Integer> tracker = new HashMap();
            int left = 0;
            int right = 0;
            int sLength = s.length();
            int res = 0;
            while(right < sLength) {
                Character c = s.charAt(right);
                if(tracker.size() < k || tracker.containsKey(c)) {
                    tracker.put(c, right);
                    int length = right - left + 1;
                    if(res < length) {
                        res = length;
                    }
                    right++;
                } else {
                    while (left < right) {
                        int index = tracker.get(s.charAt(left));
                        if(index == left) {
                            tracker.remove(s.charAt(left));
                            left++;
                            break;
                        }
                        left++;
                    }
                    tracker.put(c, right);
                }
            }
            return res;
        }
    }
}
