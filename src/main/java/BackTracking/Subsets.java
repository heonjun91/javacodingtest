package BackTracking;

import java.util.ArrayList;
import java.util.List;

//중복없는 집합 요소에서 가능한 모든 조합
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
public class Subsets {
    public static void main(String[] args){
        int[] nums = {1,2,4};

        Subsets s = new Subsets();
        s.solve(nums);

    }

    public List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(result,list,nums,0);

        return result;
    }

    public void dfs(List<List<Integer>> result,List<Integer> list,
                    int[] nums, int size) {

        if(size==nums.length){
            result.add(new ArrayList<>(list));
            System.out.println(result);
            return;
        }

        for(int i=0; i<2; i++){
            if(i==0){
                list.add(nums[size]);
                dfs(result,list,nums,size+1);
                list.remove(list.size()-1);
            }
            if(i==1){
                dfs(result,list,nums,size+1);
            }
        }
    }
}
