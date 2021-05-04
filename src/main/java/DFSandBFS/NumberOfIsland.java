package DFSandBFS;
//문자로 배열이 주어지는데 1은 육지 , 0은 바다라고 주어져서 바다로 둘러 쌓인 섬의 개수를 구하는 문제

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    private int[] dx = {0,1,0,-1};
    private int[] dy = {1,0,-1,0};
    private int islandCnt = 0;

    private class Point {
        int x;
        int y;

        Point(int x , int y){
            this.x= x;
            this.y= y;
        }
    }



    public static void main(String[] args) {
        char[][] worldDfs = {{'1','1','1','0','1'},
                {'1','1','0','0','0'},
                {'1','1','0','0','1'},
                {'0','0','0','0','1'}};

        char[][] worldBfs = {{'1','1','1','0','1'},
                {'1','1','1','0','1'},
                {'1','1','0','0','1'},
                {'0','0','1','0','1'}};

        NumberOfIsland ni = new NumberOfIsland();
        ni.solveDfs(worldDfs);
        System.out.println(Arrays.toString(worldDfs[0]));
        System.out.println(Arrays.toString(worldDfs[1]));
        System.out.println(Arrays.toString(worldDfs[2]));
        System.out.println(Arrays.toString(worldDfs[3]));

        ni.islandCnt = 0;

        ni.solveBfs(worldBfs);
        System.out.println(Arrays.toString(worldBfs[0]));
        System.out.println(Arrays.toString(worldBfs[1]));
        System.out.println(Arrays.toString(worldBfs[2]));
        System.out.println(Arrays.toString(worldBfs[3]));

    }
    public void solveDfs(char[][] world) {
        for(int i=0; i<world.length; i++){
            for(int j=0; j< world[0].length; j++){
                if(world[i][j]=='1'){

                    dfs(world,i,j);

                    islandCnt++;
                }
            }
        }
        System.out.println(islandCnt);
    }
    public void solveBfs(char[][] world) {
        for(int i=0; i<world.length; i++){
            for(int j=0; j< world[0].length; j++){
                if(world[i][j]=='1'){

                    bfs(world,i,j);

                    islandCnt++;
                }
            }
        }
        System.out.println(islandCnt);
    }

    public void dfs(char[][] world, int x, int y){
        world[x][y] = 'x';

        for(int i=0; i<4; i++){
            int nextX = x+dx[i];
            int nextY = y+dy[i];

            if(nextX<0||nextY<0||nextX>=world.length||nextY>=world[0].length){
                continue;
            }
            if(world[nextX][nextY]!='1'){
                continue;
            }
            dfs(world,nextX,nextY);
        }
    }

    public void bfs(char[][] world, int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));
        world[x][y] = 'x';

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i=0; i<4; i++){
                int nextX =p.x+dx[i];
                int nextY =p.y+dy[i];

                if(nextX<0||nextY<0||nextX>=world.length||nextY>=world[0].length)
                    continue;
                if(world[nextX][nextY]!='1'){
                    continue;
                }

                queue.offer(new Point(nextX,nextY));
                world[nextX][nextY] = 'x';
            }
        }
    }



}
