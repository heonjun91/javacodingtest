package Programmers.LevelTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Cache {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul",
                "Jeju", "Pangyo", "Seoul",
                "Jeju", "Pangyo", "Seoul"};

        Cache c = new Cache();
        System.out.println(c.solution(cacheSize,cities));
    }
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize==0){
            answer = 5* cities.length;
            return answer;
        }
        List<String> cache = new ArrayList<>();

        for(int i=0; i<cities.length; i++){
            String city = cities[i].toLowerCase();
            if(cache.isEmpty()){
                cache.add(city);

                answer+=5;
            }
            else{
                if(cache.contains(city)){
                    answer+=1;
                    cache.remove(city);
                    cache.add(city);
                }
                else{
                    if(cache.size()<cacheSize)
                        cache.add(city);
                    else {
                        cache.remove(0);
                        cache.add(city);
                    }
                    answer += 5;
                }
            }
            System.out.println(cache);
        }

        return answer;
    }
}
