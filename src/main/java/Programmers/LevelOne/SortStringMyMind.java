package Programmers.LevelOne;

import java.util.Arrays;
import java.util.Collections;

//문자열 내 마음대로 정렬하기
public class SortStringMyMind {
    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        SortStringMyMind ssmm = new SortStringMyMind();
        ssmm.solve(strings,n);
    }

    public String[] solve(String[] strings, int n) {
        String[] answer;
        Arrays.sort(strings,(a,b)->
                a.charAt(n)==b.charAt(n)?
                a.compareTo(b):a.charAt(n)-b.charAt(n));
        answer = strings;

        return answer;
    }
}
