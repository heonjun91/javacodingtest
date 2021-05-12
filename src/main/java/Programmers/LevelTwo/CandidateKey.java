package Programmers.LevelTwo;

import javax.management.relation.Relation;
import java.util.*;

//후보키
public class CandidateKey {
    public static void main(String[] args){
        String[][] relation={
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}};
        CandidateKey ck = new CandidateKey();
        System.out.println(ck.solution(relation));
    }
    public int solution(String[][] relation) {
        int answer = 0;
        List<List<Integer>> list2 = new ArrayList<>();
        List<String> list = new ArrayList<>();
        combination(0,"",list,relation);
        Collections.sort(list,(a,b)->a.length()-b.length());
        System.out.println(list);

        Iterator it = list.iterator();
        while(it.hasNext()){
            String cur = String.valueOf(it.next());
            Set<String> set = new HashSet<>();
            for(int i=0; i<relation.length; i++){
                String candkey = "";
                for(int j=0; j<cur.length(); j++){
                    int idx = Integer.valueOf(cur.charAt(j)+"");
                    candkey+=relation[i][idx];
                }
                set.add(candkey);
            }
            if(set.size()==relation.length){
                List<Integer> cnd = new ArrayList<>();
                for(int i=0; i<cur.length(); i++){
                    cnd.add(Integer.valueOf(cur.charAt(i)+""));
                }

                if(list2.isEmpty()){
                    list2.add(cnd);
                    //System.out.println(cnd);
                }
                else{
                    boolean b = true;
                    for(int i=0; i<list2.size(); i++){
                        if(cnd.containsAll(list2.get(i))){
                            b = false;
                            break;
                        }
                    }
                    if(b==true)
                        list2.add(cnd);
                }
            }
        }

        answer = list2.size();
        return answer;
    }

    public void combination(int n, String s, List<String> list, String[][] relation){
        if(n== relation[0].length){
            if(s.equals(""))
                return;
            list.add(s);
            return;
        }
        combination(n+1,s+n,list,relation);
        s= s.substring(0,s.length());
        combination(n+1,s,list,relation);
    }
}
