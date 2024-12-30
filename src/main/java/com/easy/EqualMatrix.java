package com.easy;

import java.util.ArrayList;
import java.util.HashMap;
/*
2352. Equal Row and Column Pairs

Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).



Example 1:


Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
Example 2:


Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]


Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
1 <= grid[i][j] <= 105
 */
public class EqualMatrix {

    public int equalPairs(int[][] grid) {
        int count = 0;
        HashMap<ArrayList<Integer>, Integer> rows = new HashMap<>();
        HashMap<ArrayList<Integer>, Integer> cols = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            ArrayList<Integer> arrayList2 = new ArrayList();
            for (int j = 0; j < grid.length; j++) {
                arrayList2.add(grid[j][i]);

            }
            cols.put(arrayList2, cols.getOrDefault(arrayList2, 0) + 1);
            count += rows.getOrDefault(arrayList2, 0);

            ArrayList<Integer> arrayList = new ArrayList();
            for (int j = 0; j < grid.length; j++) {
                arrayList.add(grid[i][j]);
            }
            rows.put(arrayList, rows.getOrDefault(arrayList, 0) + 1);
            count += cols.getOrDefault(arrayList, 0);
        }
        return count;
    }


    public static void main(String[] args) {
        EqualMatrix solution = new EqualMatrix();


        //int[][] grid = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}; // output 3
        //int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};// output 1
        int[][] grid = {{13, 13}, {13, 13}}; // output 4
        solution.printMatrix(grid);
        System.out.println(solution.equalPairs(grid));

    }

    public void printMatrix(int[][] grid) {
        for (int[] row : grid) {
            for (int col : row) {
                System.out.print("  " + col);
            }
            System.out.println();
        }

    }
}

