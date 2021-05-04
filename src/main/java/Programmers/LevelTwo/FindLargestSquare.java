package Programmers.LevelTwo;

public class FindLargestSquare {
    public static void main(String[] args){
        int [][]board = {{0,0,1,1},{1,1,1,1}};

        FindLargestSquare fls = new FindLargestSquare();
        System.out.println(fls.solution(board));
    }

    public int solution(int [][]board)
    {
        int answer = 0;
        if(board.length==1||board[0].length==1) {
            answer = 1;

        }
        else {
            for (int i = 1; i < board.length; i++) {
                for (int j = 1; j < board[0].length; j++) {
                    if(board[i][j]==1){
                        board[i][j] =
                                Math.min(Math.min(board[i-1][j],board[i][j-1]),board[i-1][j-1])+1;
                        if(answer<board[i][j])
                            answer = board[i][j];
                    }
                }
            }
        }

        return answer*answer;
    }
}
