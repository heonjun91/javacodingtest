package StringArrayTest;

//m x n 행렬이 지정된 경우 행렬의 모든 요소를 나선형 순서로 반환합니다. (달팽이모양탐색)
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]

public class SpiralMatrix {
    int[] dx ={0,1,0,-1};
    int[] dy ={1,0,-1,0};


    public void solve(int[][] arr, int x, int y){
        System.out.println(arr[x][y]);
        arr[x][y] =-1;

        for(int i=0; i<4; i++){
            int nextX = x+dx[i];
            int nextY = y+dy[i];

            if(nextX<0|| nextY<0|| nextX>=arr.length|| nextY>=arr[0].length)
                continue;

            if(arr[nextX][nextY]==-1)
                continue;

            solve(arr,nextX,nextY);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        SpiralMatrix sm = new SpiralMatrix();
        sm.solve(arr,0,0);
    }
}
