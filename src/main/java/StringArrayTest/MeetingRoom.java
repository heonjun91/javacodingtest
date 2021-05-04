package StringArrayTest;

// 문제 요약 : 회의실에는 하나의 팀만 회의가 가능하다.
// 회의의 시작시간과 끝나는 시간이 주어졌을 때 회의시간이 겹치지 않고
// 모든 회의를 끝낼 수 있다면 true를 리턴하고, 끝낼 수 없다면 false를 리턴하라.

import java.util.Arrays;
import java.util.Comparator;

class Interval{
    int start;
    int end;

    Interval(){
        this.start = 0;
        this.end =0;
    }
    Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }
}

public class MeetingRoom {
    public static void main(String[] args) {
        MeetingRoom mr = new MeetingRoom();

        Interval i1 = new Interval(0,30);
        Interval i2 = new Interval(15,20);
        Interval i3 = new Interval(5,10);

        Interval[] in = {i1,i2,i3};

        System.out.println(mr.solve(in));

    }

    public boolean solve(Interval[] intervals) {
        if(intervals==null){
            return false;
        }
        Arrays.sort(intervals,(a,b)->a.start-b.start);
//        Arrays.sort(intervals, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start-o2.start;
//            }
//        });
        //System.out.println(intervals[1].start);
        for(int i=1; i<intervals.length; i++){
            if(intervals[i-1].end>intervals[i].start)
                return false;
        }
        return true;
    }
}
