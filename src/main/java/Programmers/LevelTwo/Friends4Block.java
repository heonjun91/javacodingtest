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

        char[][] map = new char[m][n];
        for(int i=0; i<m; i++){
            map[i] = board[i].toCharArray();
        }

        for(int i=0; i<m; i++){
            System.out.println(Arrays.toString(map[i]));
        }

        return answer;
    }
}
