package StringArrayTest;
//정수 숫자의 배열과 정수 표적이 주어지면 두 숫자의 인덱스가 표적에 추가되도록 반환한다.
//각 입력에 정확히 하나의 솔루션이 있다고 가정할 수 있으며, 동일한 요소를 두 번 사용하지 않을 수도 있습니다.
//어떤 순서로든 답변을 반환할 수 있습니다.

import java.util.HashMap;

public class TwoSum {
    public void solve(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                System.out.println(map.get(nums[i])+" "+i);
                break;
            }
            else
            {
                map.put(target-nums[i],i);
            }

        }
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = {2,8,11,14};
        int target = 16;

        ts.solve(nums,target);
    }
}
