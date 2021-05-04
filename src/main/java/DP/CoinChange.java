package DP;
//1원, 2원, 5원 짜리 동전을 가지고 있는 경우 11원을 만드는 경우 최소 동전의 개수
//coins = [1, 2, 5] , amount = 11;
//총 개수는 = 5+5+1 = 3개

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args){
//        int[] coins={1, 2, 5};
//        int amount = 3;
        int[] coins={5,10};
        int amount = 4;
        CoinChange cc = new CoinChange();
        System.out.println(cc.solve(coins,amount));
    }

    public int solve(int[] coins, int amount) {
        if(amount==0)
            return 0;
        int[] dp = new int[amount+1];
        for(int i=0; i<coins.length; i++){
            if(amount<coins[i])
                continue;
            dp[coins[i]] = 1;
        }
        for(int i=1; i<dp.length; i++){
            if(dp[i]==1)
                continue;

            int min = Integer.MAX_VALUE;
            for(int j=0; j<coins.length; j++){
                if(coins[j]<=i){
                    if(dp[i-coins[j]]==0){
                        continue;
                    }
                    if(min>dp[i-coins[j]]+1){
                        min = dp[i-coins[j]]+1;
                        dp[i] = min;
                    }
                }
            }
        }

        if(dp[amount]==0)
            return -1;

        return dp[amount];
    }
}
