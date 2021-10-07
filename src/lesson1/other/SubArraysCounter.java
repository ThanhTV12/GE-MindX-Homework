package lesson1.other;

import java.util.HashSet;
import java.util.Set;

public class SubArraysCounter {
    public static void main(String[] args) {
        int[] A = new int[]{5, -1, 3, 2, 5, 9, 4};
        int S = 5;
        int count = countSubArrays(A, S);
    }
    /*
        Given array A of integers and an integer S, count number of subarray (continuous) that has sum == S.
        Example: A = [5,-1,3,2,9,4]
        S = 5
        return 2;
    */
    private static int countSubArrays(int[] A, int S) {
        System.out.println(A);
        int count = 0;
        Set<Integer> setOfPrefixSum = new HashSet<>();
        int prefixSum = 0;
        for(int i = 0; i < A.length; i++) {
            if(i == 0 && A[i] == S) {
                count++;
            }
            prefixSum += A[i];
            if(setOfPrefixSum.contains(prefixSum - S)) {
                count++;
                setOfPrefixSum.clear();  // Clear to set new starting point
            }
            setOfPrefixSum.add(prefixSum);
        }
        return count;
    }
}
