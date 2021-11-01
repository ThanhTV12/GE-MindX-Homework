package lesson008.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Hw009LeetCode127WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        //List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        Solution solution = new Solution();
        int length = solution.ladderLength(beginWord, endWord, wordList);
    }

    private static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            wordList.add(beginWord);
            max = wordList.size();
            Map<String, Set<String>> graph = buildGraph(wordList);
            bfs(graph, beginWord, endWord);
            return path;
        }

        Queue<String> queue = new LinkedList<>();
        int path=0;
        int max = 0;
        private void bfs(Map<String, Set<String>> graph, String beginWord, String endWord) {
            if(!graph.containsKey(beginWord) || !graph.containsKey(endWord)) {
                path = 0;
                return;
            }
            queue.add(beginWord);
            while (!queue.isEmpty()) {
                path++;
                if(path > max) {
                    break;
                }
                int currentSize = queue.size();
                for(int i = 0; i < currentSize; i++) {
                    String item = queue.remove();
                    if (endWord.equals(item)) {
                        return;
                    }
                    if(!graph.containsKey(item)) {
                        continue;
                    }
                    for (String connectedItem : graph.get(item)) {
                        if (item.equals(connectedItem)) {
                            continue;
                        }
                        queue.add(connectedItem);
                    }
                    graph.remove(item);
                }
            }
            path = 0;
        }

        private Map<String, Set<String>> buildGraph(List<String> wordList) {
            Map<String, Set<String>> graph = new HashMap<>();
            Map<String, List<String>> mapOfRegexAndWord = createMapOfRegexAndWord(wordList);
            for(String key : mapOfRegexAndWord.keySet()) {
                List<String> words = mapOfRegexAndWord.get(key);
                for(String word : words) {
                    if(graph.containsKey(word)) {
                        graph.get(word).addAll(words);
                    } else {
                        Set<String> adj = new HashSet<>(words);
                        graph.put(word, adj);
                    }
                }
            }
            return graph;
        }

        //hot => %ot  h%t ho%
        private Map<String, List<String>> createMapOfRegexAndWord(List<String> wordList) {
            Map<String, List<String>> graph = new HashMap();
            for(String word : wordList) {
                List<String> regexesOfWords = getRegexesOfWord(word);
                for(String regexesOfWord : regexesOfWords) {
                    pushToGraph(graph, word, regexesOfWord);
                }
            }
            return graph;
        }

        private void pushToGraph(Map<String, List<String>> graph, String word, String regexesOfWord) {
            if(graph.containsKey(regexesOfWord)) {
                graph.get(regexesOfWord).add(word);
            } else {
                List<String> adj = new ArrayList<>();
                adj.add(word);
                graph.put(regexesOfWord, adj);
            }
        }

        private List<String> getRegexesOfWord(String word) {
            List<String> regexes = new ArrayList<>();
            for(int i = 0; i < word.length(); i++) {
                StringBuilder strBuilder = new StringBuilder(word);
                strBuilder.setCharAt(i, '%');
                regexes.add(strBuilder.toString());
            }
            return regexes;
        }
    }
}
