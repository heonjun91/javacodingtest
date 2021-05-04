package DP;

//로봇은 M x N 그리드의 왼쪽 상단 모서리에 있습니다
// (아래 다이어그램에 '시작'으로 표시됨).
//로봇은 어떤 시점에서도 아래 또는 오른쪽으로만 이동할 수 있습니다.
// 로봇이 그리드의 오른쪽 하단 모서리에 도달하려고 합니다(
// 아래 다이어그램에 '마침'으로 표시됨).
//가능한 고유 경로는 몇 개입니까?
//Input: m = 3, n = 2
//Output: 3

public class UniquePaths {

    public static void main(String[] args){
        int m = 51;
        int n = 9;

        UniquePaths up = new UniquePaths();
        System.out.println(up.solve(m,n));
        System.out.println(up.solveRecursive(m-1,n-1));
    }

    public int solveRecursive(int m, int n) {
        if(m==0||n==0)
            return 1;

        else{
            return solveRecursive(m-1,n)+solveRecursive(m,n-1);
        }
    }

    public int solve(int m, int n) {
        int[][] grid = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0&&j==0)
                    grid[i][j] = 1;
                else if(i-1<0)
                    grid[i][j] = 0+grid[i][j-1];
                else if(j-1<0)
                    grid[i][j] = 0+grid[i-1][j];
                else
                    grid[i][j] = grid[i-1][j]+grid[i][j-1];
            }
        }
        return grid[m-1][n-1];
    }

}
