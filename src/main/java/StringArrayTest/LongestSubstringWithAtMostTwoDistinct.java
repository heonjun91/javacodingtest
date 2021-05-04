package StringArrayTest;

//문자열 S가 주어지면 문자열 S를 분할시킬때 포함된 알파벳이 2개만 존재하는 것 중에서
// 가장 긴 부분문자열의 길이를 리턴

import java.util.HashMap;

public class LongestSubstringWithAtMostTwoDistinct {

    public static void main(String[] args) {
        LongestSubstringWithAtMostTwoDistinct ls = new LongestSubstringWithAtMostTwoDistinct();

        String s = "eeffe";

        ls.solve(s);

    }

    public void solve(String s) {
        int start = 0;
        int end = 0;
        int cnt = 0;
        int maxResult =0;
        HashMap<Character,Integer> hm = new HashMap();

        while(end<s.length()){
            char c = s.charAt(end);
            if(hm.containsKey(c)){
                hm.put(c,hm.get(c)+1);
            }
            else{
                hm.put(c,1);
                cnt++;
            }
            end++;

            if(cnt==3){
                char getKey = s.charAt(start);
                start += hm.get(getKey);
                hm.remove(getKey);
                cnt--;
            }

            maxResult = Math.max(maxResult,end-start);
        }
        System.out.println(maxResult);

    }
}
