package Programmers.LevelTwo;

import java.util.Arrays;

//삼각달팽이
public class TriangularSnail {
    int[] dx = {1,0,-1};
    int[] dy = {0,1,-1};
    int cnt = 1;
    public static void main(String[] args) {
        int n= 6;
        TriangularSnail ts = new TriangularSnail();
        System.out.println(Arrays.toString(ts.solution(n)));
    }

    public int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2];

        int[][] map = new int[n][n];
        int x = -1;
        int y = 0;
        int num = 0;
        for(int i=0; i<n; i++){
            int j= i%3;

            x = x+dx[j];
            y = y+dy[j];

            while(x>=0&&y>=0&&x<n&&y<n && map[x][y]==0){
                map[x][y] = ++num;
                x = x+dx[j];
                y = y+dy[j];
            }

            x = x-dx[j];
            y = y-dy[j];
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<i+1; j++){
                answer[cnt++] = map[i][j];
            }
        }
        return answer;
    }


}
