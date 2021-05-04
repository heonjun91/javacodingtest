package Programmers.LevelTwo;

import java.util.*;

//카카오- 뉴스 클러스터링
public class NewsClustering {
    public static void main(String[] args) {
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";
        NewsClustering nc = new NewsClustering();
        System.out.println(nc.solution(str1,str2));
    }
    public int solution(String str1, String str2) {
        int answer = 0;

        str1 = str1.toLowerCase(Locale.ROOT);
        str2 = str2.toLowerCase(Locale.ROOT);
        Map<String,Integer> set1 = new HashMap<>();
        Map<String,Integer> set2 = new HashMap<>();
        int set1size = 0;
        int set2size = 0;

        for(int i=0; i<str1.length()-1; i++){
            char a= str1.charAt(i);
            char b= str1.charAt(i+1);
            if(a<97||a>122||b<97||b>122)
                continue;
            String s = a+""+b+"";
            set1.put(s,set1.getOrDefault(s,0)+1);
            set1size++;
        }
        for(int i=0; i<str2.length()-1; i++){
            char a= str2.charAt(i);
            char b= str2.charAt(i+1);
            if(a<97||a>122||b<97||b>122)
                continue;
            String s = a+""+b+"";
            set2.put(s,set2.getOrDefault(s,0)+1);
            set2size++;
        }
        if(set1size==0&&set2size==0)
            return 65536;
        double andCnt = 0;
        if(set1size<=set2size){
            List<String> list = new ArrayList<>(set1.keySet());
            Iterator it = list.iterator();
            while(it.hasNext()){
                String s = String.valueOf(it.next());
                if(set2.containsKey(s)){
                    andCnt+= Math.min(set1.get(s),set2.get(s));
                }
            }
        }
        else{
            List<String> list = new ArrayList<>(set2.keySet());
            Iterator it = list.iterator();
            while(it.hasNext()){
                String s = String.valueOf(it.next());
                if(set1.containsKey(s)){
                    andCnt+= Math.min(set1.get(s),set2.get(s));
                }
            }
        }

        double orCnt = set1size+set2size-andCnt;
        double result = andCnt/orCnt;

        answer = (int)(result*65536);


        return answer;
    }
}
