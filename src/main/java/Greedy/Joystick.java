package Greedy;
//조이스틱

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Joystick {
    public static void main(String[] args) {
        String name = "JEROEN";

        Joystick j = new Joystick();
        System.out.println(j.solve(name));
    }

    public int solve(String name) {
        int answer = 0;
        String start = "";
        for(int i=0; i<name.length(); i++){
            start+="A";
        }
        int idx=0;
        while(!start.equals(name)){
            for(int i=idx; i<name.length(); i++){

            }
        }


        System.out.println(answer);
        return answer;

    }
}
