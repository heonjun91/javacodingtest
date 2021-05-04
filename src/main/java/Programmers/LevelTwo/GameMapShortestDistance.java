package Programmers.LevelTwo;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//게임맵 최단거리
public class GameMapShortestDistance {
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public static void main(String[] args){
        int[][] maps={{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        GameMapShortestDistance gmsd = new GameMapShortestDistance();
        System.out.println(gmsd.solution(maps));
    }
    public int solution(int[][] maps) {
        int answer = 0;

        bfs(maps,0,0);
        answer = maps[maps.length-1][maps[0].length-1];
        if(answer==1)
            answer = -1;
        return answer;
    }

    public void bfs(int[][] maps, int x, int y) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Point p= queue.poll();

            for(int i=0; i<4; i++){
                int nextX = p.x+dx[i];
                int nextY = p.y+dy[i];

                if(nextX<0||nextY<0||nextX>=maps.length||nextY>=maps[0].length)
                    continue;

                if(maps[nextX][nextY]==0)
                    continue;

                if(visited[nextX][nextY]==true)
                    continue;

                maps[nextX][nextY] = maps[p.x][p.y]+1;
                visited[nextX][nextY] = true;
                queue.add(new Point(nextX,nextY));
            }
        }
    }
}
