package Lesson15.Trie;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hw007LeetCode676ImplementMagicDictionary {

    public static void main(String[] args) {
        List<String> a =  Collections.EMPTY_LIST;
    }

    class MagicDictionary {

        private TrieNode root;
        public MagicDictionary() {
            root = new TrieNode();
        }

        public void buildDict(String[] String) {
            for(String word : String) {
                for(int i = 0; i < word.length(); i++) {
                    StringBuilder wordReplace = new StringBuilder(word);
                    wordReplace.deleteCharAt(i);
                    wordReplace.insert(i, REPLACE_KEY);
                    //System.out.println(wordReplace);
                    putToTrie(wordReplace, word);
                }
            }
        }


        public boolean search(String searchWord) {
            for(int i = 0; i < searchWord.length(); i++) {
                StringBuilder wordReplace = new StringBuilder(searchWord);
                wordReplace.deleteCharAt(i);
                wordReplace.insert(i, REPLACE_KEY);
                boolean isExist = exist(wordReplace, searchWord);
                if(isExist == true) {
                    return true;
                }
            }
            return false;
        }

        private char REPLACE_KEY = '#';
        private int getKey(char c) {
            if(REPLACE_KEY == c) {
                return 26;
            }
            return c - 'a';
        }

        private void putToTrie(StringBuilder sb, String word) {
            TrieNode cur = root;
            for(int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if(cur.children[getKey(c)] == null) {
                    cur.children[getKey(c)] = new TrieNode();
                }
                cur = cur.children[getKey(c)];
            }
            cur.isWord = true;
            cur.words.add(word);
        }

        private boolean exist(StringBuilder sb, String searchWord) {
            TrieNode cur = root;
            for(int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if(cur.children[getKey(c)] == null) {
                    return false;
                }
                cur = cur.children[getKey(c)];
            }
            if(cur.isWord == false) {
                return false;
            }
            if(cur.words.contains(searchWord) && cur.words.size() == 1) {
                return false;
            }
            return true;
        }
    }

    class TrieNode {
        public TrieNode[] children = new TrieNode[27];
        public boolean isWord = false;
        public Set<String> words = new HashSet();
    }

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
}
