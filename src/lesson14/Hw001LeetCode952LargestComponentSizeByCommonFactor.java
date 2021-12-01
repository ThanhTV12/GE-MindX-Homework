package lesson14;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hw001LeetCode952LargestComponentSizeByCommonFactor {
    public static void main(String[] args) {

        int[] nums = {4,6,15,35};
        Solution solution = new Solution();
        solution.getFactor(10000);
        //int i = solution.largestComponentSize(nums);
    }

    private static class Solution {
        public int largestComponentSize(int[] nums) {

            for(int num : nums) {
                pushIntoUnionFind(num);
            }
            Map<Integer, Integer> countByRoot = new HashMap();
            int max  = 1;
            for(int num : nums) {
                int rootN =find(num);
                int count;
                if(countByRoot.containsKey(rootN)) {
                    count = countByRoot.get(rootN) + 1;
                    countByRoot.put(rootN, count);
                    if(max < count) {
                        max = count;
                    }
                } else {
                    countByRoot.put(rootN, 1);
                }
            }
            return max;
        }

        Map<Integer, Integer> parent = new HashMap();
        Map<Integer, Integer> rank = new HashMap();
        private void pushIntoUnionFind(int num) {
            Set<Integer> factors = getFactor(num);
            Integer root = find(num);
            for(Integer factor : factors) {
                union(root, factor);
            }
        }

        private int find(int num) {
            if(!parent.containsKey(num)) {
                parent.put(num, num);
                rank.put(num, 0);
                return num;
            }
            if(parent.get(num) == num) {
                return num;
            }
            return find(parent.get(num));
        }


        private void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if(rootU == rootV) {
                return;
            }
            if(rank.get(rootU) == rank.get(rootV)) {
                parent.put(rootV, rootU);
                rank.put(rootU, rank.get(rootU) + 1);
            } else if(rank.get(rootU) > rank.get(rootV)) {
                parent.put(rootV, rootU);
            } else {
                parent.put(rootU, rootV);
            }
        }


        public Set<Integer> getFactor(int n) {
            Set<Integer> res = new HashSet();
            for(int i = 2; i * i <= n; i++) {
                while(n % i == 0) {
                    res.add(i);
                    n = n / i;
                }
            }
            if(n != 1) {
                res.add(n);
            }
            return res;

            //50
            //2 => 25 => 12 => 6 => 3
            //3
        }
    }
}
