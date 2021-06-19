package com.tiyoda.Leetcode;

/***
 *Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 *  return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 */
public class NumberOfIslands {
    boolean visited[][];
    int row[] = {-1, 0, 0, 1};
    int col[] = {0, -1, 1, 0};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m + 1][n + 1];
        int max = 0;
        for(int i = 0; i < m; i += 1) {
            for(int j = 0; j < n; j += 1) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid, m, n);
                    max += 1;
                }
            }
        }
        return max;
    }

    public void dfs(int i, int j, char[][] grid, int m, int n) {
        visited[i][j] = true;
        for(int k = 0; k < 4; k += 1) {
            int ni = i + row[k];
            int nj = j + col[k];
            if(isValid(ni, nj, m, n) && grid[ni][nj] == '1') {
                dfs(ni, nj, grid, m, n);
            }
        }
    }

    private boolean isValid(int i, int j, int m, int n) {
        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j])
            return false;
        return true;
    }
}

/***
 * Time complexity : O(M×N) where M is the number of rows and N is the number of columns.
 *
 * Space complexity : worst case O(M×N) in case that the grid map is filled with
 * lands where DFS goes by M×N deep.
 */
