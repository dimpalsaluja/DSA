package com.tiyoda.Leetcode;

/***
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 */
public class MaximumAreaOfIsland {

    boolean visited[][];
    int row[] = {-1, 0, 0, 1};
    int col[] = {0, -1, 1, 0};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m + 1][n + 1];
        int max = 0, size;
        for(int i = 0; i < m; i += 1) {
            for(int j = 0; j < n; j += 1) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    size = dfs(i, j, grid, m, n);
                    max = Integer.max(max, size);
                }
            }
        }
        return max;
    }

    public int dfs(int i, int j, int[][] grid, int m, int n) {
        visited[i][j] = true;
        int area = 0;
        for(int k = 0; k < 4; k += 1) {
            int ni = i + row[k];
            int nj = j + col[k];
            if(isValid(ni, nj, m, n) && grid[ni][nj] == 1) {
                area += dfs(ni, nj, grid, m, n);
            }
        }
        return 1 + area;
    }

    private boolean isValid(int i, int j, int m, int n) {
        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j])
            return false;
        return true;
    }

}

/***
 * Complexity Analysis
 *
 * Time Complexity: O(R∗C), where R is the number of rows in the given grid, and
 * C is the number of columns. We visit every square once.
 *
 * Space complexity: O(R∗C), the space used by seen to keep track of visited squares,
 * and the space used by the call stack during our recursion.
 */
