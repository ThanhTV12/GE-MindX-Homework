package Lesson15.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Hw004LeetCode1268SearchSuggestionsSystem {

    public static void main(String[] args) {

    }

    // Use trie
    // put all products into trie
    // Node {
    //   list of products whichs travled through
    //}

    // Step 1: create trie
    // Step 2: Search - return list of product when travel through letter

    // time: O(m * n)
    // m: length of products array
    // n: average of product's name's length
    // space: O(m * n + m ^ 2 * n) = O(m^2 * n)
    class Solution {
        public List<List<String>> suggestedProducts(String[] products, String searchproduct) {
            //Step 1 - build trie
            TrieNode root = new TrieNode();
            for(int productId = 0; productId < products.length; productId++) {
                String product = products[productId];
                TrieNode cur = root;
                for(int  i = 0; i < product.length(); i++) {
                    char c = product.charAt(i);
                    if(cur.children[c - 'a'] == null) {
                        cur.children[c - 'a'] = new TrieNode();
                    }
                    cur = cur.children[c - 'a'];
                    cur.listOfproductId.add(productId);
                }
            }

            // Search - print all products which searching letter travels
            List<List<String>> res = new ArrayList();
            TrieNode cur = root;
            for(int  i = 0; i < searchproduct.length(); i++) {
                List<String> output = new ArrayList();
                res.add(output);
                if(cur == null) {
                    continue;
                }
                char c = searchproduct.charAt(i);
                if(cur.children[c - 'a'] == null) {
                    cur = null;
                    continue;
                }
                List<Integer> listOfproductId = cur.children[c - 'a'].listOfproductId;
                output.addAll(print(products, listOfproductId));
                cur = cur.children[c - 'a'];
            }
            return res;
        }

        private List<String> print(String[] products, List<Integer> listOfproductId) {
            List<String> output = new ArrayList();
            for(Integer productId : listOfproductId) {
                output.add(products[productId]);
            }
            Collections.sort(output);
            return output.subList(0, 3);
        }
    }



    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public List<Integer> listOfproductId = new ArrayList();
    }
}
