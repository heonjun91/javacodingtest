package DFSandBFS;
//0부터 numCourse - 1까지 레이블이 지정된 총 numCourse 과정이 있습니다.
// 필수 구성 요소 [i] = [ai, bi]는 과정을 수강하려면
// 먼저 수강해야 함을 나타내는 배열 사전 요구 사항이 제공됩니다.
//예를 들어, [0, 1] 쌍은 과정 0을 수강하려면 과정 1을 먼저 수강해야 함을 나타냅니다.
//모든 과정을 마칠 수 있으면 참으로 돌아가십시오. 그렇지 않으면 거짓으로 반환하십시오.

import java.util.LinkedList;
import java.util.Queue;

//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
public class CourseSchedule {
    public static void main(String[] args){
        int course = 6;
        int[][] nums = { { 1, 0 },
                { 2, 1 },
                { 3, 2 },
                { 4, 2 },
                { 3, 1 },
                { 5, 4 }
        };

//        int[][] nums2 = {{ 1, 0 },
//                { 0, 1 } };

        int course2 = 4;
		int[][] nums2 = {
				 { 1, 2 },
		         { 3, 1 },
		         { 2, 3 } };

        CourseSchedule cs = new CourseSchedule();
        System.out.println(cs.solve(course2,nums2));
    }

    public boolean solve(int course, int[][] nums) {
        int[] courseArr = new int[course];
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<nums.length; i++){
            courseArr[nums[i][1]] ++;
        }

        for(int i=0; i<course; i++){
            if(courseArr[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int q= queue.poll();

            for(int i=0; i<nums.length; i++){
                if(nums[i][0]==q){
                    int n = nums[i][1];
                    courseArr[n]--;
                    if(courseArr[n]==0) {
                        queue.add(n);
                    }
                }
            }
        }
        for(int i=0; i<course; i++){
            System.out.println(courseArr[i]);
        }
        for(int i=0; i<course; i++){
            if(courseArr[i]!=0){
                return false;
            }
        }
        return true;

    }

}
