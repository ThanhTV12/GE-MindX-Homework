package lesson011;

import java.util.HashMap;
import java.util.Map;

public class Hw014LeetCode76MinimunWindowSubstring {

    public static void main(String[] args) {
        String s = "aa";
        String t = "aa";
        Solution solution = new Solution();
        String s1 = solution.minWindow(s, t);
    }

    private static class Solution {
        public String minWindow(String s, String t) {
            if(s.length() == 0 || t.length() == 0) {
                return "";
            }
            String res = "";
            int left = 0;
            int tLength = t.length();
            int resLength = 0;


            for(int i = 0; i < t.length(); i++) {
                if(mapT.containsKey(t.charAt(i))) {
                    mapT.put(t.charAt(i), mapT.get(t.charAt(i)) + 1);
                } else {
                    mapT.put(t.charAt(i), 1);
                }
            }


            for (int right = 0; right < s.length(); right++) {
                Character c = s.charAt(right);
                visit(c);
                if(!visitedEnough()) {
                    continue;
                }

                while (!mapT.containsKey(s.charAt(left)) || countVisited.get(s.charAt(left)) > mapT.get(s.charAt(left))) {
                    if(countVisited.containsKey(s.charAt(left))) {
                        moveVisite(s.charAt(left));
                    }
                    left++;
                }

                int length = right - left + 1;
                String debug = s.substring(left, right + 1);
                if("".equals(res) || length < res.length()) {
                    res = s.substring(left, right + 1);
                }
            }
            return res;
        }

        Map<Character, Integer> mapT = new HashMap();
        Map<Character, Integer> countVisited = new HashMap();
        private void visit(Character c) {
            if(!mapT.containsKey(c)) {
                return;
            }
            if(countVisited.containsKey(c)) {
                countVisited.put(c, countVisited.get(c) + 1);
            } else {
                countVisited.put(c, 1);
            }
        }

        private int getVisitedNumber(Character c) {
            if(countVisited.containsKey(c)) {
                return countVisited.get(c);
            }
            return 0;
        }

        private void moveVisite(Character c) {
            countVisited.put(c, countVisited.get(c) - 1);
        }
        private boolean visitedEnough() {
            if(countVisited.size() < mapT.size()) {
                return false;
            }
            for(Character c : mapT.keySet()) {
                if(countVisited.get(c) < mapT.get(c)) {
                    return false;
                }
            }
            return true;
        }
    }
}
