package lesson001.homework;

public class Problem3LeetCode304RangeSumQuery2DImmutable {
    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][] {{3, 0, 1, 4, 2},
                                                          {5, 6, 3, 2, 1},
                                                           {1, 2, 0, 1, 5},
                                                            {4, 1, 0, 1, 7},
                                                            {1, 0, 3, 0, 5}});
        int i = numMatrix.sumRegion(1, 1, 2, 2);
    }

    private static class NumMatrix {

        int[][] prefixSums;

        public NumMatrix(int[][] matrix) {
            int angel = 0; //prefixSums[row - 1][col - 1]
            int front = 0; //prefixSums[row - 1][col]
            int left = 0; //prefixSums[row][col - 1]
            int horizontalSize = matrix.length;
            int verticalSize = matrix[0].length;
            for(int row = 0; row < horizontalSize; row++) {
                for(int col = 0; col < verticalSize; col++) {
                    angel = (row == 0 || col == 0) ? 0 : matrix[row - 1][col - 1];
                    front = (row == 0) ? 0 : matrix[row - 1][col];
                    left = (col == 0) ? 0 : matrix[row][col - 1];
                    matrix[row][col] = front + left - angel + matrix[row][col];
                }
            }
            prefixSums = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int prefixOfAngel = (col1 == 0 || row1 == 0) ? 0 : prefixSums[row1 - 1][col1 - 1];
            int prefixOfLeft = (col1 == 0) ? 0 : prefixSums[row2][col1 - 1];
            int prefixOfFront = (row1 == 0) ? 0 : prefixSums[row1 - 1][col2];
            return prefixSums[row2][col2] - prefixOfFront - prefixOfLeft + prefixOfAngel;
        }
    }
}
