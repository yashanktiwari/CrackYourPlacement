/*
Use disjoint set.
Represent all the places of the array with a unique number:
Formual: unique_num = current_row * number_of_cols + current_col;

For all the connecting 1's, union them and find all the components in the disjoint set.
Make sure to check that the ultimate parent of the component has 1 at the place in the grid.

Return the count;
*/

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Disjoint_Set set = new Disjoint_Set(n*m);

        int[] r = {-1, 0, 1, 0};
        int[] c = {0, -1, 0, 1};

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1') {
                    
                    for(int x=0; x<4; x++) {
                        int newr = i + r[x];
                        int newc = j + c[x];

                        if(newr >= 0 && newc >= 0 && newr < n && newc < m && grid[newr][newc] == '1') {
                            if(set.findParent(newr*m + newc) != set.findParent(i*m + j)) {
                                set.unionBySize(newr*m + newc, i*m + j);
                            }
                        }
                    }
                }
            }
        }

        int count = 0;
        for(int i=0; i<set.parent.size(); i++) {
            if(set.parent.get(i) == i) {
                int row = i / m;
                int col = i % m;
                if(grid[row][col] == '1') count++;
            }
        }
        return count;
    }
}
