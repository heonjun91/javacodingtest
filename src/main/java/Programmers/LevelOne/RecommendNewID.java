package Programmers.LevelOne;
//신규 아이디 추천

import java.util.Locale;

public class RecommendNewID {
    public static void main(String[] args){
        String new_id = "abcdefghijklmn.p";
        RecommendNewID rn = new RecommendNewID();

        rn.solve(new_id);
    }

    public String solve(String new_id) {
        //1. 소문자로
        new_id = new_id.toLowerCase(Locale.ROOT);
        System.out.println("1. "+new_id);

        //2.알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한
        // 모든 문자를 제거합니다.
        String match = "[^0-9a-z\\.\\_\\-]";
        new_id = new_id.replaceAll(match,"");
        System.out.println("2. "+new_id);

        //3. 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        int idx=0;
        String temp = "";
        while(idx<new_id.length()){
            char c = new_id.charAt(idx);
            temp= temp+""+String.valueOf(c);
            if(c=='.'){
                idx++;
                while(idx<new_id.length()){
                    if(new_id.charAt(idx)=='.')
                        idx++;
                    else
                        break;
                }
            }
            else {
                idx++;
            }
        }
        new_id = temp;
        System.out.println("3. "+new_id);

        //4. 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(new_id.length()!=0) {
            if (new_id.charAt(0) == '.')
                new_id = new_id.substring(1);

        }
        if(new_id.length()!=0) {
            if (new_id.charAt(new_id.length() - 1) == '.')
                new_id = new_id.substring(0, new_id.length() - 1);

        }

        System.out.println("4. "+new_id);

        //5.빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(new_id.length()==0)
            new_id = new_id+"a";

        //6.길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한
        // 나머지 문자들을 모두 제거합니다.
        //  만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면
        // 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(new_id.length()>=16){
            new_id = new_id.substring(0,15);
        }
        if(new_id.charAt(new_id.length()-1)=='.')
            new_id = new_id.substring(0,new_id.length()-1);
        System.out.println("6. "+new_id);

        //7.new_id의 길이가 2자 이하라면,
        // new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지
        // 반복해서 끝에 붙입니다.
        if(new_id.length()<=2){
            char c = new_id.charAt(new_id.length()-1);
            while(new_id.length()<3){
                new_id = new_id+c;
            }
        }
        System.out.println("7. "+new_id);
        return new_id;
    }
}
