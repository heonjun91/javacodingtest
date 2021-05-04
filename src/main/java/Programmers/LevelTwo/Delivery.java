package Programmers.LevelTwo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//배달 왜틀린지 모르겠음
public class Delivery {
    public static void main(String[] args){
        int N = 3;
        int[][] road = {{1,3,1}};
        int K = 1;

        Delivery d = new Delivery();
        System.out.println(d.solution(N,road,K));


    }


    public int solution(int n, int[][] road, int k) {
        int answer = 0;
        boolean[] visited = new boolean[n+1];
        int[] result = new int[n+1];
        if(n==1)
            return answer+1;

        else {
            bfs(road, visited, result, 1);
            for (int i = 2; i < n + 1; i++) {
                if (result[i] <= k && result[i] > 0)
                    answer++;
            }
            System.out.println(Arrays.toString(visited));
            System.out.println(Arrays.toString(result));
            return answer + 1;
        }
    }

    public void bfs(int[][] road, boolean[] visited, int[] result, int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int src = queue.poll();
            for(int i=0; i<road.length; i++){
                int des = 0;
                int dist = road[i][2];
                if(road[i][0]==src)
                    des = road[i][1];
                if(road[i][1]==src)
                    des = road[i][0];

                if(des==0)
                    continue;

                if(!visited[des]){
                    result[des] = result[src]+dist;
                    queue.add(des);
                    visited[des] = true;
                }
                else{
                    result[des] = Math.min(result[src]+dist,result[des]);
                }
            }
        }

    }

}
