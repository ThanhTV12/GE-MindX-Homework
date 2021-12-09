package Lesson15.Trie;

import java.util.Arrays;

public class Hw003LeetCode720LongestWordInDictionary {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[] {"w","wo","wor","worl","world"};
        String s = solution.longestWord(words);
    }

    private static class Solution {

        //Use trie argorithm
        //The an avliable to store the current result
        // insert all words into the child, update current result if it is better than the current one
        public String longestWord(String[] words) {
            String res = "";
            TrieNode root = new TrieNode();

            //Build trie
            TrieNode cur = root;
            for(String word : words) {
                for(int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if(cur.children[c - 'a'] == null) {
                        cur.children[c - 'a'] = new TrieNode();
                    }
                    cur = cur.children[c - 'a'];
                    if(i == word.length() - 1) {
                        cur.isWord = true;
                    }
                }
                cur = root; //reset
            }

            // Find longest
            Arrays.sort(words);  //lexicographical order
            for(String word : words) {
                cur = root;
                for(int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    cur = cur.children[c - 'a'];
                    if(cur.isWord == false) {
                        break;
                    }
                    if(i == word.length() - 1) {
                        if(res.length() < word.length()) {
                            res =  word;
                        }
                    }
                }
            }
            return res;
        }
    }


    private  static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
    }
}
