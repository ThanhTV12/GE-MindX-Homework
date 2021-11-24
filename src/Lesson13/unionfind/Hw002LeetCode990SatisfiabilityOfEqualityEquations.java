package Lesson13.unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hw002LeetCode990SatisfiabilityOfEqualityEquations {

    public static void main(String[] args) {
        String[] equations = {"a==b","c==d","a==c","a!=d"};
        Solution solution = new Solution();
        boolean b = solution.equationsPossible(equations);
    }

    private static class Solution {
        public boolean equationsPossible(String[] equations) {
            List<String> equalForms = new ArrayList<>();
            List<String> unequalForms = new ArrayList<>();
            for(String equation : equations) {
                if(equation.contains("==")) {
                    equalForms.add(equation);
                } else {
                    unequalForms.add(equation);
                }
            }
            initiateUnions(equations);
            makeUnionTrees(equalForms);
            for(String unequalForm : unequalForms) {
                char first = unequalForm.charAt(0);
                char second = unequalForm.charAt(3);
                char rootFirst = find(first);
                char rootSecond = find(second);
                if(rootFirst == rootSecond) {
                    return false;
                }
            }
            return true;
        }


        Map<Character, Character> parent = new HashMap<>();
        Map<Character, Integer> rank = new HashMap<>();
        private Map<Character, Character> makeUnionTrees(List<String> equalForms){
            for(String form : equalForms) {
                char first = form.charAt(0);
                char second = form.charAt(3);
                union(first, second);
            }
            return parent;
        }

        private void initiateUnions(String[] equations) {
            for(String form : equations) {
                char first = form.charAt(0);
                char second = form.charAt(3);
                parent.put(first, first);
                parent.put(second, second);

                rank.put(first, 0);
                rank.put(second, 0);
            }
        }

        private char find(char letter) {
            if(parent.get(letter) == letter) {
                return letter;
            }
            return find(parent.get(letter));
//            parent.put(letter, find(parent.get(letter)));
//            return parent.get(letter);
        }

        private void union(char u, char v) {
            char rootU = find(u);
            char rootV = find(v);
            if(rank.get(rootU) == rank.get(rootV)) {
                parent.put(rootV, rootU);
                rank.put(rootU, rank.get(rootU) + 1);
            } else if(rank.get(rootU) < rank.get(rootV)) {
                parent.put(rootU, rootV);
            } else {
                parent.put(rootV, rootU);
            }
        }
    }
}
