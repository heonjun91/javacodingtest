package Programmers.LevelTwo;
//[카카오] 카카오프렌즈 컬러링북

import java.util.Arrays;

public class ColoringBook {
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    int count = 0;
    boolean[][] visited;

    public static void main(String[] args) {
        int m=6;
        int n=4;
        int[][] picture={{1, 1, 1, 0},
                         {1, 1, 1, 0},
                         {0, 0, 0, 1},
                         {0, 0, 0, 1},
                         {0, 0, 0, 1},
                         {0, 0, 0, 1}};
        ColoringBook cb = new ColoringBook();
        System.out.println(Arrays.toString(cb.solve(m,n,picture)));
    }

    public int[] solve(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];

        visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]!=0&&visited[i][j]==false){
                    count = 0;
                    dfs(picture,i,j,picture[i][j]);
                    maxSizeOfOneArea = Math.max(count,maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public void dfs(int[][] picture, int x, int y, int color) {
        visited[x][y] = true;
        count++;
        for(int i=0; i<4; i++){
            int nextX = x+dx[i];
            int nextY = y+dy[i];

            if(nextX<0||nextX>=picture.length||nextY<0||nextY>=picture[0].length)
                continue;
            if(visited[nextX][nextY]==true)
                continue;
            if(picture[nextX][nextY]!=color)
                continue;

            dfs(picture,nextX,nextY,color);
        }
    }
}
