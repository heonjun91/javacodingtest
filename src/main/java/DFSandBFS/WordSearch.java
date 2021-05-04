package DFSandBFS;
//알파벳이 채워져있는 이차원 배열 board와 찾아야하는 문자열 word가 주어진다.
// 이 때 board에서 이웃한(가로 또는 세로로) 문자를 이어 word를 만들 수 있는지 체크
//Input: board = [["A","B","C","E"],
//                ["S","F","C","S"],
//                ["A","D","E","E"]],
//        word = "ABCCED"
//Output: true

import java.util.Arrays;

public class WordSearch {
    boolean[][] visited;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};

    public static void main(String[] args){
        String[][] board = {{"A","B","C","E"},
                            {"S","F","C","S"},
                            {"A","D","E","E"}};

        String word = "ABCCED";

        WordSearch ws = new WordSearch();
        ws.solve(board,word);

    }

    public void solve(String[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        visited = new boolean[n][m];

        String start = String.valueOf(word.charAt(0));


        boolean result = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j].equals(start)){
                    if(dfs(board,word,visited,i,j,1)){
                        result = true;
                    }
                }
            }
        }
        System.out.println(result);

    }

    public boolean dfs(String[][] board, String word, boolean[][] visited, int x, int y, int wordidx) {
        if(wordidx==word.length())
            return true;

        visited[x][y] = true;


        for(int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= board.length
                    || nextY >= board[0].length) {
                continue;
            }

            if (visited[nextX][nextY] == true) {
                continue;
            }

            if (!board[nextX][nextY].equals(String.valueOf(word.charAt(wordidx)))) {
                continue;
            }
            if (dfs(board, word,visited, nextX, nextY, wordidx + 1))
                return true;
        }
        visited[x][y]=false;

        return false;
    }
}
