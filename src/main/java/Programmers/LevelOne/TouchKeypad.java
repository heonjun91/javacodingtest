package Programmers.LevelOne;
//[카카오] 키패드 누르기

import java.awt.*;

public class TouchKeypad {

    public static void main(String[] args) {
        int[] numbers = {2,5,8,0};
        String hand ="right";

        TouchKeypad tk = new TouchKeypad();
        System.out.println(tk.solve(numbers,hand));
    }

    public String solve(int[] numbers, String hand) {
        String answer = "";
        int[][] numMap = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-2}};
        Point[] num = new Point[10];
        Point rHand = new Point(3,2);
        Point lHand = new Point(3,0);

        for(int i=0; i<numMap.length; i++){
            for(int j=0; j<numMap[0].length; j++){
                if(numMap[i][j]>=0)
                    num[numMap[i][j]] = new Point(i,j);
            }
        }

        for(int i=0; i<numbers.length; i++){
            if(numbers[i]==1||numbers[i]==4||numbers[i]==7){
                answer += "L";
                lHand = new Point(num[numbers[i]].x,num[numbers[i]].y);
            }
            else if(numbers[i]==3||numbers[i]==6||numbers[i]==9){
                answer += "R";
                rHand= new Point(num[numbers[i]].x,num[numbers[i]].y);
            }
            else {
                int r = Math.abs(rHand.x - num[numbers[i]].x)+
                        Math.abs(rHand.y - num[numbers[i]].y);
                int l = Math.abs(lHand.x - num[numbers[i]].x)+
                        Math.abs(lHand.y - num[numbers[i]].y);

                if (r < l) {
                    answer += "R";
                    rHand = new Point(num[numbers[i]].x, num[numbers[i]].y);
                } else if (l < r) {
                    answer += "L";
                    lHand = new Point(num[numbers[i]].x, num[numbers[i]].y);
                } else {
                    if (hand.equals("right")) {
                        answer += "R";
                        rHand = new Point(num[numbers[i]].x, num[numbers[i]].y);
                    } else {
                        answer += "L";
                        lHand = new Point(num[numbers[i]].x, num[numbers[i]].y);
                    }
                }
            }

        }
        return answer;
    }
}
