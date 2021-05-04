package StringArrayTest;

//높이를 나타내는 음이 아닌 정수로 구성된 배열이 주어졌을 때
// 비가 온 후 담기게 될 물의 양을 구하라. 각 bar의 폭은 1이다.
//*************어려움

import java.util.Arrays;
import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = { 0,1,0,2,1,0,1,3,2,1,2,1};

        TrappingRainWater trw = new TrappingRainWater();
        trw.solve(height);
    }

    public void solve(int[] height) {
        int result = 0;

        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int[] minLR = new int[height.length];

        left[0] = height[0];
        right[height.length-1] = height[height.length-1];

        for(int i=0; i<height.length-1; i++){
            if(left[i]>height[i+1]){
                left[i+1] = left[i];
            }
            else
                left[i+1] = height[i+1];
        }
        for(int i=height.length-1; i>0; i--){
            if(right[i]>height[i-1]){
                right[i-1] = right[i];
            }
            else
                right[i-1] = height[i-1];
        }

        for(int i=0; i<height.length; i++){
            result+= Math.min(left[i],right[i])-height[i];
        }

        System.out.println(result);
    }
}
