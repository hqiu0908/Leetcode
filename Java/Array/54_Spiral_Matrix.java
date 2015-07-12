/*

Given a matrix of m x n elements (m rows, n columns), return all elements of the
matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].

*/

// Method 1: Decrease the steps for each new direction

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<Integer>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return results;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = -1;

        // The matrix is not necessary a square.
        // Keep track of the current position and number of steps in both horizontal and
        // vertical directions. As we change direction we decrement the steps in that direction.
        while (true) {
            // Move from left to right, n steps
            for (int i = 0; i < n; i++) {
                results.add(matrix[row][++col]);
            }
            
            // Move from top to bottom, m - 1 steps
            if (--m == 0) {
                break;
            }
            
            for (int i = 0; i < m; i++) { 
                results.add(matrix[++row][col]);
            }
            
            // Move from right to left, n - 1 steps
            if (--n == 0) {
                break;
            }
            
            for (int i = 0; i < n; i++) {
                results.add(matrix[row][--col]);
            }
            
            // Move from bottom to top, m - 2 steps (m has decrement by 1 before)
            if (--m == 0) {
                break;
            }
            
            for (int i = 0; i < m; i++) {
                results.add(matrix[--row][col]);
            }
            
            // Check for next round
            if (--n == 0) {
                break;
            }
        }
        
        return results;
    }
}

// Method 2: Calculate total cycles/rounds


