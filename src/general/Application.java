package general;

public class Application {

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        List<Integer> anagrams = solution.findAnagrams("abab", "ab");
    }

    //438. Find All Anagrams in a String
    private static class Solution {
//        public List<Integer> findAnagrams(String s, String p) {
//            HashMap<Character, Boolean> mapOfAnagram = intMapOfAnagram(p);
//            List<Integer> results = new ArrayList<>();
//            int lengthOfP = p.length();
//            int i = 0;
//            while (i < s.length() - lengthOfP + 1) {
//                String subInput = s.substring(i, i + lengthOfP);
//                if(isValidAnagrams(subInput, mapOfAnagram)) {
//                    results.add(i);
//                }
//                i++;
//            }
//            return results;
//        }
//
//        private boolean isValidAnagrams(String subString, HashMap<Character, Boolean> mapOfAnagram) {
//            Map<Character, Boolean> checkMark = new HashMap<>(mapOfAnagram);
//            for(int i = 0; i < subString.length(); i++) {
//                if(!checkMark.containsKey(subString.charAt(i))) {
//                    return false;
//                }
//                checkMark.put(subString.charAt(i), true);
//            }
//            return isValid(checkMark);
//        }
//
//        private HashMap<Character, Integer> intMapOfAnagram(String p) {
//            HashMap<Character, Integer> map = new HashMap<>();
//            for(int i = 0; i < p.length(); i++) {
//                map.put(p.charAt(i), 0);
//            }
//            return map;
//        }
//
//        private boolean isValid(Map<Character, Integer> mapOfAnagram) {
//            for(Integer numbeOfvisible : mapOfAnagram.values()) {
//                if(visible == false) {
//                    return false;
//                }
//            }
//            return true;
//        }
    }
}
