package StringArrayTest;
//subarray 중에 합이 젤 큰 수 리턴


public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray msa = new MaxSubArray();

        //int[] nums = { -2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {0,0};
        msa.solve(nums);
    }

    public void solve(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int maxResult=dp[0];


        for(int i=1; i<nums.length; i++){
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            maxResult = Math.max(maxResult,dp[i]);
        }

        System.out.println(maxResult);
    }
}
