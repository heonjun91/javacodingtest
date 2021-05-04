package StringArrayTest;
// 배열 원소의 끝 부분과 다음 배열의 첫 부분이 겹치면 두 배열을 합쳐라.
//Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]]

import java.util.ArrayList;
import java.util.Collections;

public class MergeInterval {
    public void solve(int[][] nums){
        ArrayList<Interval> al = new ArrayList<>();
        ArrayList<Interval> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            Interval it = new Interval(nums[i][0],nums[i][1]);
            al.add(it);

        }
        Collections.sort(al,(a,b)->a.start-b.start);


        for(int i=1; i< al.size(); i++){
            if(al.get(i).start<=al.get(i-1).end){
                al.get(i).end = Math.max(al.get(i-1).end,al.get(i).end);
                al.get(i).start = al.get(i-1).start;
            }
            else {
                result.add(new Interval(al.get(i-1).start,al.get(i-1).end));
            }
            if(i==al.size()-1){
                result.add(new Interval(al.get(i).start,al.get(i).end));
            }
        }
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i).start+" "+result.get(i).end);
        }

    }
    public static void main(String[] args) {
        int[][] nums = {{1,3},{2,6},{3,7},{10,18},{8,10}};
        MergeInterval mi = new MergeInterval();
        mi.solve(nums);
    }
}
