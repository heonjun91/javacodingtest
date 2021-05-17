package Programmers.LevelTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//[카카오] 압축
public class Compression {
    public static void main(String[] args){
        String msg = "AAAAAAAAAAAAAAB";

        Compression c = new Compression();
        System.out.println(Arrays.toString(c.solution(msg)));
    }
    public int[] solution(String msg){
        List<String> list = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();
        for(int i=65; i<91; i++){
            char c = (char) i;
            String s = c+"";
            list.add(s);
        }
        int curIdx=0;
        while(msg.length()>curIdx){
            String cur = msg.charAt(curIdx)+"";
            curIdx+=1;
            String next="";
            if(msg.length()>curIdx) {
                next = msg.charAt(curIdx) + "";
                while(list.contains(cur+next)){
                    cur = cur+next;
                    curIdx+=1;
                    if(msg.length()>curIdx) {
                        next = msg.charAt(curIdx) + "";
                    }
                }
            }
            answerList.add(list.indexOf(cur)+1);
            if(msg.length()>curIdx) {
                list.add(cur + next);
            }


        }
        int[] answer = new int[answerList.size()];
        for(int i=0; i< answerList.size(); i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
