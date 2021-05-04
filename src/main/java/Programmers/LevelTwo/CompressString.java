package Programmers.LevelTwo;

import java.util.zip.CheckedOutputStream;

public class CompressString {
    public static void main(String[] args){
        String s = "";

        CompressString cs = new CompressString();
        System.out.println(cs.solve(s));
    }

    public int solve(String s) {
        int answer = s.length();


        for(int i=1; i<s.length(); i++){
            String result = "";
            String sub = s;

            while(sub.length()>=i){
                String cur = sub.substring(0,i);

                sub = sub.substring(i);

                int count = 1;
                while(sub.length()>=i&&sub.substring(0,i).equals(cur)){
                    count++;
                    sub = sub.substring(i);
                }
                if(count>1){
                    result+=count+cur;
                }
                else{
                    result+=cur;
                }
            }
            result+=sub;
            answer = Math.min(answer,result.length());
        }

        return answer;
    }
}
