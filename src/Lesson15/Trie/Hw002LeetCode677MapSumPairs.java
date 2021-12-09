package Lesson15.Trie;

import java.util.HashMap;
import java.util.Map;

public class Hw002LeetCode677MapSumPairs {
    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum obj = new MapSum();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */

// Use Trie
// create a tree to descible all word with charecters

    class MapSum {

        private TrieNode root;
        Map<String, Integer> mapKeyValue = new HashMap();
        public MapSum() {
            root = new TrieNode();
        }

        //Time: O(k * n)     k: length of key, n: the number of values
        //space: O(n)
        public void insert(String key, int val) {
            TrieNode cur = root;
            boolean isExisting = mapKeyValue.containsKey(key);
            for(int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if(cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                    cur.children[c - 'a'].sum = val;
                } else {
                    if(isExisting) {
                        cur.children[c - 'a'].sum += -mapKeyValue.get(key) + val;
                    } else {
                        cur.children[c - 'a'].sum = cur.children[c - 'a'].sum + val;
                    }
                }
                cur = cur.children[c - 'a'];
            }
            mapKeyValue.put(key, val);
        }

        //Time: 0(long of prefix)
        public int sum(String prefix) {
            TrieNode cur = root;
            for(int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if(cur.children[c - 'a'] != null) {
                    cur = cur.children[c - 'a'];
                } else {
                    return 0;
                }
            }
            return cur.sum;
        }
    }

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public int sum = 0;
    }

//ap => 5
//appl => 3
// app: 2
//a, 3 + 2 => 5

//p, 3 + 2 => 5

//p, 3 + 2 =>


//l, 3

//e, 3
}
