package Programmers.LevelOne;

import java.util.Arrays;

//예산
public class Budget {
    public static void main(String[] args) {
        int[] d = {2,2,3,3};
        int budget = 10;

        Budget b = new Budget();
        System.out.println(b.solve(d,budget));
    }

    public int solve(int[] d, int budget) {
        int count = 0;

        Arrays.sort(d);

        for(int i=0; i<d.length; i++){
            if(budget-d[i]>=0){
                budget-=d[i];
                count++;
                continue;
            }
            return count;
        }
        return count;
    }
}
