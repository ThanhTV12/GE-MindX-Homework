package lesson14;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hw003LeetCode734SentenceSimilarity {
    class Solution {
        public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
            if(sentence1.length != sentence2.length) {
                return false;
            }
            Set<String> pairs = new HashSet();
            for(List<String>  similarPair : similarPairs) {
                pairs.add(similarPair.get(0) + "|" + similarPair.get(1));
            }
            for(int i = 0; i < sentence1.length; i++) {
                if(sentence1[i].equals(sentence2[i])) {
                    continue;
                }
                if(!pairs.contains(sentence1[i] + "|" + sentence2[i])  &&  !pairs.contains(sentence2[i] + "|" + sentence1[i])) {
                    return false;
                }
            }
            return true;
        }
    }
}
