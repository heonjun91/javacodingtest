package BackTracking;
//고유한 정수의 배열 번호가 지정되면 가능한 모든 순열을 반환합니다.
// 어떤 순서로든 답변을 반환할 수 있습니다.
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedOutputStream;

public class Permutation {
    public static void main(String[] args){
        int[] nums = {1,2,3};

        Permutation p = new Permutation();
        System.out.println(p.solve(nums));
    }

    public List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();


        dfs(new ArrayList<>(), nums, result);

        return result;

    }
    public void dfs(List<Integer> list, int[] nums, List<List<Integer>> result ){
        if(list.size()==nums.length) {
            result.add(new ArrayList<>(list));
        }

        for(int i=0; i<nums.length; i++){

            if(list.contains(nums[i]))
                continue;

            list.add(nums[i]);
            dfs(list,nums,result);
            list.remove(list.size()-1);
        }
    }
}
