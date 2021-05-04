package Programmers.LevelTwo;

import java.util.*;

public class MenuRenewal {
    HashMap<String,Integer> menuComb;

    public static void main(String[] args) {

        String[] orders ={"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};

        MenuRenewal mr = new MenuRenewal();
        System.out.println(Arrays.toString(mr.solve(orders,course)));

    }

    public String[] solve(String[] orders, int[] course) {

        List<String> result = new ArrayList<>();
        for(int i=0; i<orders.length; i++){
            char[] order = orders[i].toCharArray();
            Arrays.sort(order);
            orders[i] = String.valueOf(order);
        }

        for(int i=0; i<course.length; i++){
            menuComb = new HashMap<>();
            for(int j=0; j<orders.length; j++){
                combination(orders[j],course[i],0,"");
            }
            List<String> keySetList = new ArrayList<>(menuComb.keySet());
            Collections.sort(keySetList,(a,b)-> menuComb.get(b).compareTo(menuComb.get(a)));
            if(keySetList.size()==0)
                continue;

            int max = menuComb.get(keySetList.get(0));

            for(int k=0; k<keySetList.size(); k++){
                if(max<2){
                    break;
                }
                else if(menuComb.get(keySetList.get(k))==max){
                    result.add(keySetList.get(k));
                }
            }
        }
        String[] answer = new String[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    public void combination(String s, int n, int idx, String comb){
        if(n==0){

            menuComb.put(comb, menuComb.getOrDefault(comb,0)+1);
            return;
        }
        if(idx==s.length())
            return;
        else{
            comb+=s.charAt(idx);
            combination(s,n-1,idx+1,comb);

            comb = comb.substring(0,comb.length()-1);
            combination(s,n,idx+1,comb);
        }
        
    }
}
