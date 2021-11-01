package lesson005.homework;

import java.util.HashSet;
import java.util.Set;

public class Hw008LeetCode266PalindromePermutation {
    public static void main(String[] args) {

    }

    /*
     * create setOfItem to store all character when iterate through all characters of s
     * while iterating if setOfItem contains the character, we remove it. Because they are a double, we don't care
     * finally, if the remainder items more than 1. We can create a Palindrome from them so return false
     * if if the remainder items less than 1. return true
     */
    class Solution {
        public boolean canPermutePalindrome(String s) {
            Set<Character> setOfItem = new HashSet(s.length());
            for(int i = 0; i < s.length(); i++) {
                if(setOfItem.contains(s.charAt(i))) {
                    setOfItem.remove(s.charAt(i));
                } else {
                    setOfItem.add(s.charAt(i));
                }
            }
            return setOfItem.size() < 2;
        }
    }
}
