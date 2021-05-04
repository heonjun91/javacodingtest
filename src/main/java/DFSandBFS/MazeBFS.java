package DFSandBFS;
//공은 빈 공간과 벽이 있는 미로 속에 있다. 공은 위로, 아래로, 왼쪽 또는 오른쪽으로
// 굴러 빈 공간을 통과할 수 있지만 벽에 부딪힐 때까지 구르는 것을 멈추지 않습니다.
// 공이 멈추면 다음 방향을 선택할 수 있었다.
//볼의 시작 위치, 목적지 및 미로를 고려하여 볼이 목적지에서 멈출 수 있는지 여부를 결정한다.
//미로는 이진 2D 배열로 표현됩니다. 1은 벽을 의미하고 0은 빈 공간을 의미합니다.
// 여러분은 미로의 테두리가 모두 벽이라고 생각할지도 모릅니다.
// 시작 및 대상 좌표는 행 및 열 인덱스로 표시됩니다.
//Input 1: a maze represented by a 2D array
//0 0 1 0 0
//0 0 0 0 0
//0 0 0 1 0
//1 1 0 1 1
//0 0 0 0 0
//Input 2: start coordinate (rowStart, colStart) = (0, 4)
//Input 3: destination coordinate (rowDest, colDest) = (4, 4)
//Output: true



import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class MazeBFS {
    class Point{
        int x;
        int y;


        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};

    public static void main(String[] args){
        int[][] maze= {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        int[] start = {0,4};
        int[] dest = {4,4};
        //int[] dest = {3,2};

        MazeBFS mb = new MazeBFS();
        System.out.println(mb.solve(maze,start,dest));
    }

    public boolean solve(int[][] maze, int[] start, int[] dest) {
        int x = start[0];
        int y = start[1];
        if(x==dest[0]&&y==dest[1])
            return true;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        maze[x][y] = -1; //visited

        while(!queue.isEmpty()){
            Point point = queue.poll();

            for(int i=0; i<4; i++){
                int nextX = point.x+dx[i];
                int nextY = point.y+dy[i];

                while(nextX>=0&&nextY>=0&&nextX<maze.length
                        &&nextY< maze.length&&maze[nextX][nextY]!=1){
                    nextX+=dx[i];
                    nextY+=dy[i];
                }
                nextX-=dx[i];
                nextY-=dy[i];
                if(maze[nextX][nextY]==-1)
                    continue;

                if(nextX==dest[0]&&nextY==dest[1]){
                    return true;
                }
                maze[nextX][nextY]=-1;
                queue.add(new Point(nextX,nextY));

            }
        }
        return false;

    }
}
