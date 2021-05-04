package Programmers.LevelTwo;
//[카카오] 순위검색 (모르겠음)~~~~~~~~~~~~~

import java.util.Arrays;

public class RankSearch {

    public static void main(String[] args) {
        String[] info={
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};

        String[] query={
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};
        RankSearch rs = new RankSearch();
        System.out.println(rs.solve(info,query));
    }

    public int[] solve(String[] info, String[] query) {
        int[] answer = {};

        String[] a= query[4].split(" and | ");
        String[] b= query[0].split(" ");

        System.out.println(Arrays.toString(a));
        return answer;
    }
}
