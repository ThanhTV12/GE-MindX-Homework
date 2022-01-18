package Lesson22_sercurity.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 2-pointer
// times: O(n) n = length of intervals
// space: O(n * 4) = 0(n)
public class LeetCode56MergeIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length < 2) {
                return intervals;
            }
            List<int[]> results = new ArrayList();
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            int l = 0;
            int r = 1;
            while(l < intervals.length) {
                int start = intervals[l][0];
                int end = intervals[l][1];
                while(r < intervals.length && intervals[r][0] <= end) {
                    end = Math.max(end, intervals[r][1]);
                    r++;
                }
                results.add(new int[]{start, end});
                l = r;
                r = l + 1;
            }
            int[][] arrayOuput = new int[results.size()][2];
            int index = 0;
            for(int[] result : results) {
                arrayOuput[index++] = result;
            }
            return arrayOuput;
        }
    }
}
