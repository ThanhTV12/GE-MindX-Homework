package Lesson15.Trie;

import java.util.*;

public class Hw005LeetCode642DesignSearchAutocompleteSystem {
    public static void main(String[] args) {
        String[] sentences = new String[] {"obc","abbc","a"};
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(sentences, new int[]{3,3,3});
        Character[] cs = new Character[] {'w','o','#'};
        Character[] cs1 = new Character[] {'b','c','#'};
        Character[] cs2 = new Character[] {'a','b','c','#'};
        Character[] cs3 = new Character[] {'a','b','c','#'};
        System.out.println("round 1");
        for(Character c : cs) {
            System.out.println(autocompleteSystem.input(c));
        }
        System.out.println("round 2");
        for(Character c : cs1) {
            System.out.println(autocompleteSystem.input(c));
        }
        System.out.println("round 3");
        for(Character c : cs2) {
            System.out.println(autocompleteSystem.input(c));
        }
        System.out.println("round 4");
        for(Character c : cs3) {
            System.out.println(autocompleteSystem.input(c));
        }
    }

    static class AutocompleteSystem {

        Trie trie = new Trie();
        String prefix = "";
        public AutocompleteSystem(String[] sentences, int[] times) {
            for(int i = 0; i < sentences.length; i++) {
                trie.insert(sentences[i], times[i]);
            }
        }

        public List<String> input(char c) {
            return trie.search(c);
        }
    }

    static class Trie {
        private TrieNode root = new TrieNode();
        Map<String, Integer> sentenceFrequency = new HashMap<>();
        private TrieNode searchNode = root;
        private String prefix = "";
        public void insert(String sentence, int moreTime) {
            TrieNode cur = root;

            //Get sentence and time of itself
            int oldTime = 0;
            if(sentenceFrequency.containsKey(sentence)) {
                oldTime = sentenceFrequency.get(sentence);
                sentenceFrequency.put(sentence, oldTime + moreTime);
            } else {
                sentenceFrequency.put(sentence, moreTime);
            }
            for(int i = 0; i < sentence.length(); i++) {
                char c = sentence.charAt(i);
                if(cur.children[getIndex(c)] == null) { // the character was not exsiting, create new one
                    cur.children[getIndex(c)] = new TrieNode();
                }
                cur = cur.children[getIndex(c)];
                cur.heap.remove(new ValueSen(sentence));
                cur.heap.add(new ValueSen(sentence, oldTime + moreTime));
            }
        }

        private boolean isStopSearch = false;
        public List<String> search(char c) {
            if('#' == c) {
                this.searchNode = root;
                insert(prefix, 1);
                this.prefix = "";
                this.isStopSearch = false;
                return Collections.EMPTY_LIST;
            }
            prefix += c;
            if(isStopSearch) {
                return Collections.EMPTY_LIST;
            }
            List<String> res = new ArrayList<>();
            if(searchNode.children[getIndex(c)] != null) {
                Queue<ValueSen> heap = searchNode.children[getIndex(c)].heap;
                List<ValueSen> cache = new ArrayList<>();
                while (!heap.isEmpty()) {
                    ValueSen value = heap.remove();
                    cache.add(value);
                    res.add(value.sentence);
                    if(res.size() == 3) {
                        break;
                    }
                }
                heap.addAll(cache);
                searchNode = searchNode.children[getIndex(c)];
            } else {
                this.isStopSearch = true;
            }
            return res;
        }

        private int getIndex(char c) {
            if(' ' == c) {
                return 26;
            }
            return c - 'a';
        }
    }


    static class TrieNode {
        public TrieNode[] children = new TrieNode[27];
        public Queue<ValueSen> heap = new PriorityQueue<>();
    }

    static class ValueSen implements Comparable {
        public String sentence;
        public int time = 0;

        public ValueSen() {
        }

        public ValueSen(String sentence){
            this.sentence = sentence;
        }

        public ValueSen(String sentence, int time) {
            this.sentence = sentence;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if(o == null) {
                return false;
            }
            if(o.getClass() != getClass()) {
                return false;
            }
            ValueSen second = (ValueSen) o;
            return second.sentence.equals(this.sentence);
        }


        @Override
        public int compareTo(Object o) {
            ValueSen second = (ValueSen) o;
            if(this.time != second.time) {
                return Integer.compare(second.time, this.time);
            }
            return this.sentence.compareTo(second.sentence);
        }
    }
}
