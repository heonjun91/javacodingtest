package DFSandBFS;
//문자로 배열이 주어지는데 1은 육지 , 0은 바다라고 주어짐
//바다로 둘러 쌓인 섬 중에서 가장 큰 섬의 크기


import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaxOfIsland {

    private int[] dx = {0,1,0,-1};
    private int[] dy = {1,0,-1,-0};
    private int maxIsland = 0;
    private int cnt = 0;

    public static void main(String[] args) {

        int[][] islandDFS =
                {{1,1,0,1,1},
                {0,1,1,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1},
                {1,0,1,1,1},
                {1,0,1,1,1}};

        int[][] islandBFS =
                        {{1,1,0,1,1},
                        {1,1,1,0,1},
                        {0,0,0,0,1},
                        {1,1,0,1,1},
                        {1,0,1,1,1},
                        {1,0,1,1,1}};
        
        MaxOfIsland mi = new MaxOfIsland();

        mi.solveDFS(islandDFS);
        for(int i=0; i< islandDFS.length; i++){
            System.out.println(Arrays.toString(islandDFS[i]));
        }

        mi.maxIsland = 0;

        mi.solveBFS(islandBFS);
        for(int i=0; i< islandBFS.length; i++){
            System.out.println(Arrays.toString(islandBFS[i]));
        }
        
    }

    public void solveDFS(int[][] island) {
        int n = island.length;
        int m = island[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(island[i][j]==1){
                    cnt=0;
                    dfs(island,i,j);
                    if(maxIsland<cnt){
                        maxIsland = cnt;
                    }
                }
            }
        }
        System.out.println(maxIsland);
    }
    public void dfs(int[][] island,int x, int y){
        island[x][y] = -1;
        cnt++;

        int n = island.length;
        int m = island[0].length;

        for(int i=0; i<4; i++){
            int nextX = x+dx[i];
            int nextY = y+dy[i];

            if(nextX<0||nextY<0||nextX>=n||nextY>=m)
                continue;

            if(island[nextX][nextY]!=1)
                continue;

            dfs(island,nextX,nextY);
        }
    }


    public void solveBFS(int[][] island) {
        int n = island.length;
        int m = island[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(island[i][j]==1){
                    cnt=0;
                    bfs(island,i,j);
                    if(maxIsland<cnt){
                        maxIsland = cnt;
                    }
                }
            }
        }
        System.out.println(maxIsland);
    }

    public void bfs(int[][] island, int x, int y){
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(x,y));
        cnt++;
        island[x][y] = -1;

        int n = island.length;
        int m = island[0].length;

        while(!queue.isEmpty()){
            Point point = queue.poll();

            for(int i=0; i<4; i++){
                int nextX = point.x+dx[i];
                int nextY = point.y+dy[i];

                if(nextX<0||nextY<0||nextX>=n||nextY>=m)
                    continue;

                if(island[nextX][nextY]!=1)
                    continue;

                queue.offer(new Point(nextX,nextY));
                island[nextX][nextY] = -1;
                cnt++;
            }
        }
    }


}
