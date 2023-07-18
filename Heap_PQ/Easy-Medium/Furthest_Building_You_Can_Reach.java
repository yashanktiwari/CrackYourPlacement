/*
DP Solution:
But it will give MLE because of too many recursion calls.
*/
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        
        int[][][] dp = new int[bricks+1][ladders+1][n+1];
        
        for(int[][] temp : dp) {
            for(int[] t : temp) {
                Arrays.fill(t, -1);
            }
        }
        
        return solve(heights, bricks, ladders, 1, dp);
    }
    
    public int solve(int[] arr, int b, int l, int i, int[][][] dp) {
        if(i == arr.length || (arr[i] - arr[i-1] > b && l <= 0)) return i-1;
        
        if(dp[b][l][i] != -1) return dp[b][l][i];
        
        if(arr[i] - arr[i-1] < 0) {
            return dp[b][l][i] = solve(arr, b, l, i+1, dp);
        }
        
        int brick = 0, ladder = 0;
        
        if(arr[i] - arr[i-1] <= b) {
            brick = solve(arr, b-(arr[i]-arr[i-1]), l, i+1, dp);   
        } 
        if(l > 0) {
            ladder = solve(arr, b, l-1, i+1, dp);
        }
        
        return dp[b][l][i] = Math.max(i, Math.max(brick, ladder));
    }
}
