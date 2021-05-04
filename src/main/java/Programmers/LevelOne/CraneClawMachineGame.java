package Programmers.LevelOne;
//크레인 인형뽑기게임
import java.util.Stack;

public class CraneClawMachineGame {

    public static void main(String[] args){
        int[][] board = {{0,0,0,0,0},
                         {0,0,1,0,3},
                         {0,2,5,0,1},
                         {4,2,4,4,2},
                         {3,5,1,3,1}};

        int[] moves = {1,5,3,5,1,2,1,4};

        CraneClawMachineGame ccmg = new CraneClawMachineGame();
        //ccmg.solve(board,moves);
        System.out.println(ccmg.solve(board,moves));
    }

    public int solve(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<>();
        int result = 0;
        for(int i=0; i<moves.length; i++){
            int idx = moves[i]-1;
            for(int j=0; j<board.length; j++){
                int doll = board[j][idx];
                board[j][idx]=0;

                if(doll==0)
                    continue;
                else{
                    if(basket.isEmpty())
                        basket.push(doll);
                    else if(basket.peek()!=doll) {
                        basket.push(doll);
                    }
                    else {
                        basket.pop();
                        result = result +2;
                    }
                }
                break;
            }
        }
        return result;
    }
}
