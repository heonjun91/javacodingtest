package Programmers.LevelTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//영어끝말잇기
public class EnglishShiritori {
    public static void main(String[] args){
        int n = 3;
        String[] words={"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        EnglishShiritori es = new EnglishShiritori();
        System.out.println(Arrays.toString(es.solution(n,words)));

    }

    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        List<String> list = new ArrayList<>();
        for(int i=0; i< words.length; i++){
            String cur = words[i];
            if(list.contains(cur)){
                int a = (i%n)+1;
                int b = (i/n)+1;
                answer[0] = a;
                answer[1] = b;
                return answer;
            }
            else if(list.size()!=0&&!list.get(i-1).endsWith(cur.charAt(0)+"")){
                int a = (i%n)+1;
                int b = (i/n)+1;
                answer[0] = a;
                answer[1] = b;
                return answer;
            }
            list.add(cur);
        }

        return answer;
    }
}
