package Programmers.LevelTwo;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class LengthOfVisit {
    public static void main(String[] args) {

        String dirs = "LULLLLLLU";

        LengthOfVisit lv = new LengthOfVisit();
        System.out.println(lv.solution(dirs));
    }

    public int solution(String dirs) {
        int answer = 0;
        int x = 5;
        int y = 5;
        Set<String> set= new HashSet<>();
        for(int i=0; i<dirs.length(); i++){
            int dx = 0;
            int dy = 0;
            if(dirs.charAt(i)=='U'){
                dx+=-1;
            }
            if(dirs.charAt(i)=='D'){
                dx+=1;
            }
            if(dirs.charAt(i)=='R'){
                dy+=1;
            }
            if(dirs.charAt(i)=='L'){
                dy+=-1;
            }
            if(x+dx<0||x+dx>=11||y+dy<0||y+dy>=11)
                continue;
            else{
                int nextX = x+dx;
                int nextY = y+dy;
                String s = x+""+y+""+nextX+""+nextY;
                String s2 = nextX+""+nextY+""+x+""+y;
                x=nextX;
                y=nextY;

                if(!set.contains(s)&&!set.contains(s2)) {
                    set.add(s);
                    answer++;
                }

            }
        }

        return answer;
    }
}
