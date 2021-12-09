package Lesson15.Trie;

import java.util.PriorityQueue;
import java.util.Queue;

public class Hw006LeetCode745PrefixAndSuffixSearch {
    class WordFilter {

        public WordFilter(String[] words) {
            for(int index = 0; index < words.length; index++) {
                String word = words[index];
                String nW = null;
                if(word.length()  == 1) {
                    nW = word + "#" + word;
                    putToTrie(nW, index);
                    continue;
                }
                for(int i = 1; i < word.length(); i++) {
                    nW = word.substring(word.length() - i) + "#" + word;
                    putToTrie(nW, index);
                }
            }
        }

        public int f(String prefix, String suffix) {
            return checkFrefix(suffix + "#" + prefix);
        }

        private int getKey(char c) {
            if(c == '#')  {
                return 26;
            }
            return c - 'a';
        }

        TrieNode root = new TrieNode();
        private void putToTrie(String s, int index) {
            TrieNode cur = root;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(cur.children[getKey(c)] == null) {
                    cur.children[getKey(c)] = new TrieNode();
                }
                cur = cur.children[getKey(c)];
                cur.heap.add(index);
            }
        }

        private int checkFrefix(String s) {
            TrieNode cur = root;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(cur.children[getKey(c)] == null) {
                    return -1;
                }
                cur = cur.children[getKey(c)];
            }
            return cur.heap.peek();
        }

    }


    class TrieNode {
        public TrieNode[]  children = new TrieNode[27];
        public Queue<Integer> heap = new PriorityQueue<>((a, b) -> Integer.compare(b , a)); //int[0] index of word, int[1] length
    }
/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
}
