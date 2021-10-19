package lesson5.homework;

import java.util.HashMap;
import java.util.Map;

public class Hw007LeetCode387FirstUniqueCharacterInAString {

    private static class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> mapOfCharacterAnIndex = new HashMap();
            int result = -1;
            for(int i = 0; i < s.length(); i++) {
                if(mapOfCharacterAnIndex.containsKey(s.charAt(i))) {
                    mapOfCharacterAnIndex.put(s.charAt(i), 1 + mapOfCharacterAnIndex.get(s.charAt(i)));
                } else {
                    mapOfCharacterAnIndex.put(s.charAt(i), 1);
                }
            }

            for(int i = 0; i < s.length(); i++) {
                if(mapOfCharacterAnIndex.get(s.charAt(i)) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
}
