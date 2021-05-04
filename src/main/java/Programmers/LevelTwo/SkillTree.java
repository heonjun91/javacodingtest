package Programmers.LevelTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedOutputStream;

//스킬트리
public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        SkillTree st = new SkillTree();
        System.out.println(st.solution(skill,skill_trees));
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        for(int i=0; i<skill.length(); i++){
            String s = skill.substring(0,i+1);
            list.add(s);
        }

        for(int i=0; i<skill_trees.length; i++){
            String s = skill_trees[i];
            String temp = "";
            for(int j=0; j<s.length(); j++){
                if(skill.contains(s.charAt(j)+"")){
                    temp+=s.charAt(j);
                }
            }
            System.out.println(temp);
            if(temp.equals(""))
                answer++;
            if(list.contains(temp))
                answer++;
        }
        return answer;
    }

}
