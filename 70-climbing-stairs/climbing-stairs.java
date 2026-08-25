class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1) return 1;
        int[] dp = new int[n+1];
        
        return dpsolve(n,dp);
    }
    private int dpsolve(int n , int [] dp){
        if(n == 0 || n == 1) return 1;
         
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = dpsolve(n-1,dp) + dpsolve(n-2,dp);

        return dp[n];
    }
}