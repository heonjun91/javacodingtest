package StringArrayTest;

import java.util.*;

//주어진 문자열 배열에서 anagram상으로다가 동일한 문자열을 그룹화해서
// 문자열 배열의 배열 형태로 반환하는 문제.
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
//Output: [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();

        String[] str = {"eat", "tea", "tan","ate","nat","bat"};

        ga.solve(str);

    }

    public void solve(String[] str) {

        HashMap<String,List<String>> hm = new HashMap<>();

        for(int i=0; i<str.length; i++){
            char[] tempStr = str[i].toCharArray();
            Arrays.sort(tempStr);
            String sortedStr = String.valueOf(tempStr);

            if(hm.containsKey(sortedStr)){
                hm.get(sortedStr).add(str[i]);
            }
            else{
                List<String> strList = new ArrayList<>();
                strList.add(str[i]);
                hm.put(sortedStr,strList);
            }
        }
        for(int i=0; i<hm.size(); i++){
            System.out.println(hm.entrySet());
        }

    }
}
