package lesson011_2_pointer.other;

import java.util.HashMap;
import java.util.Map;

public class H1w022Leetcode124LongestWellPerformingInterval {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.longestWPI(new int[]{9, 6, 6,6,0,6,6,9, 9, 9, 9});
    }

    //brute force
    // time O(n*n)
    class Solution {
        public int longestWPI(int[] hours) {
            int res = 0;
            for(int i = 0; i < hours.length; i++) {
                int tiringday = 0;
                int nonTiringday = 0;
                for(int j = i; j < hours.length; j++) {
                    if(hours[j] > 8) {
                        tiringday++;
                    } else {
                        nonTiringday++;
                    }
                    if(tiringday > nonTiringday && res < tiringday + nonTiringday) {
                        res = tiringday + nonTiringday;
                    }
                }
            }
            return res;
        }
    }


    private static class Solution2
    {
        int diff;
        public int longestWPI(int[] hours)
        {
            int sum=0;int max=0;int range=0;
            Map<Integer,Integer> map=new HashMap<>();//declaring a new HashMap in order to store the running sum(K) and their corresponding index(V)

            for(int i=0;i<hours.length;i++)//we are traversing the index of the array hours
            {
                sum=sum+(hours[i]>8 ?1:-1);//we are doing the running sum//1 represents the the tireing day and -1 represents the non-tiring day
                if(!map.containsKey(sum))//we are considering only the unique sum as the index is important and we dont want it to overwride
                {
                    map.put(sum,i);//putting the sum and the index i nto the HashMap
                }
                if(sum>0)//if sum is greater than 0 means that the numbers of 1s is greater than the number of -1s
                {
                    max=i+1;//0 based indexing, so +1
                }
                if(map.containsKey(sum-1))//if the map contain the sum-1 key then we can get a range thus an interval between previous and current
                {
                    diff=i-map.get(sum-1);//interval length
                    max=Math.max(max,diff);//we are taking the maximum among the two
                }
            }
            return max;//returnig the maximu subarray length where efficiency or load is maximum for a particular employee
        }
    }
}
