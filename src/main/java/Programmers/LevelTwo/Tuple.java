package Programmers.LevelTwo;
//[카카오] 튜플

import java.util.*;

public class Tuple {
    public static void main(String[] args){
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        Tuple t = new Tuple();
        System.out.println(Arrays.toString(t.solve(s)));
    }

    public int[] solve(String s) {
        String ss="";
        ss = s.replaceAll("\\{|}","");
        String[] sss = ss.split(",");

        Map<Integer,Integer> map = new HashMap();
        for(int i=0; i<sss.length; i++){
            int a = Integer.valueOf(sss[i]);
            map.put(a,map.getOrDefault(a,0)+1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b)->map.get(b)-map.get(a));

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
