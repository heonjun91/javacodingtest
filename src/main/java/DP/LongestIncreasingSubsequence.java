package DP;

import java.util.Arrays;

//정수 배열 번호가 지정되면 가장 긴 엄격하게 증가하는 시퀀스의 길이를 반환합니다.
//시퀀스는 나머지 요소의 순서를 변경하지 않고
// 일부 또는 없는 요소를 삭제하여 배열에서 파생될 수 있는 시퀀스입니다.
// 예를 들어 [3,6,2,7]은 [0,3,1,6,2,7] 배열의 후속입니다.
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
public class LongestIncreasingSubsequence {
    public static void main(String[] args){
//        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {1,2,3,2,5,2,6,10,4,12};
        LongestIncreasingSubsequence lis =
                new LongestIncreasingSubsequence();
        System.out.println(lis.solve(nums));
    }

    public int solve(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int result=0;
        if(nums.length==1)
            return 1;

        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j])
                    dp[i]= Math.max(dp[i],dp[j]+1);
            }

            result = Math.max(result,dp[i]);
        }

        return result;

    }
}
