package lesson011_2_pointer;

import java.util.HashMap;
import java.util.Map;

public class Hw010LeetCode3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int abcabcbb = solution.lengthOfLongestSubstring("abcabcbb");
    }


    private static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int res = 0;
            Map<Character, Integer> map = new HashMap();
            int left = 0;
            int right = 0;
            while (right < s.length()) {
                Character c = s.charAt(right);
                if(!map.containsKey(c)) {
                    map.put(c, right);
                    int length = right - left + 1;
                    if(length > res) {
                        res = length;
                    }
                    right++;
                } else {
                    left = map.get(c) + 1;
                    map.put(c, right);
                }
            }
            return res;
        }
    }
}
