package Lesson15.Trie;

public class Hw005LeetCode1032StreamOfCharacters {

    public static void main(String[] args) {
        String[] words =new String[] {"cd", "f", "kl"};
        StreamChecker checker = new StreamChecker(words);
        char[] letters = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l'};
        for(char l : letters) {
            System.out.println(checker.query(l));
        }
        String a = "a";
    }

    static class StreamChecker {

        private TrieNode root = new TrieNode();
        public StreamChecker(String[] words) {
            for(String word : words) {
                TrieNode cur = root;
                StringBuilder sb = new StringBuilder(word);
                sb.reverse();
                for(int i = 0; i < sb.length(); i++) {
                    char c = sb.charAt(i);
                    if(cur.childrens[c - 'a'] == null) {
                        cur.childrens[c - 'a'] = new TrieNode();
                    }
                    cur = cur.childrens[c - 'a'];
                }
                cur.isWord = true;
            }
        }

        private StringBuilder input = new StringBuilder();
        public boolean query(char letter) {
            input.insert(0, letter);
            // Check prefix with the trie
            TrieNode cur = root;
            for(int  i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if(cur.childrens[c - 'a'] == null) {
                    return false;
                }
                cur = cur.childrens[c - 'a'];
                if(cur.isWord) {
                    return true;
                }
            }
            return false;
        }
    }


    static class TrieNode {
        public TrieNode[] childrens = new TrieNode[26];
        public boolean isWord = false;
    }
}
