package lesson14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hw002LeetCode737SentenceSimilarity3 {

    public static void main(String[] args) {
        String[] sentence1 = {"I","love","leetcode"};
        String[] sentence2 = {"I","love","onepiece"};
        List<List<String>> similarPairs =  Arrays.asList(
                Arrays.asList("manga","onepiece"),
                Arrays.asList("platform","anime"),
                Arrays.asList("leetcode","platform"),
                Arrays.asList("anime","manga"));
        Solution solution = new Solution();
        boolean b = solution.areSentencesSimilarTwo(sentence1, sentence2, similarPairs);
    }

    private static class Solution {
        private Map<String, String> parents = new HashMap();
        private Map<String, Integer> ranks = new HashMap();
        public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
            buildUnionFind(similarPairs);
            if(sentence1.length != sentence2.length) {
                return false;
            }
            for(int i = 0; i < sentence1.length; i++) {
                if(sentence1[i].equals(sentence2[i])) {
                    continue;
                }
                System.out.println("----------------");
                String root1 = find(sentence1[i]);
                String root2 = find(sentence2[i]);
                if(root1 != root2) {
                    return false;
                }
            }

            return true;
        }


        private void buildUnionFind(List<List<String>> similarPairs) {
            for(List<String> similarPair : similarPairs) {
                union(similarPair.get(0), similarPair.get(1));
            }
        }


        private String find(String word) {
            if(!parents.containsKey(word)) {
                parents.put(word, word);
                ranks.put(word, 0);
                return word;
            }
            String parent = parents.get(word);
            if(word.equals(parent)) {
                return parent;
            }
            parent = find(parent);
            parents.put(word, parent);
            return parent;
        }

        private void union(String u, String v) {
            String rootU = find(u);
            String rootV = find(v);
            if(ranks.get(rootU) == ranks.get(rootV)) {
                parents.put(rootV, rootU);
                ranks.put(rootU, ranks.get(rootU) + 1);
            } else if(ranks.get(rootU) == ranks.get(rootV)) {
                parents.put(rootV, rootU);
            } else {
                parents.put(rootU, rootV);
            }
        }
    }
}
