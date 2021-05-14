package Programmers.LevelTwo;

import java.util.*;

public class NowThatSong {
    public static void main(String[] args){
        String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB",
                "13:00,13:05,WORLD,ABCDEF"};

        NowThatSong nts = new NowThatSong();
        System.out.println(nts.solution(m,musicinfos));
    }
    public String solution(String m, String[] musicinfos){
        String answer = "";
        int answerLen = 0;
        String newM = "";
        for(int i=0; i<m.length(); i++){
            String s = m.charAt(i)+"";
            if(s.equals("#")){
                String p=newM.charAt(newM.length()-1)+"";
                p = p.toLowerCase(Locale.ROOT);
                newM = newM.substring(0,newM.length()-1);
                newM+=p;
            }
            else
                newM+=s;
        }
        for(int i=0; i<musicinfos.length; i++){
            String[] info = musicinfos[i].split(",");

            String[] startTime = info[0].split(":");
            String[] endTime = info[1].split(":");
            int songHour =Integer.parseInt(endTime[0])-
                    Integer.parseInt(startTime[0]);
            int songMin  =Integer.parseInt(endTime[1])-
                    Integer.parseInt(startTime[1]);
            String Title = info[2];
            String Melody = info[3];

            String newMelody = "";
            for(int j=0; j<Melody.length(); j++){
                String s = Melody.charAt(j)+"";
                if(s.equals("#")){
                    String p=newMelody.charAt(newMelody.length()-1)+"";
                    p = p.toLowerCase(Locale.ROOT);
                    newMelody = newMelody.substring(0,newMelody.length()-1);
                    newMelody+=p;
                }
                else
                    newMelody+=s;
            }
            Melody = newMelody;
            int songLen = songHour*60 + songMin;


            if(Melody.length()<songLen){
                while(Melody.length()<songLen){
                    Melody+=Melody;
                }

            }
            Melody = Melody.substring(0, songLen);
            System.out.println(Melody);
            if(Melody.contains(newM)){
                if(answer.length()==0){
                    answer = Title;
                    answerLen = songLen;
                }
                else{
                    if(answerLen<songLen){
                        answer = Title;
                        answerLen = songLen;
                    }
                }
            }
        }
        return answer;
    }
}
