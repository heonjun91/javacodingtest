package Programmers.LevelTwo;
//[카카오] 단체사진찍기

import Programmers.LevelOne.TouchKeypad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TakingGroupPhoto {
    List<String> totalList = new ArrayList<>();
    public static void main(String[] args) {
        int n = 2;
        String[] data = {"M~C<2", "C~M>1"};

        TakingGroupPhoto tgp = new TakingGroupPhoto();
        System.out.println(tgp.solve(n,data));
    }

    public int solve(int n, String[] data) {
        boolean[] visited = new boolean[8];
        permutation("ACFJMNRT",visited,0,"");
        int answer = 0;

        for(int i=0; i<data.length; i++){
            String a = data[i].charAt(0)+"";
            String b = data[i].charAt(2)+"";
            char c = data[i].charAt(3);
            int d = Integer.valueOf(data[i].charAt(4)+"");
            List<String> subList = new ArrayList<>();

            for(int j=0; j<totalList.size(); j++){
                int num = Math.abs(totalList.get(j).indexOf(a)-
                        totalList.get(j).indexOf(b))-1;
                if(c=='='){
                    if(num==d){
                        subList.add(totalList.get(j));
                    }
                }
                else if(c=='<'){
                    if(num<d)
                        subList.add(totalList.get(j));
                }
                else{
                    if(num>d)
                        subList.add(totalList.get(j));
                }
            }
            totalList = subList;
        }
        answer = totalList.size();
        return answer;
    }
    public void permutation(String people, boolean[] visited, int n, String per){
        if(n==people.length()){
            totalList.add(per);
        }
        for(int i=0; i<people.length(); i++){
            if(visited[i]==false){
                visited[i] = true;
                per +=people.charAt(i);
                permutation(people,visited,n+1,per);
                visited[i] = false;
                per = per.substring(0,per.length()-1);
            }
        }
    }
}
