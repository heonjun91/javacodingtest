package Programmers.LevelTwo;

import java.util.Arrays;

//카카오-프렌즈4블록
public class Friends4Block {
    public static void main(String[] args) {
        int m = 4;
        int n= 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        Friends4Block f4b = new Friends4Block();
        System.out.println(f4b.solution(m,n,board));
    }
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int[][] blockmap = new int[m][n];
        char[][] map = new char[m][n];
        for(int i=0; i<m; i++){
            map[i] = board[i].toCharArray();
        }
        while(blocking(map,m,n,blockmap)){
            answer+=resetting(map,m,n,blockmap);
            blockmap = new int[m][n];
        }
        return answer;
    }
    public boolean blocking(char[][] map, int m, int n ,int[][] blockmap){
        boolean isblock = false;
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                char c = map[i][j];
                if(c==' ')
                    continue;
                if(c==map[i-1][j]&&c==map[i][j-1]&&c==map[i-1][j-1]){
                    isblock = true;
                    blockmap[i-1][j] = 1;
                    blockmap[i][j-1] = 1;
                    blockmap[i-1][j-1] = 1;
                    blockmap[i][j] = 1;
                }
            }
        }
        return isblock;
    }
    public int resetting(char[][] map, int m, int n, int[][] blockmap){
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(blockmap[j][i]==1){
                    cnt++;
                    for(int k=j-1; k>=0; k--){
                        map[k+1][i] = map[k][i];
                        map[k][i]=' ';
                    }
                }
            }
        }
        return cnt;
    }
}
