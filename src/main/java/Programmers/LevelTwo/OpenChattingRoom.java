package Programmers.LevelTwo;

import java.util.Arrays;
import java.util.HashMap;

public class OpenChattingRoom {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                "Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        OpenChattingRoom ocr = new OpenChattingRoom();
        System.out.println(Arrays.toString(ocr.solution(record)));
    }
    public String[] solution(String[] record) {

        HashMap<String,String> map = new HashMap<>();
        int cnt= 0;
        for(int i=0; i<record.length; i++){
            String[] temp = record[i].split(" ");
            if(temp[0].equals("Enter")||temp[0].equals("Leave"))
                cnt++;
            if(temp[0].equals("Enter")||temp[0].equals("Change"))
                map.put(temp[1],temp[2]);
        }
        String[] answer = new String[cnt];
        cnt = 0;
        for(int i=0; i< record.length; i++){
            String[] temp = record[i].split(" ");
            if(temp[0].equals("Enter"))
                answer[cnt++] = map.get(temp[1])+"님이 들어왔습니다.";
            if(temp[0].equals("Leave"))
                answer[cnt++] = map.get(temp[1])+"님이 나갔습니다.";
            else
                continue;
        }

        return answer;
    }
}
