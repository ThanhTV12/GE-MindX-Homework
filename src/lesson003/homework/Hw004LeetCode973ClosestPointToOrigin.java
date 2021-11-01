package lesson003.homework;

import lesson003.onclass.Common;

import java.util.Arrays;

public class Hw004LeetCode973ClosestPointToOrigin {

    public static void main(String[] args) {
        //int[][] points = {{1,3},{-2,2}};
        //int k = 1;
        int[][] points = {{3, 3},{5, -1}, {-2, 4}};
        int k = 2;
        Solution solution = new Solution();
        int[][] closest = solution.kClosest(points, k);
    }

    private static class Solution extends Common {
        public int[][] kClosest(int[][] points, int k) {
            return kClosest(points, k, 0, points.length - 1);
        }


        /*
        *   time O(n)
        *   space O(log(n))
        * */
        private int[][] kClosest(int[][] points, int k, int left, int right) {
            int[] pivot = points[getRandomNumber(left, right)];
            int pivotIndex = dutchFlagPartition(points, pivot);
            if(distanceToRoot(points[pivotIndex]) == distanceToRoot(points[k -1])) {
                /*  get closet point that are front of pivot
                 */
                return Arrays.copyOfRange(points, 0, k);
            }
            if(pivotIndex > k - 1) {
                return kClosest(points, k, left, pivotIndex - 1);
            }
            return kClosest(points, k, pivotIndex + 1, right);
        }

        private static int dutchFlagPartition(int[][] points, int[] pivot) {
            int boundaryLeft = -1;
            int distanceToRootOfPivot = distanceToRoot(pivot);
            for(int i = 0; i < points.length; i++) {
                if(distanceToRoot(points[i]) < distanceToRootOfPivot) {
                    boundaryLeft++;
                    swap(points, i, boundaryLeft);
                }
            }
            int boundaryRight = points.length;
            for(int i = points.length - 1; i >= 0; i--) {
                if(distanceToRoot(points[i]) > distanceToRootOfPivot) {
                    boundaryRight--;
                    swap(points, i, boundaryRight);
                }
            }
            return (boundaryLeft + boundaryRight) >> 1;
        }

        private static void swap(int[][] points, int leftIndex, int rightIndex) {
            int[] temp = points[leftIndex];
            points[leftIndex] = points[rightIndex];
            points[rightIndex] = temp;
        }

        private static int distanceToRoot(int[] point) {
            return (int)(Math.pow(point[0], 2) + Math.pow(point[1], 2));
        }
    }
}
