package StringArrayTest;

//좌표가 담긴 배열과 K 값이 주어진다.
//원점에서 가까운 좌표 순대로 K개를 뽑아 배열로 리턴하라.

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosest {
    public static void main(String[] args) {
        KClosest kc = new KClosest();

        int[][] points = {{1,3},{-2,2},{0,0}};
        int k = 3;


        kc.solve(points,k);
    }

    public void solve(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b)->(((a[0]*a[0])+(a[1]*a[1]))-((b[0]*b[0])+(b[1]*b[1])))
        );
        for(int i=0; i<points.length; i++){
            pq.add(points[i]);
        }

        for(int i=0; i<k;i++){
            System.out.println(Arrays.toString(pq.poll()));
        }
    }
}
