package StringArrayTest;

//회의의 시작시간과 끝나는 시간이 주어졌을 때 필요한 회의실의 최소 개수를 리턴

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MeetingRoomTwo {
    public void solve (int[][] nums){
        ArrayList<Interval> al = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            Interval it = new Interval(nums[i][0],nums[i][1]);
            al.add(it);
        }
        Collections.sort(al,(a,b)->a.start-b.start);

        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->a.end-b.end);

        for(int i=0; i<al.size(); i++){
            if(pq.isEmpty()){
                pq.add(al.get(i));
            }
            else if(al.get(i).start<pq.peek().end){
                pq.add(al.get(i));
            }
            else{
                pq.poll();
                pq.add(al.get(i));
            }
        }
        System.out.println(pq.size());
    }
    public static void main(String[] args) {
        MeetingRoomTwo mtr = new MeetingRoomTwo();
        int[][] nums = {{1,4},{4,5},{4,6}};

        mtr.solve(nums);
    }
}
