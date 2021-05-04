package Programmers.LevelOne;

import java.text.CollationElementIterator;
import java.util.*;

//[카카오] 실패율
public class FailureRate {
    public static void main(String[] args) {
        int n= 5;
        int[] stages = {1,2,2,1,3};
        FailureRate fr = new FailureRate();
        System.out.println(Arrays.toString(fr.solve(n, stages)));
    }

    public int[] solve(int n, int[] stages) {
        int[] answer = new int[n];
        int[] challenge = new int[n+1];
        int[] fail = new int[n+1];
        for(int i=0; i<stages.length; i++){
            for(int j=1; j<n+1; j++){
                if(stages[i]>=j)
                    challenge[j]++;
                else
                    break;
            }
            if(stages[i]>n)
                continue;
            fail[stages[i]]++;
        }
        Map<Integer,Double> failRate = new HashMap<>();
        for(int i=1; i<n+1; i++){
            if(challenge[i]==0){
                failRate.put(i, 0.0);
            }
            else
            failRate.put(i,(double)fail[i]/(double)challenge[i]);
        }
        List<Map.Entry<Integer,Double>> list =
                new ArrayList<>(failRate.entrySet());

        Collections.sort(list,(a,b)-> b.getValue().compareTo(a.getValue()));

        for(int i=0; i<n; i++){
            answer[i] = list.get(i).getKey();
        }
        return answer;
    }
}
