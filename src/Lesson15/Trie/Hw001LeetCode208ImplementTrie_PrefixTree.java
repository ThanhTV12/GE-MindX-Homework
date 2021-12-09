package Lesson15.Trie;

public class Hw001LeetCode208ImplementTrie_PrefixTree {
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

    class Trie {

        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
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
        }

        public boolean search(String word) {
            TrieNode cur = root;
            for(char c : word.toCharArray()) {
                if(cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return cur.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for(char c : prefix.toCharArray()) {
                if(cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return true;
        }
    }

    class TrieNode {
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
    }
}
