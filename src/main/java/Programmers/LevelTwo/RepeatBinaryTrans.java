package Programmers.LevelTwo;

import java.util.Arrays;

//이진변환 반복하기
public class RepeatBinaryTrans {
    public static void main(String[] args) {
        String s = "110010101001";
        RepeatBinaryTrans rbt = new RepeatBinaryTrans();
        System.out.println(Arrays.toString(rbt.solution(s)));
    }
    public int[] solution(String s) {
        int[] answer = new int[2];
        int rotateCnt = 0;
        int zeroCnt = 0;
        while(!s.equals("1")){
            int length = s.length();
            s= s.replace("0","");
            zeroCnt +=length-s.length();
            s = Integer.toBinaryString(s.length());

            rotateCnt++;
        }
        System.out.println(s);
        answer[0] = rotateCnt;
        answer[1] = zeroCnt;
        return answer;
    }
}
